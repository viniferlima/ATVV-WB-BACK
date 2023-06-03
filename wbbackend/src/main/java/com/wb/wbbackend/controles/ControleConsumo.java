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

import com.wb.wbbackend.atualizadores.AtualizadorConsumo;
import com.wb.wbbackend.entidades.Consumo;
import com.wb.wbbackend.hateoas.HateoasConsumo;
import com.wb.wbbackend.repositorios.RepositorioConsumo;

@CrossOrigin
@RestController
public class ControleConsumo {
	@Autowired
	private RepositorioConsumo repositorio;
	@Autowired
	private HateoasConsumo hateoas;
	@Autowired
	private AtualizadorConsumo atualizador;

	@GetMapping("/consumo/{id}")
	public ResponseEntity<Consumo> obterConsumo(@PathVariable Long id) {
		Consumo consumo = repositorio.findById(id).get();
		if (consumo != null) {
			hateoas.adicionarLink(consumo);
			return new ResponseEntity<Consumo>(consumo, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Consumo>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/consumos")
	public ResponseEntity<List<Consumo>> obterConsumos() {
		List<Consumo> consumos = repositorio.findAll();
		hateoas.adicionarLink(consumos);
		return new ResponseEntity<List<Consumo>>(consumos, HttpStatus.FOUND);
	}

	@PostMapping("/consumo/cadastrar")
	public ResponseEntity<?> cadastrarConsumo(@RequestBody Consumo novo) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		if (novo != null) {
			repositorio.save(novo);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(status);
	}
	
	@PutMapping("/consumo/atualizar")
	public ResponseEntity<?> atualizarConsumo(@RequestBody Consumo atualizacao) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Consumo consumo = repositorio.getById(atualizacao.getId());
		if (consumo != null) {
			atualizador.atualizar(consumo, atualizacao);
			repositorio.save(consumo);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/consumo/excluir")
	public ResponseEntity<?> excluirConsumo(@RequestBody Consumo exclusao) {
		Consumo consumo = repositorio.getById(exclusao.getId());
		if (consumo == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			repositorio.delete(consumo);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}