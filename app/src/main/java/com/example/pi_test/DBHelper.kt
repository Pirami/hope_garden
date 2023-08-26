package com.example.pi_test

import com.example.pi_test.models.MemberVo
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.pi_test.models.User
import retrofit2.Callback

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
        var sql: String = "CREATE TABLE IF NOT EXISTS ${DatabaseContract.TABLE_NAME}( " +
//                "id STRING PRIMARY KEY AUTOINCREMENT, " +
                "id STRING, " +
                "profile STRING, " +
                "name STRING, " +
                "sex STRING, " +
                "chId STRING, " +
                "title STRING, " +
                "birth STRING, " +
                "reborn STRING, " +
                "death STRING, " +
                "asleep STRING, " +
                "userid STRING, " +
                "created STRING, " +
                "updater STRING, " +
                "updated STRING, " +
                "churchName STRING ) "

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
        var sql: String = " DROP TABLE IF EXISTS MEMBER "
        db?.execSQL(sql)
        onCreate(db)
    }

    fun upgrade(activity: String) {
        var sql = " DROP TABLE IF EXISTS MEMBER "
        var db = this.writableDatabase
        db.execSQL(sql)
        Log.d("activity 결과: Table DROP 되었습니다." , activity)
        onCreate(db)
        Log.d("activity 결과: Table CREATE 되었습니다." , activity)

//
//        insertMembers(deceased)
//
    }

    fun insertMembers(deceased: MemberVo) {
        val db = writableDatabase
        Log.d("insert 확인: " , deceased.toString())

        val statement = db.compileStatement("INSERT INTO ${DatabaseContract.TABLE_NAME} (id, profile, name, sex, chId, title, birth, reborn, death, asleep, userid, created, updater, updated, churchName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
        if (deceased.id != null) {
            statement.bindString(1, deceased.id)
        }
        if (deceased.profile != null) {
            statement.bindString(2, deceased.profile)
        }
        if (deceased.name != null) {
            statement.bindString(3, deceased.name)
        }
        if (deceased.sex != null) {
            statement.bindString(4, deceased.sex)
        }
        if (deceased.chId != null) {
            statement.bindString(5, deceased.chId)
        }
        if (deceased.title != null) {
            statement.bindString(6, deceased.title)
        }
        if (deceased.birth != null) {
            statement.bindString(7, deceased.birth)
        }
        if (deceased.reborn != null) {
            statement.bindString(8, deceased.reborn)
        }
        if (deceased.death != null) {
            statement.bindString(9, deceased.death)
        }
        if (deceased.asleep != null) {
            statement.bindString(10, deceased.asleep)
        }
        if (deceased.userId != null) {
            statement.bindString(11, deceased.userId)
        }
        if (deceased.created != null) {
            statement.bindString(12, deceased.created)
        }
        if (deceased.updater != null) {
            statement.bindString(13, deceased.updater)
        }
        if (deceased.updated != null) {
            statement.bindString(14, deceased.updated)
        }
        if (deceased.churchName != null) {
            statement.bindString(15, deceased.churchName)
        }
            statement.executeInsert()
//        Log.d("activity 결과: data Insert 되었습니다.", "data 저장완료")
        }

//    fun delete(name: String) {
//        var sql = " DELETE FROM MEMBER WHERE NAME = " +
//                "  '${name}' "
//
//        var db = this.writableDatabase
//        db.execSQL(sql)
//
//    }

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