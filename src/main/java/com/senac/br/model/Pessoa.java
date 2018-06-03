package com.senac.br.model;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class Pessoa {

    private String nome;
    private String endereco;
    private String descricao;

    //mmétodos get/set
    
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
