package aplicativovalendo.studio.com.aplicativovalendo.util;

/**
 * Created by daniel on 12/06/17.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by daniel on 10/06/17.
 */

public class DatabaseUtil extends SQLiteOpenHelper{

    //NOME DO BANCO DE DADOS
    private static final String NOME_DO_BANCO_DE_DADOS =  "Professores.db";

    //VERSAO DO BANCO DE DADOS
    private static final int VERSAO_BANCO_DE_DADOS = Integer.parseInt("6");

    //Construtor
    public DatabaseUtil(Context context){

        super(context, NOME_DO_BANCO_DE_DADOS,null, VERSAO_BANCO_DE_DADOS);
    }

    /*CRIAMOS NA INICIALIZACAO DA CLASSE NOSSA TABELA*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE Professores (");
        stringBuilderCreateTable.append("        id_Professores      INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append("        ds_nome        TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_email    TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_disciplina    TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_bairro    TEXT    NOT NULL,            ");
        //stringBuilderCreateTable.append("        fl_telefone        TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        dt_dias  TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        fl_horario       TEXT     NOT NULL )    ");



        db.execSQL(stringBuilderCreateTable.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Professores");
        onCreate(db);

    }
    public SQLiteDatabase GetConexaoDataBase(){

        return this.getWritableDatabase();
    }

}
