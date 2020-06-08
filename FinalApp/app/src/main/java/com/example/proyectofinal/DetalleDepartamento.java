package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleDepartamento extends AppCompatActivity {

    TextView textViewDepartamento, textViewCantidadActivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_departamento);

        textViewDepartamento = (TextView) findViewById(R.id.textViewDepartamento);
        textViewCantidadActivos = (TextView) findViewById(R.id.textViewCasosActivos);

        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("Posicion", 0);
        DetalleDepartamento(id);
    }

    public void DetalleDepartamento(int id){
        BaseDeDatos baseDeDatos = new BaseDeDatos(this, "database", null, 1);
        SQLiteDatabase sqLiteDatabase = baseDeDatos.getReadableDatabase();

        String consulta = "select a.departamento, b.activos " +
                "from departamentos a " +
                "inner join detalleDepartamento b " +
                "on b.idDepartamento = a.idDepartamento " +
                "where a.idDepartamento = " + id;

        Cursor datos = sqLiteDatabase.rawQuery(consulta, null);
        if (!datos.moveToFirst()){
            Toast.makeText(this, "No existen detalles para mostrar.", Toast.LENGTH_LONG).show();
        }else{
            String departamento = datos.getString(0);
            String cantidadActivos = datos.getString(1);

            textViewDepartamento.setText(departamento);
            textViewCantidadActivos.setText(cantidadActivos);
        }
    }

    public void onClickVolver(View view){
        Intent intent = new Intent(this, DepartamentosActivity.class);
        startActivity(intent);
    }
}
