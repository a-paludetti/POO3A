package com.senac.br.controler;

import com.senac.br.DAO.ContaRcbDAO;
import com.senac.br.model.ContaReceber;
import com.senac.br.Exceptions.DataSourceException;
import com.senac.br.Exceptions.contaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class ServicoContaRcb {

    public static void cadastroContaPg(ContaReceber c) throws contaException, DataSourceException {
        ContaRcbDAO.validarConta(c);

        try {
            ContaRcbDAO.inserir(c);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro: ", e);
        }

    }

    public static void atualizarDataVencimento(ContaReceber conta) throws contaException, DataSourceException {
        ContaRcbDAO.validarConta(conta);

        try {
            ContaRcbDAO.atualizarDataVencimento(conta);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro: ", e);
        }
    }

    public static void excluirConta(ContaReceber conta) throws contaException, DataSourceException {
        ContaRcbDAO.validarConta(conta);

        try {
            ContaRcbDAO.excluir(conta);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro: ", e);
        }
    }

    public static ArrayList<ContaReceber> ListarConta(ContaReceber conta) {
        ArrayList<ContaReceber> listaContasAPagar = new ArrayList<>();

        for (int i = 0; i < listaContasAPagar.size(); i++) {
            if (listaContasAPagar.get(i) == null) {
                listaContasAPagar.add(conta);
            }
        }

        return listaContasAPagar;
    }

    public static List<ContaReceber> consultaContaPagars(String nome) throws Exception {
        List<ContaReceber> conta = (List<ContaReceber>) ContaRcbDAO.procurarConta(nome);

        for (int i = 0; i < conta.size(); i++) {
            if (!conta.isEmpty()) {
                return conta;
            }
        }
        return null;
    }
}
