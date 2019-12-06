package Adaptadores;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicaexamen.R;

import ListenerItem.ListenerClick;

public class viewHolderEstudiante extends RecyclerView.ViewHolder {

    private TextView txbNombre;
    private TextView txbID;
    private TextView txbNota1;
    private TextView txbNota2;
    private TextView txbNota3;
    private TextView txbPromedio;
    private Button btnActualizar;
    private Button btnEliminar;

    public viewHolderEstudiante(@NonNull View itemView, ListenerClick onClick) {
        super(itemView);
        this.txbID=itemView.findViewById(R.id.txbID);
        this.txbNombre=itemView.findViewById(R.id.txbNombre);
        this.txbNota1=itemView.findViewById(R.id.txbNota1);
        this.txbNota2=itemView.findViewById(R.id.txbNota2);
        this.txbNota3=itemView.findViewById(R.id.txbNota3);
        this.txbPromedio=itemView.findViewById(R.id.txbPromedio);
        this.btnActualizar=itemView.findViewById(R.id.btnActualizar);
        this.btnActualizar.setOnClickListener(onClick);
        this.btnEliminar=itemView.findViewById(R.id.btnEliminar);
        this.btnEliminar.setOnClickListener(onClick);

    }

    public TextView getTxbNombre() {
        return txbNombre;
    }

    public TextView getTxbID() {
        return txbID;
    }

    public TextView getTxbNota1() {
        return txbNota1;
    }

    public TextView getTxbNota2() {
        return txbNota2;
    }

    public TextView getTxbNota3() {
        return txbNota3;
    }

    public TextView getTxbPromedio() {
        return txbPromedio;
    }

    public Button getBtnActualizar() {
        return btnActualizar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }
}
