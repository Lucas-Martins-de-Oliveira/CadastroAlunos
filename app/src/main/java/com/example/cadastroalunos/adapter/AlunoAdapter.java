package com.example.cadastroalunos.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.cadastroalunos.R;
import com.example.cadastroalunos.model.Aluno;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder> {

    private List<Aluno> listaAlunos;
    private Context context;

    public AlunoAdapter(List<Aluno> listaAlunos, Context context) {
        this.listaAlunos = listaAlunos;
        this.context = context;
    }

    public class AlunoViewHolder extends RecyclerView.ViewHolder {

        TextInputEditText edRaAluno;
        TextInputEditText edNomeAluno;
        TextInputEditText edCpfAluno;
        TextInputEditText edCurso;
        TextInputEditText edPeriodo;
        TextInputEditText edDtMatricula;
        TextInputEditText edDtNasc;

        public AlunoViewHolder(@NonNull View itemView) {
            super(itemView);

            edRaAluno = (TextInputEditText)itemView.findViewById(R.id.edRaAluno);
            edNomeAluno = (TextInputEditText)itemView.findViewById(R.id.edNomeAluno);
            edCpfAluno = (TextInputEditText)itemView.findViewById(R.id.edCPFAluno);
            edCurso = (TextInputEditText)itemView.findViewById(R.id.edCursoAluno);
            edPeriodo = (TextInputEditText)itemView.findViewById(R.id.edPeriodoAluno);
            edDtMatricula = (TextInputEditText)itemView.findViewById(R.id.edDtMatricula);
            edDtNasc = (TextInputEditText)itemView.findViewById(R.id.edDtNascAluno);
        }
    }

    @NonNull
    @Override
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
