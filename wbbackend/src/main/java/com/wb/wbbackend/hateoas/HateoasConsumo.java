package com.wb.wbbackend.hateoas;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.wb.wbbackend.controles.ControleConsumo;
import com.wb.wbbackend.entidades.Consumo;

@Component
public class HateoasConsumo implements Hateoas<Consumo> {

	@Override
	public void adicionarLink(List<Consumo> lista) {
		for (Consumo ps : lista) {
			long id = ps.getId();
			Link linkProprio = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(ControleConsumo.class).obterConsumo(id)).withSelfRel();
			ps.add(linkProprio);
		}
	}

	@Override
	public void adicionarLink(Consumo objeto) {
		Link linkProprio = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleConsumo.class)
						.obterConsumos())
				.withRel("consumo");
		objeto.add(linkProprio);

	}

}
