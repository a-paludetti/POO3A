package com.senac.br.model;

import com.senac.br.model.Conta;
import java.util.Date;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class ContaPagar extends Conta implements InterfaceConta {

    private String NotaFiscal;
    float Preco;

    public ContaPagar(String descricao, Date dataVencimento, Date dataCadastro, String nome, float valor, String tipo) {
        super(descricao, dataVencimento, dataCadastro, nome, valor, tipo);
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public String getNotaFiscal() {
        return NotaFiscal;
    }

    public void setNotaFiscal(String NotaFiscal) {
        this.NotaFiscal = NotaFiscal;
    }

    @Override
    public Conta criarConta() {
        throw new UnsupportedOperationException("Not supported yet.");
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
