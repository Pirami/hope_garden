package com.example.pi_test

import com.example.pi_test.models.MemberVo
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

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
        TODO("Not yet implemented")
        var sql: String = " DROP TABLE IF EXISTS MEMBER "
        db?.execSQL(sql)
        onCreate(db)
    }

    fun chage(activity: String, deceased: List<MemberVo>) {
        var sql = " DROP TABLE IF EXISTS MEMBER "
        var db = this.writableDatabase
        db.execSQL(sql)
        onCreate(db)
        Log.d("activity 결과: " , activity)
        insertMembers(deceased)
        Log.d("insert 결과: " , activity)
    }

    fun insertMembers(deceased: List<MemberVo>) {
        val db = writableDatabase
        for (member in deceased) {
            val statement = db.compileStatement("INSERT INTO ${DatabaseContract.TABLE_NAME} (id, profile, name, sex, chId, title, birth, reborn, death, asleep, userid, created, updater, updated, churchName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
            statement.bindString(1, member.id.toString())
            statement.bindString(2, member.profile)
            statement.bindString(3, member.name)
            statement.bindString(4, member.sex)
            statement.bindString(5, member.chId)
            statement.bindString(6, member.title.toString())
            statement.bindString(7, member.birth)
            statement.bindString(8, member.reborn)
            statement.bindString(9, member.death)
            statement.bindString(10, member.asleep)
            statement.bindString(11, member.userId)
            statement.bindString(12, member.created)
            statement.bindString(13, member.updater)
            statement.bindString(14, member.updated)
            statement.bindString(15, member.churchName)
            statement.executeInsert()
        }
    }
//    fun insert(vo: Member) {
//        var sql = " INSERT INTO MEMBER(name,age,address) " +
//                " VALUES('${vo.name}',${vo.age},'${vo.address}')"
//
//        var db = this.writableDatabase
//        db.execSQL(sql)
//
//    }

    fun delete(name: String) {
        var sql = " DELETE FROM MEMBER WHERE NAME = " +
                "  '${name}' "

        var db = this.writableDatabase
        db.execSQL(sql)

    }

//    fun search(name: String): String {
//        var sql = " SELECT SEQ, NAME, AGE, ADDRESS FROM MEMBER WHERE NAME LIKE" +
//                "'${name}'"
//
//        var db = this.writableDatabase
//        var result = db.rawQuery(sql, null)
//
//        var str: String? = ""
//
//        while (result.moveToNext()) {
//            str += " 번호: " + result.getString(result.getColumnIndex("SEQ")) + " \n " +
//                    "이름: " + result.getString(result.getColumnIndex("NAME")) + " \n " +
//                    "나이: " + result.getString(result.getColumnIndex("AGE")) + " \n " +
//                    "거주지: " + result.getString(result.getColumnIndex("ADDRESS"))
//        }
//
//        if(str == ""){
//            println("검색된 데이터가 없습니다.")
//        }
//
//        return str!!
//
//    }

    fun revise(name: String, age: Int, address: String) {
        var sql = " UPDATE MEMBER SET AGE = '${age}' WHERE NAME ='${name}';"

        var db = this.writableDatabase
        db.execSQL(sql)

        var sql2 = " UPDATE MEMBER SET ADDRESS = '${address}' WHERE NAME ='${name}';"

        var db2 = this.writableDatabase
        db2.execSQL(sql2)

    }

//    fun allMember(): String {
//        var sql = " SELECT * FROM MEMBER"
//
//
//        var db = this.writableDatabase
//        var result = db.rawQuery(sql, null)
//
//        var str: String? = ""
//
//        while (result.moveToNext()) {
//            str +=  "_______________________" +" \n " +" \n " +
//                    " 번호: " + result.getString(result.getColumnIndex("SEQ")) + " \n " +
//                    "이름: " + result.getString(result.getColumnIndex("NAME")) + " \n " +
//                    "나이: " + result.getString(result.getColumnIndex("AGE")) + " \n " +
//                    "거주지: " + result.getString(result.getColumnIndex("ADDRESS")) + " \n "
//        }
//
//
//        return str!!
//    }


}