/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.br.DAO;

import com.senac.br.Exceptions.pessoaException;
import com.senac.br.model.Pessoa;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import com.senac.br.connection.ConnectionFactory;
import java.sql.ResultSet;

/**
 *
 * @author alexandre.vfsilva
 */
public class pessoaDao {

    private static Connection cn = null;

    public static void inserir(Pessoa Pessoa)
            throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Pessoa (nome, endereco, descricao)"
                + "VALUES (?, ?, ?)";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, Pessoa.getNome());
            stmt.setString(2, Pessoa.getEndereco());
            stmt.setString(3, Pessoa.getDescricao());

            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void atualizar(Pessoa pessoa)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "UPDATE Pessoa SET nome=?, endereco=?, descricao=? Where (nome=?)";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEndereco());
            stmt.setString(3, pessoa.getDescricao());

            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void excluir(String nome)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "UPDATE pessoa SET disable=? WHERE (nome=?)";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setString(2, nome);

            stmt.execute();
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static List<Pessoa> listar() throws SQLException, Exception {
        List<Pessoa> listaPesssoa = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM pessoa where disable = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, false);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setDescricao(rs.getString("descricao"));

                listaPesssoa.add(pessoa);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaPesssoa;

    }

    public static Pessoa obter(String nome)
            throws SQLException, Exception {

        String sql = "SELECT * FROM cliente WHERE nome = ? AND disable = ?";

        cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setBoolean(2, false);

            rs = stmt.executeQuery();
        
        if (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setDescricao(rs.getString("descricao"));

                return pessoa;
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        
        return null;
    
}
    
}

