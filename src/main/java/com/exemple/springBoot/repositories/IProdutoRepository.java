package com.exemple.springBoot.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.springBoot.model.ProdutoModel;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoModel, UUID>{

}
