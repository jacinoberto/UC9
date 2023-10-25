package com.exemple.springBoot.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.springBoot.dto.ProdutoRecordDTO;
import com.exemple.springBoot.model.ProdutoModel;
import com.exemple.springBoot.repositories.IProdutoRepository;

import jakarta.validation.Valid;

@RestController
public class ProdutoController {
	
	//@Autowired
	//private ProdutoService produtoService;
	@Autowired
	private IProdutoRepository repository;

	//findById
	@GetMapping("/produto/{id}")
	public ResponseEntity<Optional<ProdutoModel>> produto(@PathVariable UUID id){
		Optional<ProdutoModel> produto = repository.findById(id);
		return ResponseEntity.ok().body(produto);
	}
	
	//findAll
	@CrossOrigin(origins = "*")
	@GetMapping("/produtos")
	public ResponseEntity<List<ProdutoModel>> todosProdutos(){
		List<ProdutoModel> produtos = repository.findAll();
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping("/produto")
	public Page<ProdutoModel> todosProdutos(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	//insert
	@PostMapping("/produto")
	public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody @Valid ProdutoRecordDTO produtoDTO){
		ProdutoModel produto = new ProdutoModel();
		BeanUtils.copyProperties(produtoDTO, produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping("/produto/alter/{id}")
	public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable UUID id ,@RequestBody ProdutoRecordDTO produtoDTO){
		ProdutoModel produto = repository.getReferenceById(id);
		BeanUtils.copyProperties(produtoDTO, produto);
		
		return ResponseEntity.ok().body(repository.save(produto));
	}
	
	
	@DeleteMapping("/produto/delete/{id}")
	public ResponseEntity<ProdutoModel> deletarProduto(@PathVariable UUID id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
