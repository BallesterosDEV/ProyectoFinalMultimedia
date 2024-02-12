package com.example.ballesteroslaraev2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * AdminSQliteOpenHelper class is responsible for managing database creation and version management.
 * It extends the SQLiteOpenHelper class.
 */
public class AdminSQliteOpenHelper extends SQLiteOpenHelper {

    /**
     * Constructor for AdminSQliteOpenHelper.
     * @param context The context to use.
     * @param name The name of the database.
     * @param factory The cursor factory (set to null by default).
     * @param version The database version.
     */
    public AdminSQliteOpenHelper(@Nullable Context context, @Nullable String name,
                                 @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Called when the database is created for the first time.
     * This is where the creation of tables and initial data insertion should happen.
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create characters table
        db.execSQL("CREATE TABLE characters (id INTEGER PRIMARY KEY, name TEXT, race TEXT, height REAL, weight REAL)");

        // Create usuarios table
        db.execSQL("CREATE TABLE usuarios (usuario TEXT PRIMARY KEY, contraseña TEXT)");

        // Insert initial user data
        ContentValues values = new ContentValues();
        values.put("usuario", "Pablito");
        values.put("contraseña", "Abcd1234");
        db.insert("usuarios", null, values);
    }

    /**
     * Called when the database needs to be upgraded.
     * This method will be invoked when the database version has been increased in your application code.
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implementation specific to database version upgrade
        // No action is performed in this method in the current implementation
    }
}