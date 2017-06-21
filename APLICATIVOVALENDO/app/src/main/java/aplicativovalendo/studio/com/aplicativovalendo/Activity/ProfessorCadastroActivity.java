package aplicativovalendo.studio.com.aplicativovalendo.Activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import aplicativovalendo.studio.com.aplicativovalendo.R;
import aplicativovalendo.studio.com.aplicativovalendo.Repository.ProfessoresRepository;
import aplicativovalendo.studio.com.aplicativovalendo.model.ProfessoresModel;
import aplicativovalendo.studio.com.aplicativovalendo.util.Uteis;


public class ProfessorCadastroActivity extends AppCompatActivity {

    private EditText textoEmail;
    private EditText textoNome;
    private EditText textoDisciplina;
    private EditText textoBairro;
    private EditText textoDias; // segunda, terca, ..., domingo
    private EditText textoTelefone;
    private EditText textoHorario; //manha,tarde,noite
    private Button botaoCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_cadastro);
        this.CriarComponentes();





    }

    protected void CriarComponentes(){

        textoEmail = (EditText) findViewById(R.id.text_emailprofessorID);
        textoNome = (EditText) findViewById(R.id.text_nomeprofessorID);
        textoDisciplina = (EditText) findViewById(R.id.text_disciplinaprofessorID);
        textoBairro = (EditText) findViewById(R.id.text_bairroprofessorID);
        textoDias = (EditText) findViewById(R.id.text_diasprofessorID);
        textoHorario = (EditText) findViewById(R.id.text_horarioprofessorID);
       textoTelefone = (EditText) findViewById(R.id.text_telefoneprofessorID);
        botaoCadastrar = (Button) findViewById(R.id.botao_CadastroPROFID);

        //CRIANDO EVENTO NO BOTAO SALVAR

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar_onClick();
            }
        });

    }



    protected void Salvar_onClick(){
        if(textoEmail.getText().toString().trim().equals("")){

            Uteis.Alert(this, this.getString(R.string.email_obrigatorio));

            textoEmail.requestFocus();}

        else if(textoNome.getText().toString().trim().equals("")){

            Uteis.Alert(this, this.getString(R.string.nome_obrigatorio));

            textoNome.requestFocus();}

        /* else if (textoDisciplina.getText().toString().trim().equals("")){

            Uteis.Alert(this, this.getString(R.string.disciplina_obrigatorio));

            textoDisciplina.requestFocus();}

        else if (textoBairro.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.bairro_obrigatorio));

            textoBairro.requestFocus();}

        else if (textoDias.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.dias_obrigatorio));

            textoDias.requestFocus();}

        else if (textoHorario.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.horario_obrigatorio));

            textoHorario.requestFocus();} */

        else
        if (textoTelefone.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.telefone_obrigatorio));

            textoTelefone.requestFocus();}
        else{
                                                         /*CRIANDO UM OBJETO PESSOA*/
         //   ProfessoresModel professoresModel = new ProfessoresModel();

                                                    /*SETANDO O VALOR DO CAMPO EMAIL*/
          //  professoresModel.setEmail(textoEmail.getText().toString().trim());

                                                        /*SETANDO O NOME*/
           // professoresModel.setNome(textoNome.getText().toString().trim());

                                                                /*SETANDO O DISCIPLINA*/
           // professoresModel.setdisciplina(textoDisciplina.getText().toString().trim());

                                                                /*SETANDO O BAIRRO*/
           // professoresModel.setbairro(textoBairro.getText().toString().trim());

                                                                /*SETANDO OS DIAS*/
           // professoresModel.setdias(textoDias.getText().toString().trim());

                                                                /*SETANDO OS DIAS*/
           // professoresModel.sethorario(textoHorario.getText().toString().trim());





                                                /*SETA O REGISTRO COMO INATIVO
                                             professoresModel.setRegistroAtivo((byte)0);

                                            /*SE TIVER SELECIONADO SETA COMO ATIVO
                                             if(checkBoxRegistroAtivo.isChecked())
                                                 professoresModel.setRegistroAtivo((byte)1);*/

                                                        /*SALVANDO UM NOVO REGISTRO*/
           // new ProfessoresRepository(this).Salvar(professoresModel);

                                                                 /*MENSAGEM DE SUCESSO!*/


            Uteis.Alert(this,this.getString(R.string.registro_salvo_sucesso));

           LimparCampos();




        }
    }
    //LIMPA OS CAMPOS APÓS SALVAR AS INFORMAÇÕES
    protected void LimparCampos(){

        textoEmail.setText(null);
        textoNome.setText(null);
        textoDisciplina.setText(null);
        textoBairro.setText(null);
        textoDias.setText(null);
        textoHorario.setText(null);
        textoTelefone.setText(null);

    }
    //EVENTOS onClick dos textos
    public void onClickBAIRROS (View view){
        final CharSequence[] items = {" MARCO "," CANUDOS "," UMARIZAL "," GUAMÁ "};
        // arraylist to keep the selected items
        final ArrayList seletedItems=new ArrayList();

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Selecione os bairros")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            seletedItems.add(indexSelected);
                        } else if (seletedItems.contains(indexSelected)) {
                            // Else, if the item is already in the array, remove it
                            seletedItems.remove(Integer.valueOf(indexSelected));
                        }
                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    textoBairro.setText("MARCO, CANUDOS");
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on Cancel
                    }
                }).create();
        dialog.show();
    }
    public void onClickDIAS (View view){
        final CharSequence[] items = {" SEGUNDA-FEIRA "," TERÇA-FEIRA "," QUARTA-FEIRA "," QUINTA-FEIRA ",
                "SEXTA-FEIRA", "SÁBADO", "DOMINGO"};
        // arraylist to keep the selected items
        final ArrayList seletedItems=new ArrayList();

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Selecione os dias da semana")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            seletedItems.add(indexSelected);
                        } else if (seletedItems.contains(indexSelected)) {
                            // Else, if the item is already in the array, remove it
                            seletedItems.remove(Integer.valueOf(indexSelected));
                        }
                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on OK
                        textoDias.setText("SÁBADO, DOMINGO");
                        //  You can write the code  to save the selected item here
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on Cancel
                    }
                }).create();
        dialog.show();
    }
    public void onClickHORARIO (View view){
        final CharSequence[] items = {" MANHÃ[8 às 13] "," TARDE[13 às 18] "," NOITE[18 às 23] "};
        // arraylist to keep the selected items
        final ArrayList seletedItems=new ArrayList();

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Selecione o turno para as aulas")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            seletedItems.add(indexSelected);
                        } else if (seletedItems.contains(indexSelected)) {
                            // Else, if the item is already in the array, remove it
                            seletedItems.remove(Integer.valueOf(indexSelected));
                        }
                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on OK
                        textoHorario.setText("TARDE[13 às 18], NOITE[18 às 23] ");
                        //  You can write the code  to save the selected item here
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on Cancel
                    }
                }).create();
        dialog.show();

    }

    public void onClickDISCIPLINA (View view){
        final CharSequence[] items = {" MATEMÁTICA[E.F] "," MATEMÁTICA[E.M] "," CÁLCULO I ",
        "CÁLCULO II", "CÁLCULO III", "INGLÊS", "QUÍMICA", "FÍSICA I", "FÍSICA II", ""};
        // arraylist to keep the selected items
        final ArrayList seletedItems=new ArrayList();

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Selecione as matérias a lecionar")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            seletedItems.add(indexSelected);
                        } else if (seletedItems.contains(indexSelected)) {
                            // Else, if the item is already in the array, remove it
                            seletedItems.remove(Integer.valueOf(indexSelected));
                        }
                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on OK
                        textoDisciplina.setText("MATEMÁTICA [E.M], INGLÊS");
                        //  You can write the code  to save the selected item here
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on Cancel
                    }
                }).create();
        dialog.show();

    }

};