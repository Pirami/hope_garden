package com.example.pi_test

import com.example.pi_test.models.MemberVo
import com.example.pi_test.models.MemberFamilyVo
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.pi_test.models.GestBookVo
import com.example.pi_test.models.Search

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
        var sql: String = "CREATE TABLE IF NOT EXISTS ${DatabaseContract.MEMBER_TABLE_NAME}( " +
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
//        추후 for문으로 돌리기 table 3개
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
    }

    fun insertGestBook(deceased: GestBookVo) {
        val db = writableDatabase
        Log.d("insert 확인: " , deceased.toString())

        val statement = db.compileStatement("INSERT INTO ${DatabaseContract.GESTBOOK_TABLE_NAME} (id, aId, userid, gname, comment, pw, created) VALUES (?, ?, ?, ?, ?, ?, ?)")
        if (deceased.id != null) {
            statement.bindString(1, deceased.id)
        } else {
            statement.bindString(1, "Null")
        }
        if (deceased.aId != null) {
            statement.bindString(2, deceased.aId)
        } else {
            statement.bindString(2, "Null")
        }
        if (deceased.userid != null) {
            statement.bindString(3, deceased.userid)
        } else {
            statement.bindString(3, "Null")
        }
        if (deceased.gname != null) {
            statement.bindString(4, deceased.gname)
        } else {
            statement.bindString(4, "Null")
        }
        if (deceased.comment != null) {
            statement.bindString(5, deceased.comment)
        } else {
            statement.bindString(5, "Null")
        }
        if (deceased.pw != null) {
            statement.bindString(6, deceased.pw)
        } else {
            statement.bindString(6, "Null")
        }
        if (deceased.created != null) {
            statement.bindString(7, deceased.created)
        } else {
            statement.bindString(7, "Null")
        }
        statement.executeInsert()
//        Log.d("activity 결과: data Insert 되었습니다.", "data 저장완료")
    }

fun insertMembersFamily(deceased: MemberFamilyVo) {
    val db = writableDatabase
    Log.d("insert 확인: " , deceased.toString())

    val statement = db.compileStatement("INSERT INTO ${DatabaseContract.FAMILY_TABLE_NAME} (id, aId, chId, name, relationship, phone, userid, created, insort, fa_churchname, as_name, as_sex, profile, death, as_churchname) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
    if (deceased.id != null) {
        statement.bindString(1, deceased.id)
    } else {
        statement.bindString(1, "Null")
    }
    if (deceased.aId != null) {
        statement.bindString(2, deceased.aId)
    } else {
        statement.bindString(2, "Null")
    }
    if (deceased.name != null) {
        statement.bindString(3, deceased.name)
    } else {
        statement.bindString(3, "Null")
    }
    if (deceased.relationship != null) {
        statement.bindString(4, deceased.relationship)
    } else {
        statement.bindString(4, "Null")
    }
    if (deceased.phone != null) {
        statement.bindString(5, deceased.phone)
    } else {
        statement.bindString(5, "Null")
    }
    if (deceased.userid != null) {
        statement.bindString(6, deceased.userid)
    } else {
        statement.bindString(6, "Null")
    }
    if (deceased.created != null) {
        statement.bindString(7, deceased.created)
    } else {
        statement.bindString(7, "Null")
    }
    if (deceased.insort != null) {
        statement.bindString(8, deceased.insort)
    } else {
        statement.bindString(8, "Null")
    }
    if (deceased.fa_churchname != null) {
        statement.bindString(9, deceased.fa_churchname)
    } else {
        statement.bindString(9, "Null")
    }
    if (deceased.as_name != null) {
        statement.bindString(10, deceased.as_name)
    } else {
        statement.bindString(10, "Null")
    }
    if (deceased.as_sex != null) {
        statement.bindString(11, deceased.as_sex)
    } else {
        statement.bindString(11, "Null")
    }
    if (deceased.profile != null) {
        statement.bindString(12, deceased.profile)
    } else {
        statement.bindString(12, "Null")
    }
    if (deceased.death != null) {
        statement.bindString(13, deceased.death)
    } else {
        statement.bindString(13, "Null")
    }
    if (deceased.as_churchname != null) {
        statement.bindString(14, deceased.as_churchname)
    } else {
        statement.bindString(14, "Null")
    }
    statement.executeInsert()
//        Log.d("activity 결과: data Insert 되었습니다.", "data 저장완료")
}

    fun insertMembers(deceased: MemberVo) {
        val db = writableDatabase
        Log.d("insert 확인: " , deceased.toString())

        val statement = db.compileStatement("INSERT INTO ${DatabaseContract.MEMBER_TABLE_NAME} (id, profile, name, sex, chId, title, birth, reborn, death, asleep, userid, created, updater, updated, churchName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
        if (deceased.id != null) {
            statement.bindString(1, deceased.id)
        } else {
            statement.bindString(1, "Null")
        }
        if (deceased.profile != null) {
            statement.bindString(2, deceased.profile)
        } else {
            statement.bindString(2, "Null")
        }
        if (deceased.name != null) {
            statement.bindString(3, deceased.name)
        } else {
            statement.bindString(3, "Null")
        }
        if (deceased.sex != null) {
            statement.bindString(4, deceased.sex)
        } else {
            statement.bindString(4, "Null")
        }
        if (deceased.chId != null) {
            statement.bindString(5, deceased.chId)
        } else {
            statement.bindString(5, "Null")
        }
        if (deceased.title != null) {
            statement.bindString(6, deceased.title)
        } else {
            statement.bindString(6, "Null")
        }
        if (deceased.birth != null) {
            statement.bindString(7, deceased.birth)
        } else {
            statement.bindString(7, "Null")
        }
        if (deceased.reborn != null) {
            statement.bindString(8, deceased.reborn)
        } else {
            statement.bindString(8, "Null")
        }
        if (deceased.death != null) {
            statement.bindString(9, deceased.death)
        } else {
            statement.bindString(9, "Null")
        }
        if (deceased.asleep != null) {
            statement.bindString(10, deceased.asleep)
        } else {
            statement.bindString(10, "Null")
        }
        if (deceased.userId != null) {
            statement.bindString(11, deceased.userId)
        } else {
            statement.bindString(11, "Null")
        }
        if (deceased.created != null) {
            statement.bindString(12, deceased.created)
        } else {
            statement.bindString(12, "Null")
        }
        if (deceased.updater != null) {
            statement.bindString(13, deceased.updater)
        } else {
            statement.bindString(13, "Null")
        }
        if (deceased.updated != null) {
            statement.bindString(14, deceased.updated)
        } else {
            statement.bindString(14, "Null")
        }
        if (deceased.churchName != null) {
            statement.bindString(15, deceased.churchName)
        } else {
            statement.bindString(15, "Null")
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

    fun MembersFamily(name: String): MutableList<Search> {
        var sql = " SELECT id, profile, name, sex, chId, title, birth, reborn, death, asleep, userid, created, updater, updated, churchName FROM MEMBER WHERE name LIKE" +
                "'%${name}%'"

        var db = this.writableDatabase
        var result = db.rawQuery(sql, null)

        var str: String? = ""

//        while (result.moveToNext()) {
//            str += //" 사진: " + result.getString(result.getColumnIndex("profile")) + " \n " +
//                    "성명: " + result.getString(result.getColumnIndex("name")) + " \n " +
//                    "교회명: " + result.getString(result.getColumnIndex("churchName")) + " \n " +
//                    "소천일: " + result.getString(result.getColumnIndex("death"))
//        }
        val users = mutableListOf<Search>()
        while (result.moveToNext()) {
            val id = result.getString(result.getColumnIndex("id"))
            val profile = result.getString(result.getColumnIndex("profile"))
            val name = result.getString(result.getColumnIndex("name"))
            val death = result.getString(result.getColumnIndex("death"))
            val churchName = result.getString(result.getColumnIndex("churchName"))
            val asleep = result.getString(result.getColumnIndex("asleep"))

            val sex = result.getString(result.getColumnIndex("sex"))
//            val chId = result.getString(result.getColumnIndex("chId"))
//            val title = result.getString(result.getColumnIndex("title"))
            val birth = result.getString(result.getColumnIndex("birth"))
            val reborn = result.getString(result.getColumnIndex("reborn"))
//            val userid = result.getString(result.getColumnIndex("userid"))
//            val created = result.getString(result.getColumnIndex("created"))
//            val updater = result.getString(result.getColumnIndex("updater"))
//            val updated = result.getString(result.getColumnIndex("updated"))

            val user = Search(id, profile, name, death, churchName, reborn, sex, birth, asleep)
            users.add(user)
//            str += users
        }
        if(str == ""){
            println("검색된 데이터가 없습니다.")
        }

        return users //str!!

    }


    fun search(name: String): MutableList<Search> {
        var sql = " SELECT id, profile, name, sex, chId, title, birth, reborn, death, asleep, userid, created, updater, updated, churchName FROM MEMBER WHERE name LIKE" +
                "'%${name}%'"

        var db = this.writableDatabase
        var result = db.rawQuery(sql, null)

        var str: String? = ""

//        while (result.moveToNext()) {
//            str += //" 사진: " + result.getString(result.getColumnIndex("profile")) + " \n " +
//                    "성명: " + result.getString(result.getColumnIndex("name")) + " \n " +
//                    "교회명: " + result.getString(result.getColumnIndex("churchName")) + " \n " +
//                    "소천일: " + result.getString(result.getColumnIndex("death"))
//        }
        val users = mutableListOf<Search>()
        while (result.moveToNext()) {
            val id = result.getString(result.getColumnIndex("id"))
            val profile = result.getString(result.getColumnIndex("profile"))
            val name = result.getString(result.getColumnIndex("name"))
            val death = result.getString(result.getColumnIndex("death"))
            val churchName = result.getString(result.getColumnIndex("churchName"))
            val asleep = result.getString(result.getColumnIndex("asleep"))

            val sex = result.getString(result.getColumnIndex("sex"))
//            val chId = result.getString(result.getColumnIndex("chId"))
//            val title = result.getString(result.getColumnIndex("title"))
            val birth = result.getString(result.getColumnIndex("birth"))
            val reborn = result.getString(result.getColumnIndex("reborn"))
//            val userid = result.getString(result.getColumnIndex("userid"))
//            val created = result.getString(result.getColumnIndex("created"))
//            val updater = result.getString(result.getColumnIndex("updater"))
//            val updated = result.getString(result.getColumnIndex("updated"))

            val user = Search(id, profile, name, death, churchName, reborn, sex, birth, asleep)
            users.add(user)
//            str += users
        }
        if(str == ""){
            println("검색된 데이터가 없습니다.")
        }

        return users //str!!

    }

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