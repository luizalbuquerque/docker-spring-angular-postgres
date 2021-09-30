package com.br.mts.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.mts.api.model.entity.Servico;

/**
 * 
 * Interface ServicoRepository
 * 
 * @author Albuquerque
 *
 */

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
