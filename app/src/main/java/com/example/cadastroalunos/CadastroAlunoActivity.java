package com.example.cadastroalunos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class CadastroAlunoActivity extends AppCompatActivity {

    private TextInputEditText edRaAluno;
    private TextInputEditText edNomeAluno;
    private TextInputEditText edCpfAluno;
    private TextInputEditText edDtNasc;
    private TextInputEditText edDtmat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        edRaAluno = findViewById(R.id.edRaAluno);
        edNomeAluno = findViewById(R.id.edNomeAluno);
        edCpfAluno = findViewById(R.id.edCPFAluno);
        edDtmat = findViewById(R.id.edDtMatAluno);
        edDtNasc = findViewById(R.id.edDtNascAluno);
    }

    //para chamar o "Menu ToolBar" do menu_cadastro.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //item recebe o que eu acabei de clicar
        switch (item.getItemId()) {
            case R.id.mn_limpar:
                Toast.makeText(this, "clicou menu Limpar", Toast.LENGTH_SHORT).show();
                //TODO: adicionar método de limpar dados
                return true;
            case R.id.mn_salvar:
                Toast.makeText(this, "clicou menu Salvar", Toast.LENGTH_SHORT).show();
                //TODO: adicionar método de salvar dados
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}