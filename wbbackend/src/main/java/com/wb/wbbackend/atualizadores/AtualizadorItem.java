package com.wb.wbbackend.atualizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wb.wbbackend.entidades.Item;
import com.wb.wbbackend.verificadores.VerificadorPrecoNulo;

@Component
public class AtualizadorItem implements Atualizador<Item> {
	@Autowired
	private VerificadorPrecoNulo verificadorPreco;

	@Override
	public void atualizar(Item alvo, Item atualizacao) {
		if (atualizacao.getQuantidade() != null) {
			alvo.setQuantidade(atualizacao.getQuantidade());
		}
		if (!verificadorPreco.verificar(atualizacao.getSubtotal())) {
			alvo.setSubtotal(atualizacao.getSubtotal());
		}
		if (atualizacao.getProdutoServico() != null) {
			alvo.setProdutoServico(atualizacao.getProdutoServico());
		}
	}
}