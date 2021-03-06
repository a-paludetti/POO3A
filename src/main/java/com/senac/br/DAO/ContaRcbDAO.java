/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.br.DAO;

import com.senac.br.Exceptions.contaException;
import com.senac.br.connection.ConnectionFactory;
import com.senac.br.model.ContaReceber;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Red
 */
public class ContaRcbDAO {
     private static Connection cn = null;
    
    private static List<ContaReceber> listaContasRcb = new ArrayList<ContaReceber>();
    
    public static void inserir(ContaReceber conta) throws SQLException, Exception {
        cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO ContaPG(Nome, Valor, NotaFiscal, Descricao, DataCadastro, DataPagamento, Responsavel) "
                + " VALUES(?,?,?,?,?,?,?)";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, conta.getNome());
            stmt.setFloat(2, conta.getValor());
            stmt.setString(3, conta.getNotaFiscal());
            stmt.setString(4, conta.getDescricao());
            stmt.setDate(5, new Date(conta.getDataCadastro().getTime()));
            stmt.setDate(6, new Date(conta.getDataVencimento().getTime()));
            stmt.setString(7, conta.getResponsavel());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
        
    }
    
    public static void atualizar(ContaReceber conta) throws SQLException, Exception {
        cn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        String sql = "UPDATE ContaPg SET  Nome=?, Valor=?, NotaFiscal=?, Descricao=?, DataPagamento=?, Responsavel=?, Disabled=? WHERE id=?";
        
        try {
            stmt = cn.prepareStatement(sql);
            
            stmt.setString(1, conta.getNome());
            stmt.setFloat(2, conta.getValor());
            stmt.setString(3, conta.getNotaFiscal());
            stmt.setString(4, conta.getDescricao());
            stmt.setDate(5, new Date(conta.getDataVencimento().getTime()));
            stmt.setString(6, conta.getResponsavel());
            stmt.setBoolean(7, false);
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void validarConta(ContaReceber conta) throws contaException {
        if (conta == null) {
            throw new contaException("Dados não informados.");
        }
        
        if (conta.getPreco() <= 0) {
            throw new contaException("Preço inválido.");
        }
        
        if (conta.getNome() == null || conta.getNome() == "") {
            throw new contaException("Nome inválido, digite ou escolha um nome válido.");
        }
        
        if (conta.getResponsavel() == null || conta.getResponsavel() == "") {
            throw new contaException("Responsável inválido.");
        }
        
        if (conta.getDataVencimento() == null) {
            throw new contaException("Data de vencimento inválido");
        }
        
    }
    
    public static ContaReceber selecionaConta(String nome) {
        nome = nome.toLowerCase();
        for (ContaReceber c : listaContasRcb) {
            if (c.getNome().contains(nome)) {
                return c;
            }
        }
        return null;
    }
    
    public static ContaReceber procurarConta(String nome) throws SQLException, contaException {
        cn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        ContaReceber c = new ContaReceber(nome, dataVencimento, dataCadastro, nome, 0, nome);
        
        String sql = " SELECT  * FROM contaPg WHERE Nome = ? AND Disable= ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(2, false);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                c.setNome(rs.getString("Nome"));
                c.setPreco(rs.getFloat("Valor"));
                c.setDataCadastro(rs.getDate("DataPagamento"));
                c.setResponsavel(rs.getString("Responsavel"));
                c.setNotaFiscal(rs.getString("NotaFiscal"));
                c.setDescricao(rs.getString("Descricao"));
                c.setDataCadastro(rs.getDate("DataCadastro"));
            }
            
            return c;
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        
    }
    
    public static void atualizarDataVencimento(ContaReceber conta) throws SQLException, Exception {
        
        cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "UPDATE contaPg SET DataPagamento = ? WHERE nome = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setDate(1, new Date(conta.getDataVencimento().getTime()));
            stmt.setString(2, conta.getNome());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
        
    }
    
    public static void excluir(ContaReceber conta) throws SQLException, Exception {
        PreparedStatement stmt = null;
        
        String sql = "UPDATE contaPg SET disable=? WHERE nome=? ";
        
        cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setString(2, conta.getNome());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
        
    }
}
