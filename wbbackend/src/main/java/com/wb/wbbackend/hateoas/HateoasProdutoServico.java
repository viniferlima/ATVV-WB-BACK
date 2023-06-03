package com.wb.wbbackend.hateoas;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.wb.wbbackend.controles.ControleProdutoServico;
import com.wb.wbbackend.entidades.ProdutoServico;

@Component
public class HateoasProdutoServico implements Hateoas<ProdutoServico> {

	@Override
	public void adicionarLink(List<ProdutoServico> lista) {
		for (ProdutoServico ps : lista) {
			long id = ps.getId();
			Link linkProprio = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(ControleProdutoServico.class).obterItem(id)).withSelfRel();
			ps.add(linkProprio);
		}
	}

	@Override
	public void adicionarLink(ProdutoServico objeto) {
		Link linkProprio = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleProdutoServico.class)
						.obterItens())
				.withRel("produtosServicos");
		objeto.add(linkProprio);

	}

}
