package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cadastroalunos.adapter.AlunoAdapter;
import com.example.cadastroalunos.dao.AlunoDAO;
import com.example.cadastroalunos.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunoActivity extends AppCompatActivity {

    public RecyclerView rvListaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        atualizaListaAluno();
    }

    public void atualizaListaAluno() {
        List<Aluno> listaAluno = new ArrayList<>();

        //listaAluno = AlunoDAO.retornaAlunos("nome = ?", new String[]{"Lucas"}, "nome asc");
        listaAluno = AlunoDAO.retornaAlunos("", new String[]{}, "nome asc");

        rvListaAlunos = findViewById(R.id.rvListaAlunos);
        AlunoAdapter adapter = new AlunoAdapter(listaAluno, this);
        rvListaAlunos.setAdapter(adapter);
    }
}