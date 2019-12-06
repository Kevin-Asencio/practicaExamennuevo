package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.AdaptadorEstudiante;
import BaseDeDatos.PersistenciaEstudiantes;
import Entidades.Estudiante;
import ListenerItem.ListenerClick;

public class MainActivity extends AppCompatActivity {
    private ListenerClick OnClickItemlistener;
    List<Estudiante> lista;
    RecyclerView recyclerView;
    Button btnAdd;
    AdaptadorEstudiante adaptadorEstudiante;
    PersistenciaEstudiantes dbEstudiantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lista=new ArrayList<Estudiante>();
        this.recyclerView=findViewById(R.id.rclLista);
        this.btnAdd=findViewById(R.id.btnAdd);
        CargarDatos();
        this.OnClickItemlistener= new ListenerClick() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.btnActualizar:
                    {
                        update(lista.get((int)v.getTag()).getID());
                        break;
                    }
                    case R.id.btnEliminar:
                    {
                        if (delete(lista.get((int)v.getTag()).getID()))
                        {
                            lista.remove((int)v.getTag());
                        }
                        break;
                    }
                }
            }
        };
        this.adaptadorEstudiante = new AdaptadorEstudiante(this.lista, this.OnClickItemlistener);
        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
        //Configuramos el Recycler
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.adaptadorEstudiante);

    }
    public void onResume()
    {
        super.onResume();
        CargarDatos();
        this.adaptadorEstudiante.notifyDataSetChanged();
    }
    private void CargarDatos() {
        this.dbEstudiantes=new PersistenciaEstudiantes(this);
        this.lista.clear();
        this.lista.addAll(0,this.dbEstudiantes.getAll());
        if(this.lista==null||this.lista.size()<0)
        {
            this.lista=new ArrayList<>();
        }
    }
    public  void add()
    {
        Intent intent=new Intent(this,Activity_Add.class);
        startActivity(intent);
    }
    public void update(int id)
    {
        Intent intent=new Intent(this,Activity_Add.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
    public boolean delete(int id)
    {
        Estudiante estudiante=new Estudiante();
        estudiante.setID(id);
        if(this.dbEstudiantes.Delete(estudiante))
        {
            Toast.makeText(this, "SE Elimino con exito", Toast.LENGTH_SHORT).show();
            this.adaptadorEstudiante.notifyDataSetChanged();
            return true;
        }
        else
            {
                Toast.makeText(this, "No se pudo Eliminar!!!", Toast.LENGTH_SHORT).show();
                return false;
            }
    }
}
