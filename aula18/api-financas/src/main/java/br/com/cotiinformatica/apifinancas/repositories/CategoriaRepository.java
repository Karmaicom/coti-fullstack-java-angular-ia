package br.com.cotiinformatica.apifinancas.repositories;

import br.com.cotiinformatica.apifinancas.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

}
