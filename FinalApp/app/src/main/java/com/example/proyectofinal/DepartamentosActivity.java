package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DepartamentosActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListarDepartamentos();
    }

    public void ListarDepartamentos(){
        BaseDeDatos baseDeDatos = new BaseDeDatos(this, "database", null, 1);
        SQLiteDatabase sqLiteDatabase = baseDeDatos.getReadableDatabase();
        String consulta = "select departamento from departamentos";
        Cursor datos = sqLiteDatabase.rawQuery(consulta, null);
        if (!datos.moveToFirst()){
            Toast.makeText(this, "No existen departamentos para mostrar.", Toast.LENGTH_LONG).show();
        }else{
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

            do {
                arrayAdapter.add(datos.getString(0));
            }while (datos.moveToNext());

            setListAdapter(arrayAdapter);
        }
    }

    @Override
    public void onListItemClick(ListView lita, View vista, int posicion, long id){



    }
}
