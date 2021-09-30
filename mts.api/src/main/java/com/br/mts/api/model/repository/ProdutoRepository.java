package com.br.mts.api.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.mts.api.model.entity.Produto;

/**
 * 
 * Interface ClienteRepository
 * 
 * @author Albuquerque
 *
 */

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
}
