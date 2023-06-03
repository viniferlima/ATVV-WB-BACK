package com.wb.wbbackend.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item extends RepresentationModel<Item> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    private ProdutoServico produtoServico = new ProdutoServico();
	
	@Column 
	private Integer quantidade;
	
	@Column 
	private BigDecimal subtotal;
}