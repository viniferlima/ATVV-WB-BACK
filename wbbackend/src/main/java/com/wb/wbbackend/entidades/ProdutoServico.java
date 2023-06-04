package com.wb.wbbackend.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProdutoServico extends RepresentationModel<ProdutoServico> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column 
	private BigDecimal preco;
	
	@Column
	private String tipo;
	
	@Column
	private Integer qtdConsumida;
	
	@Column
	private Integer qtdConsumidaGeneroMasculino;
	
	@Column
	private Integer qtdConsumidaGeneroFeminino;
	
	@Column
	private Integer qtdConsumidaGeneroOutro;
}