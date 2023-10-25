package com.exemple.springBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.springBoot.model.ProdutoModel;
import com.exemple.springBoot.repositories.IProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private IProdutoRepository repository;
	
	public ProdutoModel saveProduct(ProdutoModel produto) {
		return repository.save(produto);
	}
}
