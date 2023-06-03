package com.wb.wbbackend.entidades;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente extends RepresentationModel<Cliente> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	@Column
	private String sobreNome;
	@Column
	private String genero;
	@Column
	private String email;
	@Column
	private String cpf;
	@Column
	private String telefone;
	@Column
	private Integer qtdConsumida;
	@Column
	private BigDecimal valorConsumido;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;
}