package br.com.cotiinformatica.apifinancas.dtos;

import java.util.UUID;

public record CategoriaResponseDTO(
    UUID id,
    String descricao
) {
}
