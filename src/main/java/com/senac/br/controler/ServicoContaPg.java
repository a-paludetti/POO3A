package com.senac.br.controler;

import com.senac.br.DAO.ContaPgDAO;
import com.senac.br.model.ContaPagar;
import com.senac.br.Exceptions.DataSourceException;
import com.senac.br.Exceptions.contaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class ServicoContaPg {

public static void cadastroContaPg(ContaPagar c) throws contaException, DataSourceException {
        ContaPgDAO.validarConta(c);

        try {
            ContaPgDAO.inserir(c);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro: ", e);
        }

    }
    
    public static void atualizarDataVencimento(ContaPagar conta) throws contaException, DataSourceException {
         ContaPgDAO.validarConta(conta);
         
         try {
            ContaPgDAO.atualizarDataVencimento(conta);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro: ", e);
        }
    }
    
    public static void excluirConta(ContaPagar conta) throws contaException, DataSourceException {
         ContaPgDAO.validarConta(conta);
         
         try {
            ContaPgDAO.excluir(conta);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro: ", e);
        }
    }

    public static ArrayList<ContaPagar> ListarConta(ContaPagar conta) {
        ArrayList<ContaPagar> listaContasAPagar = new ArrayList<>();

        for (int i = 0; i < listaContasAPagar.size(); i++) {
            if (listaContasAPagar.get(i) == null) {
                listaContasAPagar.add(conta);
            }
        }

        return listaContasAPagar;
    }

    public static List<ContaPagar> consultaContaPagars(String nome) throws Exception {
        List<ContaPagar> conta = (List<ContaPagar>) ContaPgDAO.procurarConta(nome);
        
        for (int i = 0; i < conta.size(); i++) {
            if (!conta.isEmpty()) {
                return conta;
            }
        }
        return null;
    }
}
