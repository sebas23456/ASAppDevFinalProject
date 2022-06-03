package com.example.asappdevfinalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.text.SimpleDateFormat;


public class LoginHelper extends SQLiteAssetHelper {
    public static final String LOGIN_TABLE = "LOGIN";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String STUDENT_ID = "STUDENTID";
    public static final String LOGIN_TIME = "LOGINTIME";

    public LoginHelper(Context context) {
        super(context, "CourseGuide.db", null, 1);
    }

    public String check(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        username = "'" + username + "'";
        password = "'" + password + "'";
        Cursor pass_check = db.rawQuery("SELECT " + COLUMN_PASSWORD + " FROM " + LOGIN_TABLE + " WHERE "
                + COLUMN_USERNAME + " = " + username + " AND " + COLUMN_PASSWORD + " = " + password + ";", null);
        if (pass_check.moveToFirst()) {
            String act_pass = pass_check.getString(0);
            if (password.equals(act_pass)) {
                SET_CURRENT(username);
                return act_pass;
            }
        }
        Cursor temp_pass = db.rawQuery("SELECT " + STUDENT_ID + " FROM " + LOGIN_TABLE + " WHERE "
                + COLUMN_USERNAME + " = " + username + " AND " + STUDENT_ID + " = " + password + ";", null);
        if (temp_pass.moveToFirst()) {
            SET_CURRENT(username);
            return "PASS_NEEDS_SET";
        }
        return null;
    }

    public void SET_PASSWORD(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.rawQuery("UPDATE " + LOGIN_TABLE + " SET " + COLUMN_PASSWORD + " = " + password + "" + " WHERE " + COLUMN_USERNAME + " = " + username + ";", null);
    }

    public void SET_CURRENT(String username) {
        String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        SQLiteDatabase db = this.getReadableDatabase();
        db.rawQuery("UPDATE " + LOGIN_TABLE + " SET " + LOGIN_TIME + " = " + time + "" + " WHERE " + COLUMN_USERNAME + " = " + username + ";", null);
    }

    public String CHECK_CURRENT() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor current = db.rawQuery(" SELECT " + COLUMN_USERNAME + " FROM " + LOGIN_TABLE + " WHERE " + LOGIN_TIME + " IS NOT NULL " + "; ", null);
        if (current.moveToFirst()) {
            return current.getString(0);
        }
        return null;
    }
}
