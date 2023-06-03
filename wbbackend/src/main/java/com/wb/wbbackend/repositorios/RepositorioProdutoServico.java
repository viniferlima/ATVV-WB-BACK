package com.wb.wbbackend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wb.wbbackend.entidades.ProdutoServico;	

@Repository
public interface RepositorioProdutoServico extends JpaRepository<ProdutoServico, Long> {
}
