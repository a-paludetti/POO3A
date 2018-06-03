package com.senac.br.model;

import com.senac.br.model.Conta;
import java.util.Date;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class ContaPessoaFisica extends Conta implements InterfaceConta {

//    String descricao;
//    DataSistema dataVencimento;
//    DataSistema dataCadastro;
//    String nome;
//    float valor;
//
    
    public ContaPessoaFisica(String descricao, Date dataVencimento, Date dataCadastro, String nome, float valor) {
        super(descricao, dataVencimento, dataCadastro, nome, valor);
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
