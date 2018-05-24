/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.br.model;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public abstract class Conta {

    private String descricao;
    private int notafiscal;
    private String nome;
    private String endereco;
    private int tipo;
    private float valor;

    public Conta(String nome, String endereco, String descricao) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.nome = nome;
    }

    //Nota Fiscal é opcional
    public int getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(int notafiscal) {
        this.notafiscal = notafiscal;
    }
    
        public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //tanto tipo como valor são tipos abstratos, tratados em suas respectivas classes.
    public abstract int tipo();

    public abstract float valor();
}
