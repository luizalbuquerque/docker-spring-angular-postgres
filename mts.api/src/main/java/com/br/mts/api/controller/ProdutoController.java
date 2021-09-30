package com.br.mts.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.mts.api.model.entity.Produto;
import com.br.mts.api.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("http://localhost:4200")
public class ProdutoController {

	@Autowired
	private final ProdutoRepository repository;

	@Autowired
	public ProdutoController(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Produto> obterTodos(){
		return repository.findAll();
	}

	// Método SALVAR
	// Notação @RequestBody, informa que é um json vindo da requisição e faz
	// conversão para tipo produto.
	@PostMapping // Mapeia método para requisição verbo post.
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Produto salvar(@RequestBody @Valid Produto produto) {
		return repository.save(produto);
	}

	// Método BUSCAR
	@GetMapping("{id}")
	public Produto buscarPorId(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}

	// Método DELETAR
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		repository.findById(id).map(produto -> {
			repository.delete(produto);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}

	// Método ATUALIZAR
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
		repository.findById(id).map(produto -> {
			produto.setNome(produtoAtualizado.getNome());
			produto.setDescricao(produtoAtualizado.getDescricao());
			produto.setValor(produtoAtualizado.getValor());
			return repository.save(produto);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
