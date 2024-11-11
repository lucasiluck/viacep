package br.com.iluck.modelos;

public class endereco {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public endereco(enderecoApi enderecoApi){
        this.cep = enderecoApi.cep();
        this.rua = enderecoApi.logradouro();
        this.cidade = enderecoApi.localidade();
        this.bairro = enderecoApi.bairro();
        this.estado = enderecoApi.uf();
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "Cep: " + cep + " ,Rua: " + rua + " ,Cidade: " + cidade + " ,Bairro: " + bairro + " ,Estado: " + estado;
    }
}
