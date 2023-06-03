package com.wb.wbbackend.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Consumo extends RepresentationModel<Consumo> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String dataCriacao;

	@Column
	private BigDecimal total;
	
	@ManyToOne
    private Cliente cliente = new Cliente();
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList<>();
}
