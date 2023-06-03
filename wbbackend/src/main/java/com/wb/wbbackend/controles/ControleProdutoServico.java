package com.wb.wbbackend.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.wb.wbbackend.atualizadores.AtualizadorProdutoServico;
import com.wb.wbbackend.entidades.Consumo;
import com.wb.wbbackend.entidades.Item;
import com.wb.wbbackend.entidades.ProdutoServico;
import com.wb.wbbackend.hateoas.HateoasProdutoServico;
import com.wb.wbbackend.repositorios.RepositorioProdutoServico;

@CrossOrigin
@RestController
public class ControleProdutoServico {
	@Autowired
	private RepositorioProdutoServico repositorio;
	@Autowired
	private HateoasProdutoServico hateoas;
	@Autowired
	private AtualizadorProdutoServico atualizador;

	@GetMapping("/item/{id}")
	public ResponseEntity<ProdutoServico> obterItem(@PathVariable Long id) {
		ProdutoServico produtoServico = repositorio.findById(id).get();
		if (produtoServico != null) {
			hateoas.adicionarLink(produtoServico);
			return new ResponseEntity<ProdutoServico>(produtoServico, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<ProdutoServico>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/item/adicionar-qtd-consumida")
	public ResponseEntity<?> adicionarQuantidadeConsumida(@RequestBody Consumo consumo) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		List<Item> itens = consumo.getItens();
		String generoCliente = consumo.getCliente().getGenero();
		
		for(Item item: itens) {
			ProdutoServico produtoServico = repositorio.getById(item.getProdutoServico().getId());
			
			if (produtoServico != null) {
				if (generoCliente.equals("Masculino")) {
					
					Integer qtdConsumidaAtual = produtoServico.getQtdConsumida();
					Integer novaQtdConsumida = qtdConsumidaAtual + item.getQuantidade();
					produtoServico.setQtdConsumida(novaQtdConsumida);
					
					
					Integer qtdConsumidaAtualMasc = produtoServico.getQtdConsumidaGeneroMasculino();
					Integer novaQtdConsumidaMasc = qtdConsumidaAtualMasc + item.getQuantidade();
					produtoServico.setQtdConsumidaGeneroMasculino(novaQtdConsumidaMasc);
					
					repositorio.save(produtoServico);
					status = HttpStatus.OK;
					
					
				} else if(generoCliente.equals("Feminino")) {
					
					Integer qtdConsumidaAtual = produtoServico.getQtdConsumida();
					Integer novaQtdConsumida = qtdConsumidaAtual + item.getQuantidade();
					produtoServico.setQtdConsumida(novaQtdConsumida);
					
					
					Integer qtdConsumidaAtualFem = produtoServico.getQtdConsumidaGeneroFeminino();
					Integer novaQtdConsumidaFem = qtdConsumidaAtualFem + item.getQuantidade();
					produtoServico.setQtdConsumidaGeneroFeminino(novaQtdConsumidaFem);
					
					repositorio.save(produtoServico);
					status = HttpStatus.OK;
					
				} else {
					
					Integer qtdConsumidaAtual = produtoServico.getQtdConsumida();
					Integer novaQtdConsumida = qtdConsumidaAtual + item.getQuantidade();
					produtoServico.setQtdConsumida(novaQtdConsumida);
					
					
					Integer qtdConsumidaAtualOutro = produtoServico.getQtdConsumidaGeneroOutro();
					Integer novaQtdConsumidaOutro = qtdConsumidaAtualOutro + item.getQuantidade();
					produtoServico.setQtdConsumidaGeneroOutro(novaQtdConsumidaOutro);
					
					repositorio.save(produtoServico);
					status = HttpStatus.OK;
					
				}
			}
		}
		
		return new ResponseEntity<>(status);
	}
	
	@PutMapping("/item/subtrair-qtd-consumida")
	public ResponseEntity<?> subtrairQuantidadeConsumida(@RequestBody Consumo consumo) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		List<Item> itens = consumo.getItens();
		String generoCliente = consumo.getCliente().getGenero();
		
		System.out.println(generoCliente);
		
		for(Item item: itens) {
			ProdutoServico produtoServico = repositorio.getById(item.getProdutoServico().getId());
			
			if (produtoServico != null) {
				if (generoCliente.equals("Masculino")) {
					
					Integer qtdConsumidaAtual = produtoServico.getQtdConsumida();
					Integer novaQtdConsumida = qtdConsumidaAtual - item.getQuantidade();
					produtoServico.setQtdConsumida(novaQtdConsumida);
					
					
					Integer qtdConsumidaAtualMasc = produtoServico.getQtdConsumidaGeneroMasculino();
					Integer novaQtdConsumidaMasc = qtdConsumidaAtualMasc - item.getQuantidade();
					produtoServico.setQtdConsumidaGeneroMasculino(novaQtdConsumidaMasc);
					
					repositorio.save(produtoServico);
					status = HttpStatus.OK;
					
					
				} else if(generoCliente.equals("Feminino")) {
					
					Integer qtdConsumidaAtual = produtoServico.getQtdConsumida();
					Integer novaQtdConsumida = qtdConsumidaAtual - item.getQuantidade();
					produtoServico.setQtdConsumida(novaQtdConsumida);
					
					
					Integer qtdConsumidaAtualFem = produtoServico.getQtdConsumidaGeneroFeminino();
					Integer novaQtdConsumidaFem = qtdConsumidaAtualFem - item.getQuantidade();
					produtoServico.setQtdConsumidaGeneroFeminino(novaQtdConsumidaFem);
					
					repositorio.save(produtoServico);
					status = HttpStatus.OK;
					
				} else {
					
					Integer qtdConsumidaAtual = produtoServico.getQtdConsumida();
					Integer novaQtdConsumida = qtdConsumidaAtual - item.getQuantidade();
					produtoServico.setQtdConsumida(novaQtdConsumida);
					
					
					Integer qtdConsumidaAtualOutro = produtoServico.getQtdConsumidaGeneroOutro();
					Integer novaQtdConsumidaOutro = qtdConsumidaAtualOutro - item.getQuantidade();
					produtoServico.setQtdConsumidaGeneroOutro(novaQtdConsumidaOutro);
					
					repositorio.save(produtoServico);
					status = HttpStatus.OK;
					
				}
			}
		}
		
		return new ResponseEntity<>(status);
	}

	@GetMapping("/itens")
	public ResponseEntity<List<ProdutoServico>> obterItens() {
		List<ProdutoServico> produtosServicos = repositorio.findAll();
		hateoas.adicionarLink(produtosServicos);
		return new ResponseEntity<List<ProdutoServico>>(produtosServicos, HttpStatus.FOUND);
	}

	@PutMapping("/item/atualizar")
	public ResponseEntity<?> atualizarItem(@RequestBody ProdutoServico atualizacao) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProdutoServico produtoServico = repositorio.getById(atualizacao.getId());
		if (produtoServico != null) {
			atualizador.atualizar(produtoServico, atualizacao);
			repositorio.save(produtoServico);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(status);
	}

	@PostMapping("/item/cadastrar")
	public ResponseEntity<?> cadastrarItem(@RequestBody ProdutoServico novo) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		if (novo != null) {
			repositorio.save(novo);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/item/excluir")
	public ResponseEntity<?> excluirItem(@RequestBody ProdutoServico exclusao) {
		ProdutoServico produtoServico = repositorio.getById(exclusao.getId());
		if (produtoServico == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			repositorio.delete(produtoServico);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}