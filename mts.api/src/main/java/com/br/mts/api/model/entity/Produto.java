package com.br.mts.api.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

/**
 * 
 * Classe Produto fornece dados padrão de produto.
 * 
 * @author Albuquerque
 *
 */

@Data
@Generated
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 80)
	@NotEmpty(message = "Campo nome obrigatório")
	private String nome;

	@Column(nullable = false, length = 150)
	@NotNull(message = "Campo descrição obrigatório")
	private String descricao;
	
	@Column(nullable = false)
	@NotNull(message = "Campo valor obrigatório")
	private long valor;
	
	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
		
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
		

}
