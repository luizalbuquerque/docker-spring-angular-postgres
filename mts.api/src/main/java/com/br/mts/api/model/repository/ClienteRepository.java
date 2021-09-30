package com.br.mts.api.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.mts.api.model.entity.Cliente;

/**
 * 
 * Interface ClienteRepository
 * 
 * @author Albuquerque
 *
 */

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
