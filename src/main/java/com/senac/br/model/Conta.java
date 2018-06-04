package com.senac.br.model;

import java.util.Date;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class Conta {

    private String descricao;
    private Date dataVencimento;
    private Date dataCadastro;
    private String nome;
    private String tipo;
    private float valor;
    private boolean Disabled;
    private String Responsavel;

    //Contrutor da Conta padrão
    public Conta(String descricao, Date dataVencimento, Date dataCadastro, String nome, float valor, String tipo) {
        this.dataCadastro = dataCadastro;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }

    // métodos Get/Set
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("Pessoa Fisica")) {
            // ContaPessoaFisica.criarConta();
        }
        if (tipo.equalsIgnoreCase("Pessoa Jurídica")) {
            //ContaPessoaJuridica.criarConta();
        }

        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isDisabled() {
        return Disabled;
    }

    public void setDisabled(boolean Disabled) {
        this.Disabled = Disabled;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String Responsavel) {
        this.Responsavel = Responsavel;
    }

}
