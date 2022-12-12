package com.example.springclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.springclient.model.Tarefa;
import com.example.springclient.retrofit.RetrofitService;
import com.example.springclient.retrofit.TarefaApi;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TarefaForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();




    }

    private void initializeComponents() {
        TextInputEditText textInputEditTitulo = findViewById(R.id.form_textFieldTitulo);
        TextInputEditText textInputEditDescricao = findViewById(R.id.form_textFieldDescricao);
        TextInputEditText textInputEditDataPrevista = findViewById(R.id.form_textFieldDataPrevista);
        TextInputEditText textInputEditDataConclusao = findViewById(R.id.form_textFieldDataConclusao);
        TextInputEditText textInputEditCategoria = findViewById(R.id.form_textFieldCategoria);
        TextInputEditText textInputEditStatus = findViewById(R.id.form_textFieldStatus);

        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);


        RetrofitService retrofitService = new RetrofitService();
        TarefaApi tarefaApi = retrofitService.getRetrofit().create(TarefaApi.class);


        buttonSave.setOnClickListener(view -> {
            String titulo = String.valueOf(textInputEditTitulo.getText());
            String descricao = String.valueOf(textInputEditDescricao.getText());
            String dataPrevista = String.valueOf(textInputEditDataPrevista.getText());
            String dataConclusao = String.valueOf(textInputEditDataConclusao.getText());
            String categoria = String.valueOf(textInputEditCategoria.getText());
            String status = String.valueOf(textInputEditStatus.getText());


            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo(titulo);
            tarefa.setDescricao(descricao);
            tarefa.setDataPrevista(dataPrevista);
            tarefa.setDataConclusao(dataConclusao);
//            tarefa.setCategoria();
//            tarefa.setStatus(status);

            tarefaApi.save(tarefa)
                    .enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            Toast.makeText(TarefaForm.this, "Salvo Com Sucesso!!", Toast.LENGTH_SHORT).show();
                            
                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            Toast.makeText(TarefaForm.this, "Falha ao Salvar!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(TarefaForm.class.getName()).log(Level.SEVERE, "Error Ocurred", t);
                        }
                    });
        });

    }
}