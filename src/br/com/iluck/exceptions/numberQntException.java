package br.com.iluck.exceptions;

public class numberQntException extends RuntimeException{
    private String message;

    public numberQntException(String mensagem){
        this.message = mensagem;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
