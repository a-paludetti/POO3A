package com.senac.br.model;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class ContaUsuario {

    private int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaUsuario() {
        this.status = false;
        this.saldo = 0f;
    }

    public void abrirConta(String tipo) {
        setTipo(tipo);
        setStatus(true);
        if (tipo.equalsIgnoreCase("CC")) {
            setSaldo(50);
        }
        if (tipo.equalsIgnoreCase("CP")) {
            setSaldo(150);
        }
    }

    public void fecharConta() {
        if (getSaldo() != 0) {
            if (getSaldo() > 0) {
                //msg erro saldo positivo
            } else {
                //msg erro saldo negativo
            }
        }
    }

    public void depositar(float $$) {
        if (isStatus() == true) {
            setSaldo(getSaldo() + $$);
        }
    }

    public void sacar(float $$) {
        if (isStatus() == true) {
            setSaldo(getSaldo() - $$);
        }
    }

    public void pagarMensal(String tipo) {
        if (tipo.equalsIgnoreCase("CC")) {
            setSaldo(getSaldo() - 12);
        }
        if (tipo.equalsIgnoreCase("CP")) {
            setSaldo(getSaldo() - 20);
        }
    }

    // métodos de Get/Set
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
