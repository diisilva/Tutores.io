package aplicativovalendo.studio.com.aplicativovalendo.Activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import aplicativovalendo.studio.com.aplicativovalendo.R;


public class CadastroAlunoOuProfessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno_ou_professor);
    }

    public void abrirLoginUsuario (View view){
        Intent intent = new Intent(CadastroAlunoOuProfessorActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void alunoCadastro (View view){
        Intent intent = new Intent(CadastroAlunoOuProfessorActivity.this, AlunoCadastroActivity.class);
        startActivity(intent);
    }
}

