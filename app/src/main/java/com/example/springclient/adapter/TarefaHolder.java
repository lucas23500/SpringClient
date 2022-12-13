package com.example.springclient.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.springclient.R;

public class TarefaHolder extends RecyclerView.ViewHolder {

    TextView titulo, descricao, dataPrevista, dataConclusao, categoria, status, prioridade, confirmada;


    public TarefaHolder(@NonNull View itemView) {
        super(itemView);
        titulo = itemView.findViewById(R.id.tarefaLista_Nome);
        descricao = itemView.findViewById(R.id.tarefaLista_Descricao);
        dataPrevista = itemView.findViewById(R.id.tarefaLista_DataPrevista);
        dataConclusao = itemView.findViewById(R.id.tarefaLista_DataConclusao);
        categoria = itemView.findViewById(R.id.tarefaLista_Categoria);
        status = itemView.findViewById(R.id.tarefaLista_Status);
        prioridade = itemView.findViewById(R.id.tarefaLista_Prioridade);
        confirmada = itemView.findViewById(R.id.tarefaLista_Confirmada);
    }
}
