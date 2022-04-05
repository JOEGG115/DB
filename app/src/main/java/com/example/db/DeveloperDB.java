package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DeveloperDB extends SQLiteOpenHelper {


    private static final String NOMBRE_DB="developer.db";
    private static final int VERSION_DB=1;
    private static final String TABLA_REGISTROS="CREATE TABLE IF NOT EXISTS REGISTROS(UBICACION VARCHAR, TELEFONO VARCHAR )";

    public DeveloperDB(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_REGISTROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_REGISTROS);
        sqLiteDatabase.execSQL(TABLA_REGISTROS);

    }

    public void agregarRegistros(String ubicacion, String telefono){
        SQLiteDatabase db=getWritableDatabase();
        if (db!=null){
            db.execSQL("INSERT INTO REGISTROS(UBICACION,TELEFONO) VALUES('" + ubicacion + "', '"+ telefono + "')");
            db.close();
        }
    }
}