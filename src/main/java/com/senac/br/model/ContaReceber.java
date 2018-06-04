package com.senac.br.model;

import java.util.Date;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class ContaReceber extends Conta implements InterfaceConta {

    String notaFiscal;
    float preco;

    public ContaReceber(String descricao, Date dataVencimento, Date dataCadastro, String nome, float valor, String tipo) {
        super(descricao, dataVencimento, dataCadastro, nome, valor, tipo);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    @Override
    public Conta criarConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta editarConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta excluirConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta pagarConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta contaAtrasada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
