package com.example.cadastroalunos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import fr.ganfra.materialspinner.MaterialSpinner;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.cadastroalunos.util.CpfMask;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class CadastroAlunoActivity extends AppCompatActivity {

    private TextInputEditText edRaAluno;
    private TextInputEditText edNomeAluno;
    private TextInputEditText edCpfAluno;
    private TextInputEditText edDtNasc;
    private TextInputEditText edDtmat;
    private MaterialSpinner spCursos;
    private MaterialSpinner spPeriodo;

    private int vAno;
    private int vMes;
    private int vDia;
    private View dataSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        edRaAluno = findViewById(R.id.edRaAluno);
        edNomeAluno = findViewById(R.id.edNomeAluno);
        edCpfAluno = findViewById(R.id.edCPFAluno);
        edDtmat = findViewById(R.id.edDtMatAluno);
        edDtNasc = findViewById(R.id.edDtNascAluno);

        edCpfAluno.addTextChangedListener(CpfMask.insert(edCpfAluno));
        iniciaSpinners();

        setDataAtual();
    }

    private void setDataAtual() {
        final Calendar calendar = Calendar.getInstance();
        vDia = calendar.get(Calendar.DAY_OF_MONTH);
        vMes = calendar.get(Calendar.MONTH);
        vAno = calendar.get(Calendar.YEAR);
    }

    private void iniciaSpinners() {
        spCursos = findViewById(R.id.spCursos);
        spPeriodo = findViewById(R.id.spPeriodo);

        String cursos[] = new String[]{"Análise e Desenv. Sistemas", "Administração",
                                       "Ciências Contábeis", "Farmácia",
                                       "Direito", "Nutrição"};

        String periodo[] = new String[]{"1ª Série", "2ª Série", "3ª Série", "4ª Série"};

        ArrayAdapter adapterCursos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cursos);
        ArrayAdapter adapterPeriodo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, periodo);

        spCursos.setAdapter(adapterCursos);
        spPeriodo.setAdapter(adapterPeriodo);

        //Ação ao selecionar o item da lista
        spCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void validaCampos() {
        if (edRaAluno.getText().toString().equals("")) {
            edRaAluno.setError("Informe o RA do Aluno!");
            edRaAluno.requestFocus();
            return;
        }

        if (edNomeAluno.getText().toString().equals("")) {
            edNomeAluno.setError("Informe o Nome do Aluno!");
            edNomeAluno.requestFocus();
            return;
        }

        if (edCpfAluno.getText().toString().equals("")) {
            edCpfAluno.setError("Informe o CPF do Aluno!");
            edCpfAluno.requestFocus();
            return;
        }
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
                validaCampos();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void selecionarData(View view) {
        dataSelecionada = view;
        showDialog(0);
    }

    private DatePickerDialog.OnDateSetListener setDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            vAno = year;
            vMes = month;
            vDia = day;

            atualizaData();
        }
    };

    private void atualizaData() {
        TextInputEditText edit = (TextInputEditText)dataSelecionada;
        edit.setText(new StringBuilder().append(vDia).append("/").append(vMes + 1).append("/").append(vAno));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, setDatePicker, vAno, vMes, vDia);
    }
}