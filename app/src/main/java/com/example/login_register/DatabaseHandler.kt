package com.example.login_register

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

var DatabaseName="EasyTravel"
var TableName="User"
var col1="Gmail"
var col2="Fname"
var col3="Lname"
var col4="Phone"
var col5="Password"


class DatabaseHandler(var context: Context):SQLiteOpenHelper( context, DatabaseName,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TableName + " (" +
                col1 + " VARCHAR(100) PRIMARY KEY ," +
                col2 + " VARCHAR(256)," +
                col3 + " VARCHAR(256),"+
                col4+ " VARCHAR(256),"+
                col5+ " VARCHAR(256))"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TableName)
        onCreate(db)

    }

    fun InserData(firstname:String,lastname:String,ph:String,mail:String,pass:String){
        val db=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(col1,mail)
        contentValues.put(col2,firstname)
        contentValues.put(col3,lastname)
        contentValues.put(col4,ph)
        contentValues.put(col5,pass)

       val result= db.insert(TableName,null,contentValues)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }


//    fun readData(gmail:String):MutableList<String> {
//
//        var user: MutableList<String> = ArrayList()
//        val db = this.readableDatabase
//        val query = "SELECT * FROM " + TableName+" WHERE Gmail= 'varasharadkulkarni20@pccoepune.org'"
//        var result = db.rawQuery(query, null)
////        user.gmail=result.getColumnName(0)
//
//        if(result.count==-1){
//            Toast.makeText(context,"Error while fetchimg",Toast.LENGTH_SHORT).show()
//        }
//        else if (result.moveToFirst()) {
//            do {
//
//                  user[1]=result.getString(1).toString()
//                  user[2]=result.getString(2).toString()
//                  user[3]=result.getString(3).toString()
//
//            } while (result.moveToNext())
//        }
//
//
//        result.close()
//        db.close()
//        return user
//    }


    fun readData(mail: String): User {
        var list: MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM " + TableName +" WHERE Gmail = 'varad.kulkarni20@pccoepune.org' "
//        var result:Cursor = db.rawQuery(query,null)

        var c:Cursor=db.rawQuery(query,null)

        var user: User= User()
        if(c!=null){
            c.moveToFirst()



            user.gmail=c.getString(0).toString()

            user.pass=c.getString(4).toString()

            user.firstname=c.getString(1).toString()
//            Toast.makeText(context, user.firstname, Toast.LENGTH_SHORT).show()

            user.lastname=c.getString(2).toString()
            user.phone=c.getString(3).toString()

            list.add(user)
        }

//        c.close()
        db.close()
        return user
    }

}