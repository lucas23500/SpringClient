package com.example.springclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.springclient.R;
import com.example.springclient.model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaHolder> {


    private List<Tarefa> tarefaList;

    public TarefaAdapter(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList;
    }

    @NonNull
    @Override
    public TarefaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tarefa_item, parent, false);
        return new TarefaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaHolder holder, int position) {
        Tarefa tarefa = tarefaList.get(position);
        Boolean x = tarefa.getConfirmada().booleanValue();
        holder.titulo.setText("Titulo: " + tarefa.getTitulo());
        holder.descricao.setText("Descrição: " + tarefa.getDescricao());
        holder.dataPrevista.setText("Data Prevista: " + tarefa.getDataPrevista());
        holder.dataConclusao.setText("Data Conclusão: " + tarefa.getDataConclusao());
        holder.categoria.setText("Categoria: " + tarefa.getCategoria().getTitulo());
        holder.status.setText("Status: " + tarefa.getStatus().getTitulo());
        holder.prioridade.setText("Prioridade: " + tarefa.getPrioridade().getTitulo());
        if(x){
            holder.confirmada.setText("Confirmada: sim " );
        }else {

            holder.confirmada.setText("Confirmada: não " );
        }

    }

    @Override
    public int getItemCount() {
        return tarefaList.size();
    }
}
