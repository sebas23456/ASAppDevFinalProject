package com.example.asappdevfinalproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LoginBase extends SQLiteOpenHelper {
    public static final String SWAP_APP_TABLE = "SwapAppTable";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_EMAIL = "Email";

    public LoginBase(Context context) {
        super(context, "SwapApp.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDatabase = "CREATE TABLE " + SWAP_APP_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USERNAME + " STRING, " + COLUMN_PASSWORD
                + " INTEGER, " + COLUMN_EMAIL + " STRING)";
        db.execSQL(createDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean newUser(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase(); //for 'writing' things into the database
        ContentValues cv = new ContentValues(); //places values in pairs, like hashmap
        cv.put(COLUMN_USERNAME, username);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_EMAIL, "");

        long insert = db.insert(SWAP_APP_TABLE, null, cv);
        db.close();
        if (insert == -1){
            return false;
            // insert is a 'success variable' so if its a positive number,
            // it worked if its a negative one, it didnt work :(
        }

        return true;
    }

    public String check(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        username = "'" + username + "'";
        password = "'" + password + "'";
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ID + " FROM " + SWAP_APP_TABLE + " WHERE "
                + COLUMN_USERNAME + " = " + username + " AND " + COLUMN_PASSWORD + " = " + password + ";", null);
        if(cursor.moveToFirst()){
            return cursor.getString(0);
        }
        return null;
    }

}
