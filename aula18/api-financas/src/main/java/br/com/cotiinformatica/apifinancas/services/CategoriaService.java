package br.com.cotiinformatica.apifinancas.services;

import br.com.cotiinformatica.apifinancas.dtos.CategoriaRequestDTO;
import br.com.cotiinformatica.apifinancas.dtos.CategoriaResponseDTO;
import br.com.cotiinformatica.apifinancas.entities.Categoria;
import br.com.cotiinformatica.apifinancas.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO criar(CategoriaRequestDTO request) {

        // Criar um objetivo da entidade categoria
        var categoria = new Categoria();
        categoria.setNome(request.nome());

        // Salvando categoria no banco de dados
        var save = categoriaRepository.save(categoria);

        // Criando response para retorno do método
        return new CategoriaResponseDTO(save.getId(), save.getNome());

    }

}
