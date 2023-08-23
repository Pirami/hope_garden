package com.example.pi_test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Dao ==

class DBHelper(context:Context,filename:String):SQLiteOpenHelper(context,filename,null,1) {

    // Singleton
    companion object {
        var dbhelper: DBHelper? = null
        fun getInstance(context: Context, filename: String): DBHelper {
            if (dbhelper == null) {
                dbhelper = DBHelper(context, filename)
            }
            return dbhelper!!
        }

    }


    override fun onCreate(db: SQLiteDatabase?) {
        var sql: String = "CREATE TABLE IF NOT EXISTS MEMBER( " +
                "SEQ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME STRING, " +
                "AGE INTEGER, " +
                "ADDRESS STRING ) "

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var sql : String = " DROP TABLE IF EXISTS MEMBER "
        db?.execSQL(sql)
        onCreate(db)
    }

    fun insert(vo: Member) {
        var sql = " INSERT INTO MEMBER(name,age,address) " +
                " VALUES('${vo.name}',${vo.age},'${vo.address}')"

        var db = this.writableDatabase
        db.execSQL(sql)

    }

    fun delete(name: String) {
        var sql = " DELETE FROM MEMBER WHERE NAME = " +
                "  '${name}' "

        var db = this.writableDatabase
        db.execSQL(sql)

    }

    fun search(name: String): String {
        var sql = " SELECT SEQ, NAME, AGE, ADDRESS FROM MEMBER WHERE NAME LIKE" +
                "'${name}'"

        var db = this.writableDatabase
        var result = db.rawQuery(sql, null)

        var str: String? = ""

        while (result.moveToNext()) {
            str += " 번호: " + result.getString(result.getColumnIndex("SEQ")) + " \n " +
                    "이름: " + result.getString(result.getColumnIndex("NAME")) + " \n " +
                    "나이: " + result.getString(result.getColumnIndex("AGE")) + " \n " +
                    "거주지: " + result.getString(result.getColumnIndex("ADDRESS"))
        }

        if(str == ""){
            println("검색된 데이터가 없습니다.")
        }

        return str!!

    }

    fun revise(name: String, age: Int, address: String) {
        var sql = " UPDATE MEMBER SET AGE = '${age}' WHERE NAME ='${name}';"

        var db = this.writableDatabase
        db.execSQL(sql)

        var sql2 = " UPDATE MEMBER SET ADDRESS = '${address}' WHERE NAME ='${name}';"

        var db2 = this.writableDatabase
        db2.execSQL(sql2)

    }

    fun allMember(): String {
        var sql = " SELECT * FROM MEMBER"


        var db = this.writableDatabase
        var result = db.rawQuery(sql, null)

        var str: String? = ""

        while (result.moveToNext()) {
            str +=  "_______________________" +" \n " +" \n " +
                    " 번호: " + result.getString(result.getColumnIndex("SEQ")) + " \n " +
                    "이름: " + result.getString(result.getColumnIndex("NAME")) + " \n " +
                    "나이: " + result.getString(result.getColumnIndex("AGE")) + " \n " +
                    "거주지: " + result.getString(result.getColumnIndex("ADDRESS")) + " \n "
        }


        return str!!
    }


}