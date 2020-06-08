package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class InicioActivity extends AppCompatActivity {

    EditText etUsuario, etContrasenia;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        etUsuario =(EditText)findViewById(R.id.etUsuario);
        etContrasenia = (EditText)findViewById(R.id.etContrasenia);
        tvError = (TextView)findViewById(R.id.tvError);

        etUsuario.requestFocus();
    }

    /**
     * Método para adjuntar a evento de botón para ingresar.
     * @param view Vista actual.
     */
    public void btnIngresarOnClick(View view){
        tvError.setText("");
        String usuario = etUsuario.getText().toString();
        String contrasenia = etContrasenia.getText().toString();

        if (TextUtils.isEmpty(usuario)){
            etUsuario.setError("Ingrese su usuario");
            etUsuario.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(contrasenia)){
            etContrasenia.setError("Ingrese su contraseña");
            etContrasenia.requestFocus();
            return;
        }

        if (usuario.equals("ELE1") && contrasenia.equals("VIRTUAL")){
            Intent departamentosActivity = new Intent(this, DepartamentosActivity.class);
            startActivity(departamentosActivity);
        }else{
            tvError.setText("El usuario o contraseña son incorrectos.");
        }
    }
}
