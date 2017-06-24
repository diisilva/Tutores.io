package aplicativovalendo.studio.com.aplicativovalendo.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import aplicativovalendo.studio.com.aplicativovalendo.model.ProfessoresModel;
import aplicativovalendo.studio.com.aplicativovalendo.util.DatabaseUtil;

/**
 * Created by daniel on 12/06/17.
 */

public class ProfessoresRepository {
    DatabaseUtil databaseUtil;

    public ProfessoresRepository(Context context) {
        databaseUtil = new DatabaseUtil(context);

    }

    public void Salvar(ProfessoresModel professoresModel) {


        ContentValues contentValues = new ContentValues();
        /*MONTANDO OS PARAMETROS PARA SEREM SALVOS*/
        contentValues.put("ds_nome", professoresModel.getNome());
        contentValues.put("ds_email", professoresModel.getEmail());
        contentValues.put("ds_disciplina", professoresModel.getdisciplina());
        contentValues.put("ds_bairro", professoresModel.getbairro());
        contentValues.put("dt_dias", professoresModel.getdias());
        contentValues.put("fl_horario", professoresModel.gethorario());
        //contentValues.put("fl_ativo", professoresModel.getRegistroAtivo());

        /*EXECUTANDO INSERT DE UM NOVO REGISTRO*/
        databaseUtil.GetConexaoDataBase().insert("Professores", null, contentValues);
    }

    /***
     * ATUALIZA UM REGISTRO JÁ EXISTENTE NA BASE
     * @param professoresModel
     */
    public void Atualizar(ProfessoresModel professoresModel) {

        ContentValues contentValues = new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("ds_nome", professoresModel.getNome());
        contentValues.put("ds_email", professoresModel.getEmail());
        contentValues.put("ds_disciplina", professoresModel.getdisciplina());
        contentValues.put("ds_bairro", professoresModel.getbairro());
        contentValues.put("dt_dias", professoresModel.getdias());
        contentValues.put("fl_horario", professoresModel.gethorario());
        //contentValues.put("fl_ativo", professoresModel.getRegistroAtivo());

        /*REALIZANDO UPDATE PELA CHAVE DA TABELA*/
        databaseUtil.GetConexaoDataBase().update("Professores", contentValues, "id_Professores = ?", new String[]{Integer.toString(professoresModel.getCodigo())});
    }

    /***
     * EXCLUI UM REGISTRO PELO CÓDIGO
     * @param codigo
     * @return
     */
    public Integer Excluir(int codigo) {

        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseUtil.GetConexaoDataBase().delete("Professores", "id_professores = ?", new String[]{Integer.toString(codigo)});
    }

    /***
     * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
     * @param codigo
     * @return
     */
    public ProfessoresModel GetProfessores(int codigo){


        Cursor cursor =  databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM Professores WHERE id_professores= "+ codigo,null);

        cursor.moveToFirst();

        ///CRIANDO UMA NOVA PESSOAS
        ProfessoresModel professoresModel =  new ProfessoresModel();

        //ADICIONANDO OS DADOS DA PESSOA
        professoresModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_professores")));
        professoresModel.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
        professoresModel.setEmail(cursor.getString(cursor.getColumnIndex("ds_email")));
        professoresModel.setdisciplina(cursor.getString(cursor.getColumnIndex("ds_disciplina")));
        professoresModel.setbairro(cursor.getString(cursor.getColumnIndex("ds_bairro")));
        professoresModel.setdias(cursor.getString(cursor.getColumnIndex("dt_dias")));
        professoresModel.sethorario(cursor.getString(cursor.getColumnIndex("fl_horario")));
        //professoresModel.setRegistroAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));
        //RETORNANDO A PESSOA
        return professoresModel;

    }

    /***
     * CONSULTA TODAS AS PESSOAS CADASTRADAS NA BASE
     * @return
     */
    public List<ProfessoresModel> SelecionarTodos(){

        List<ProfessoresModel> professores = new ArrayList<ProfessoresModel>();


        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id_Professores,      ");
        stringBuilderQuery.append("        ds_nome,        ");
        stringBuilderQuery.append("        ds_email,    ");
        stringBuilderQuery.append("        ds_disciplina,        ");
        stringBuilderQuery.append("        ds_bairro,  ");
        stringBuilderQuery.append("        dt_dias, ");
        stringBuilderQuery.append("        fl_horario, ");
        //stringBuilderQuery.append("        fl_ativo        ");
        stringBuilderQuery.append("  FROM  Professores       ");
        stringBuilderQuery.append(" ORDER BY ds_nome       ");

        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();

        ProfessoresModel professoresModel;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){

            /* CRIANDO UMA NOVA PESSOAS */
            professoresModel =  new ProfessoresModel();

            //ADICIONANDO OS DADOS DA PESSOA
            professoresModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_pessoa")));
            professoresModel.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
            professoresModel.setEmail(cursor.getString(cursor.getColumnIndex("ds_email")));
            professoresModel.setdisciplina(cursor.getString(cursor.getColumnIndex("ds_disciplina")));
            professoresModel.setbairro(cursor.getString(cursor.getColumnIndex("ds_bairro")));
            professoresModel.setdias(cursor.getString(cursor.getColumnIndex("dt_dias")));
            professoresModel.sethorario(cursor.getString(cursor.getColumnIndex("fl_horario")));
            //professoresModel.setRegistroAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));

            //ADICIONANDO UMA PESSOA NA LISTA
            professores.add(professoresModel);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();

        }

        //RETORNANDO A LISTA DE PESSOAS
        return professores;

    }



}