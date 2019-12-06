package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.AdaptadorEstudiante;
import BaseDeDatos.PersistenciaEstudiantes;
import Entidades.Estudiante;
import ListenerItem.ListenerClick;

public class Activity_Add extends AppCompatActivity {
    EditText edtID;
    EditText edtNombre;
    EditText edtNota1,edtNota2,edtNota3,edtPromedio;
    Button btninsert;
    PersistenciaEstudiantes dbEstudiantes;
    public int IdEstudiante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__add);
        this.edtID=findViewById(R.id.edtID);
        this.edtNombre=findViewById(R.id.edtNombre);
        this.edtNota1=findViewById(R.id.edtNota1);
        this.edtNota2=findViewById(R.id.edtNota2);
        this.edtNota3=findViewById(R.id.edtNota3);
        this.edtPromedio=findViewById(R.id.edtPromedio);
        this.btninsert=findViewById(R.id.btnInsertar);
        this.IdEstudiante=getIntent().getIntExtra("ID",-1);
        this.dbEstudiantes=new PersistenciaEstudiantes(this);
        if(this.IdEstudiante>0)
        {
            setTitle("Actualizar Dato");
            this.btninsert.setText("Actualizar");
            CargarInfo();
        }
        this.btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IdEstudiante>0)
                {
                    Actualizar();
                }
                else
                    {
                        Agregar();
                    }
            }
        });

    }

    private void CargarInfo() {
        Estudiante estudiante=this.dbEstudiantes.getEstudiante(this.IdEstudiante);
        if(estudiante!=null)
        {
            this.edtID.setText(Integer.toString(estudiante.getID()));
            this.edtNombre.setText(estudiante.getNombre());
            this.edtNota1.setText(String.valueOf(estudiante.getNota1()));
            this.edtNota2.setText(String.valueOf(estudiante.getNota2()));
            this.edtNota3.setText(String.valueOf(estudiante.getNota3()));
            this.edtPromedio.setText(String.valueOf(estudiante.getProedio()));
        }else
            {
                Toast.makeText(this, "Error al cargar la informacion", Toast.LENGTH_SHORT).show();
            }
    }

    public void Agregar()
    {
        Estudiante estudiante=new Estudiante();
        estudiante.setNombre(this.edtNombre.getText().toString());
        estudiante.setNota1(Float.parseFloat(this.edtNota1.getText().toString()));
        estudiante.setNota2(Float.parseFloat(this.edtNota2.getText().toString()));
        estudiante.setNota3(Float.parseFloat(this.edtNota3.getText().toString()));
        float prom=(estudiante.getNota1()+estudiante.getNota3()+estudiante.getNota2())/3;
        estudiante.setProedio(prom);
        if(dbEstudiantes.Insert(estudiante))
        {
            Toast.makeText(this, "Registro Guardado", Toast.LENGTH_SHORT).show();
            finish();
        }else
            {
                Toast.makeText(this, "Ha Ocurrido un error!!", Toast.LENGTH_SHORT).show();
            }
    }
    public void Actualizar()
    {
        Estudiante estudiante=new Estudiante();
        estudiante.setNombre(this.edtNombre.getText().toString());
        estudiante.setID(this.IdEstudiante);
        estudiante.setNota1(Float.parseFloat(this.edtNota1.getText().toString()));
        estudiante.setNota2(Float.parseFloat(this.edtNota2.getText().toString()));
        estudiante.setNota3(Float.parseFloat(this.edtNota3.getText().toString()));
        float prom=(estudiante.getNota1()+estudiante.getNota3()+estudiante.getNota2())/3;
        estudiante.setProedio(prom);
        if(dbEstudiantes.Update(estudiante))
        {
            Toast.makeText(this, "Registro Actualizado", Toast.LENGTH_SHORT).show();
            finish();
        }else
        {
            Toast.makeText(this, "Ha Ocurrido un error!!", Toast.LENGTH_SHORT).show();
        }
    }




}
