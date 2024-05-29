package br.com.conversor.modelos;

public record MoedaExchangeRate(String base_code, String target_code, double conversion_rate) {
}
