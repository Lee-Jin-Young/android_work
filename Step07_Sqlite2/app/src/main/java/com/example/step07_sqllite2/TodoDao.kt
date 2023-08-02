package com.example.step07_sqllite2

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import java.util.ArrayList

class TodoDao(private val dbhelper: DBHelper) {

    //할일 저장
    fun insert(todo: Todo) {
        //수정가능한 SQLiteDataBase 객체의 참조값 얻어오기
        val db = dbhelper.writableDatabase
        val sql = "INSERT INTO todo" +
                " (content, regdate)" +
                " VALUES(?, datetime('now', 'localtime'))"
        // ? 에 순서대로 바인딩할 인자를 Object[] 에 준비한다.
        val args = arrayOf(todo.content)
        db.execSQL(sql, args)
        db.close() // close()를 호출해야 실제로 반영된다.
    }

    //할일 정보를 수정하는 메소드
    fun update(todo: Todo) {
        val db = dbhelper.writableDatabase
        val sql = "UPDATE todo" +
                " SET content = ?" +
                " WHERE num = ?"
        // ?에 바인딩 될 데이터를 배열에 순서대로 담아 execSQL에 전달하면 배열 순서대로 바인딩된다.
        val args = arrayOf(todo.content, todo.num)
        db.execSQL(sql, args)
        db.close() // close()를 호출해야 실제로 반영된다.
    }

    fun delete(num: Int) {
        val db = dbhelper.writableDatabase
        val sql = "DELETE FROM todo" +
                " WHERE num = ?"
        val args = arrayOf(num)
        db.execSQL(sql, args)
        db.close() // close()를 호출해야 실제로 반영된다.
    }

    // 할일 1개의 정보를 리턴하는 메소드
    fun getData(num: Int): Todo? {
        var todo: Todo? = null
        //읽기전용 SQLiteDataBase 객체의 참조값 얻어오기
        val db = dbhelper.readableDatabase
        val sql = "SELECT content, regdate" +
                " FROM todo" +
                " WHERE num = ?"
        //query 문에는 String[] 배열에 selection 인자를 준비해야 한다.
        val args = arrayOf(num.toString())
        val result = db.rawQuery(sql, args)

        if (result.moveToNext()) {
            todo = Todo(num, result.getString(0), result.getString(1))
        }
        result.close()
        db.close()
        return todo
    }

    fun getList(): List<Todo> {
        val list = ArrayList<Todo>()
        val db = dbhelper.readableDatabase
        val sql = "SELECT num, content, regdate" +
                " FROM todo" +
                " ORDER BY num ASC"

        val cursor = db.rawQuery(sql, null)
        while (cursor.moveToNext()) {
            val tmp = Todo(cursor.getInt(0), cursor.getString(1), cursor.getString(2))

            list.add(tmp)
        }
        cursor.close()
        db.close()

        return list
    }
}
