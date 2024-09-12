package br.edu.fatec.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Fipe(@JsonAlias("Marca") String marca,
                   @JsonAlias("Modelo") String modelo,
                   @JsonAlias("AnoModelo") String ano,
                   @JsonAlias("Valor") String preco,
                   @JsonAlias("MesReferencia") String referencia) {
}
