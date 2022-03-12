package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.model.Aluno;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrarAluno(View view) {
        Aluno aluno = new Aluno(123, "aaaa", "123", "1/1/1", "1/1/1", "curso", "1 periodo");
        AlunoDAO.salvar(aluno);

        Aluno aluno1 = new Aluno(123, "bbbb", "123", "1/1/1", "1/1/1", "curso", "1 periodo");
        AlunoDAO.salvar(aluno1);

        Aluno aluno2 = new Aluno(123, "cccc", "123", "1/1/1", "1/1/1", "curso", "1 periodo");
        AlunoDAO.salvar(aluno2);

        Intent intent = new Intent(this, ListaAlunoActivity.class);
        startActivity(intent);
    }
}