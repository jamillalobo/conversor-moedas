package br.com.conversor.modelos;

public class Moeda {
    private String codigoInicial;
    private String codigoAlvo;
    private double cotacao;


    public Moeda(MoedaExchangeRate moedaExchangeRate){
        this.codigoInicial = moedaExchangeRate.base_code();
        this.codigoAlvo = moedaExchangeRate.target_code();
        this.cotacao = moedaExchangeRate.conversion_rate();
    }

    public double setValorConversao(double valorConversao) {
        this.valorConversao = valorConversao;
        return valorConversao;
    }

    private double valorConversao;

    public double conversao() {
        return this.valorConversao * this.cotacao;
    }

    @Override
    public String toString() {
        return "Valor de " + valorConversao + " " + codigoInicial + " corresponde a " + conversao() + " " + codigoAlvo;
    }
}
