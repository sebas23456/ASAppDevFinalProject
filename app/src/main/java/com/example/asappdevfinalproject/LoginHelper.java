package com.example.asappdevfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class LoginHelper extends SQLiteAssetHelper {
    public static final String SWAP_APP_TABLE = "SwapAppTable";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_EMAIL = "Email";

    public LoginHelper(Context context) {
        super(context, "CourseGuide.db", null, 1);
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
    public String check(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        username = "'" + username + "'";
        password = "'" + password + "'";
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_EMAIL + " FROM " + SWAP_APP_TABLE + " WHERE "
                + COLUMN_USERNAME + " = " + username + " AND " + COLUMN_PASSWORD + " = " + password + ";", null);
        if(cursor.moveToFirst()){
            return cursor.getString(0);
        }
        return null;
    }

}
