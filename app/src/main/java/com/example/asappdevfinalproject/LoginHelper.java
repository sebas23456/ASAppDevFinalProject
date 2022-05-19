package com.example.asappdevfinalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class LoginHelper extends SQLiteAssetHelper {
    public static final String LOGIN_TABLE = "Login_Table";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";

    public LoginHelper(Context context) {
        super(context, "CourseGuide.db", null, 1);
    }

    public String check(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        username = "'" + username + "'";
        password = "'" + password + "'";
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_PASSWORD + "," + COLUMN_USERNAME + " FROM " + LOGIN_TABLE + " WHERE "
                + COLUMN_USERNAME + " = " + username + " AND " + COLUMN_PASSWORD + " = " + password + ";", null);

        if(cursor.moveToFirst()){
            return cursor.getString(0);
        }
        return null;
    }

}
