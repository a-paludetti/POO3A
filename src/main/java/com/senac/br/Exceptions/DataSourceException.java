package com.senac.br.Exceptions;

/**
 *
 * @author Aline Paludetti de Oliveira
 */
public class DataSourceException extends Exception {

    //mensagem de erro
    public DataSourceException(String message) {
        super(message);
    }

    //mensagem de erro e uma exception base
    public DataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    //exception base
    public DataSourceException(Throwable cause) {
        super(cause);
    }
}
