package br.com.cotiinformatica.apifinancas.controllers;

import br.com.cotiinformatica.apifinancas.dtos.CategoriaRequestDTO;
import br.com.cotiinformatica.apifinancas.dtos.CategoriaResponseDTO;
import br.com.cotiinformatica.apifinancas.exceptions.CriarException;
import br.com.cotiinformatica.apifinancas.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> atualizar(@RequestBody CategoriaRequestDTO request) {
        try {
            var response = categoriaService.criar(request);
            return ResponseEntity.status(201).body(response);
        } catch (Exception e) {
            throw new CriarException("Erro ao criar o categoria! \nError description: " + e.getMessage());
        }

    }
}
