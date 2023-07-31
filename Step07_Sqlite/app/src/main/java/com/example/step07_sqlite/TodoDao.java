package com.example.step07_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private DBhelper dbhelper;

    public TodoDao(DBHelper dbhelper){
        this.dbhelper = dbhelper;
    }
    //할일 저장
    public void insert(Todo todo){
        //수정가능한 SQLiteDataBase 객체의 참조값 얻어오기
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        String sql = "INSERT INTO todo " +
                " (content, regdate)" +
                " VALUES(?, datetime('now', 'localtime'))";
        // ? 에 순서대로 바인딩할 인자를 Object[] 에 준비한다.
        Object[] args = {todo.getContent()};
        db.execSQL(sql, args);
        db.close(); // close()를 호출해야 실제로 반영된다.
    }

    //할일 정보를 수정하는 메소드
    public  void update(Todo todo){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        String sql = "UPDATE todo" +
                " SET content = ?" +
                " WHERE num = ?";
        // ?에 바인딩 될 데이터를 배열에 순서대로 담아 execSQL에 전달하면 배열 순서대로 바인딩된다.
        Object[] args = {todo.getContent(), todo.getNum()};
        db.execSQL(sql, args);
        db.close(); // close()를 호출해야 실제로 반영된다.
    }

    public void delete(int num){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        String sql = "DELETE FROM todo" +
                " WHERE num = ?";
        Object[] args = {num};
        db.execSQL(sql, args);
        db.close(); // close()를 호출해야 실제로 반영된다.
    }

    // 할일 1개의 정보를 리턴하는 메소드
    public Todo getData(int num){
        Todo todo = null;
        //읽기전용 SQLiteDataBase 객체의 참조값 얻어오기
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String sql = "SELECT content, regdate" +
                " FROM todo" +
                " WHERE num = ?";
        //query 문에는 String[] 배열에 selection 인자를 준비해야 한다.
        String[] args = {Integer.toString(num)};
        Cursor result = db.rawQuery(sql, args);

        if(result.moveToNext()){
            todo = new Todo();
            todo.setNum(num);
            todo.setContent(result.getString(0));
            todo.setRegdate(result.getString(1));
        }
        return todo;
    }

    public List<Todo> getList() {
        List<Todo> list = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String sql = "SELECT num, content, regdate" +
                " FROM todo" +
                " ORDER BY num ASC";

        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            Todo tmp = new Todo();
            tmp.setNum(cursor.getInt(0));
            tmp.setContent(cursor.getString(1));
            tmp.setRegdate(cursor.getString(2));

            list.add(tmp);
        }

        return list;
    }
}