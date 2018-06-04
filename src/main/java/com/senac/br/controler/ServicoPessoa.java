/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.br.controler;

import com.senac.br.DAO.pessoaDao;
import com.senac.br.Exceptions.pessoaException;
import com.senac.br.Exceptions.DataSourceException;
import com.senac.br.model.Pessoa;

/**
 *
 * @author alexandre.vfsilva
 */
public class ServicoPessoa {
    
    public static void cadastrarPessoa (Pessoa pessoa)
            throws pessoaException, DataSourceException {
        
        try {
            
            pessoaDao.inserir(pessoa);
        }
        
        
    }
    
}
