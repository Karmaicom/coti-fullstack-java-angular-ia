package br.com.cotiinformatica.apifinancas.repositories;

import br.com.cotiinformatica.apifinancas.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, UUID> {

}
