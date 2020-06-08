package com.example.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {

    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table departamentos(idDepartamento integer primary key, departamento text)");
        db.execSQL("insert into departamentos values(1, 'Ahuachapán')");
        db.execSQL("insert into departamentos values(2, 'Santa Ana')");
        db.execSQL("insert into departamentos values(3, 'Sonsonate')");
        db.execSQL("insert into departamentos values(4, 'Usulután')");
        db.execSQL("insert into departamentos values(5, 'San Miguel')");
        db.execSQL("insert into departamentos values(6, 'Morazán')");
        db.execSQL("insert into departamentos values(7, 'La Unión')");
        db.execSQL("insert into departamentos values(8, 'La Libertad')");
        db.execSQL("insert into departamentos values(9, 'Chalatenango')");
        db.execSQL("insert into departamentos values(10, 'Cuscatlán')");
        db.execSQL("insert into departamentos values(11, 'San Salvador')");
        db.execSQL("insert into departamentos values(12, 'La Paz')");
        db.execSQL("insert into departamentos values(13, 'Cabañas')");
        db.execSQL("insert into departamentos values(14, 'San Vicente')");

        db.execSQL("create table detalleDepartamento(idDepartamento integer primary key, activos integer)");
        db.execSQL("insert into detalleDepartamento values(1, 163)");
        db.execSQL("insert into detalleDepartamento values(2, 194)");
        db.execSQL("insert into detalleDepartamento values(3, 133)");
        db.execSQL("insert into detalleDepartamento values(4, 40)");
        db.execSQL("insert into detalleDepartamento values(5, 133)");
        db.execSQL("insert into detalleDepartamento values(6, 12)");
        db.execSQL("insert into detalleDepartamento values(7, 31)");
        db.execSQL("insert into detalleDepartamento values(8, 266)");
        db.execSQL("insert into detalleDepartamento values(9, 59)");
        db.execSQL("insert into detalleDepartamento values(10, 113)");
        db.execSQL("insert into detalleDepartamento values(11, 1530)");
        db.execSQL("insert into detalleDepartamento values(12, 120)");
        db.execSQL("insert into detalleDepartamento values(13, 36)");
        db.execSQL("insert into detalleDepartamento values(14, 67)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
