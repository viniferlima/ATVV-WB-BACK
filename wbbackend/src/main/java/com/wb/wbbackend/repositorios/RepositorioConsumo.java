package com.wb.wbbackend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wb.wbbackend.entidades.Consumo;

@Repository
public interface RepositorioConsumo extends JpaRepository<Consumo, Long> {
}
