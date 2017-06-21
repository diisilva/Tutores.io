package aplicativovalendo.studio.com.aplicativovalendo.model;

import android.widget.CheckBox;

/**
 * Created by daniel on 12/06/17.
 */

public class ProfessoresModel {

    private Integer codigo;
    private String  nome;
    private String  email;
    private String  disciplina;
    private String bairro;
    private String  dias;
    private String  horario;
    private byte    registroAtivo;


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getdisciplina() {
        return disciplina;
    }

    public void setdisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getbairro() {
        return bairro;
    }

    public void setbairro(String bairro) {
        this.bairro = bairro;
    }

    public String getdias() {
        return dias;
    }

    public void setdias(String dias) {
        this.dias = dias;
    }

    public String gethorario() {
        return horario;
    }

    public void sethorario(String horario) {
        this.horario = horario;
    }

   /* public byte getRegistroAtivo() {
        return registroAtivo;
    }

    public void setRegistroAtivo(byte registroAtivo) {
        this.registroAtivo = registroAtivo;
    }*/

}

