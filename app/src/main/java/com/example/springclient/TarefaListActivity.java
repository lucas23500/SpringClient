package com.example.springclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.springclient.adapter.TarefaAdapter;
import com.example.springclient.model.Tarefa;
import com.example.springclient.retrofit.RetrofitService;
import com.example.springclient.retrofit.TarefaApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TarefaListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_list);

        recyclerView = findViewById(R.id.tarefaLista_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton floatingActionButton = findViewById(R.id.listTarefa_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, TarefaForm.class);
            startActivity(intent);

        });
        
        loadTarefas();
    }

    private void loadTarefas() {
        RetrofitService retrofitService = new RetrofitService();
        TarefaApi tarefaApi = retrofitService.getRetrofit().create(TarefaApi.class);
        tarefaApi.getAllTarefa()
                .enqueue(new Callback<List<Tarefa>>() {
                    @Override
                    public void onResponse(Call<List<Tarefa>> call, Response<List<Tarefa>> response) {
                        populatedListView(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<Tarefa>> call, Throwable t) {
                        Toast.makeText(TarefaListActivity.this, "Falha ao Carregar Dados", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void populatedListView(List<Tarefa> TarefaAdapter) {
        TarefaAdapter tarefaAdapter = new TarefaAdapter(TarefaAdapter);
        recyclerView.setAdapter(tarefaAdapter);

    }
}