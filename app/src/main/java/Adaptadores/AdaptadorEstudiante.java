package Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicaexamen.R;

import java.util.List;

import Entidades.Estudiante;
import ListenerItem.ListenerClick;

public class AdaptadorEstudiante extends RecyclerView.Adapter <viewHolderEstudiante>{
    List<Estudiante> source;
    private ListenerClick OnClick;

    public AdaptadorEstudiante(List<Estudiante> list,ListenerClick onCLick)
    {
        this.source=list;
        this.OnClick=onCLick;
    }
    @NonNull
    @Override
    public viewHolderEstudiante onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiante,parent,false);
        viewHolderEstudiante vh=new viewHolderEstudiante(v,this.OnClick);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderEstudiante holder, int position) {
        holder.getBtnActualizar().setTag(position);
        holder.getBtnEliminar().setTag(position);
        holder.getTxbID().setText(String.valueOf(this.source.get(position).getID()));
        holder.getTxbNombre().setText(this.source.get(position).getNombre());
        holder.getTxbNota1().setText(String.valueOf(this.source.get(position).getNota1()));
        holder.getTxbNota2().setText(String.valueOf(this.source.get(position).getNota2()));
        holder.getTxbNota3().setText(String.valueOf(this.source.get(position).getNota3()));
        holder.getTxbPromedio().setText(String.valueOf(this.source.get(position).getProedio()));
    }

    @Override
    public int getItemCount() {
        return this.source.size();
    }
}
