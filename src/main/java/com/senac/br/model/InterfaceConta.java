package com.senac.br.model;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public interface InterfaceConta {

    public abstract Conta criarConta();

    public abstract Conta editarConta();

    public abstract Conta excluirConta();
    
    public abstract Conta pagarConta();
    
    public abstract Conta contaAtrasada();
    
}
