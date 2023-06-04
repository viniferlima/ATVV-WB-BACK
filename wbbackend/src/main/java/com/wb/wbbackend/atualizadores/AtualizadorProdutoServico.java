package com.wb.wbbackend.atualizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wb.wbbackend.entidades.ProdutoServico;
import com.wb.wbbackend.verificadores.VerificadorPrecoNulo;
import com.wb.wbbackend.verificadores.VerificadorStringNula;

@Component
public class AtualizadorProdutoServico implements Atualizador<ProdutoServico> {
	@Autowired
	private VerificadorStringNula verificadorString;
	
	@Autowired
	private VerificadorPrecoNulo verificadorPreco;

	@Override
	public void atualizar(ProdutoServico alvo, ProdutoServico atualizacao) {
		if (!verificadorString.verificar(atualizacao.getNome())) {
			alvo.setNome(atualizacao.getNome());
		}
		if (!verificadorString.verificar(atualizacao.getTipo())) {
			alvo.setTipo(atualizacao.getTipo());
		}
		if (!verificadorPreco.verificar(atualizacao.getPreco())) {
			alvo.setPreco(atualizacao.getPreco());
		}
	}
}