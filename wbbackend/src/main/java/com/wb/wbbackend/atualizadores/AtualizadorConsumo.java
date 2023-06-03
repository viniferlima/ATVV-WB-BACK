package com.wb.wbbackend.atualizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wb.wbbackend.entidades.Consumo;
import com.wb.wbbackend.entidades.Item;
import com.wb.wbbackend.verificadores.VerificadorPrecoNulo;
import com.wb.wbbackend.verificadores.VerificadorStringNula;

@Component
public class AtualizadorConsumo implements Atualizador<Consumo> {
	@Autowired
	private VerificadorStringNula verificadorString;
	@Autowired
	private VerificadorPrecoNulo verificadorPreco;
	@Autowired
	private AtualizadorItem atualizadorItem;

	@Override
	public void atualizar(Consumo alvo, Consumo atualizacao) {
		if (!verificadorString.verificar(atualizacao.getDataCriacao())) {
			alvo.setDataCriacao(atualizacao.getDataCriacao());
		}
		if (!verificadorPreco.verificar(atualizacao.getTotal())) {
			alvo.setTotal(atualizacao.getTotal());
		}
		if (atualizacao.getCliente() != null) {
			alvo.setCliente(atualizacao.getCliente());
		}
			
		if (atualizacao.getItens().size() > 0) {
			alvo.getItens().clear();
			for (Item item : atualizacao.getItens()) {
				if (item != null) {
					Item novoItem = new Item();
					novoItem.setQuantidade(item.getQuantidade());
					novoItem.setSubtotal(item.getSubtotal());
					novoItem.setProdutoServico(item.getProdutoServico());
					alvo.getItens().add(novoItem);
				}
			}
		}
	}
}