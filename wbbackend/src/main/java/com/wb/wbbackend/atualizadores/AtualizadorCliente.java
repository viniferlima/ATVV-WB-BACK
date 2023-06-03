package com.wb.wbbackend.atualizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wb.wbbackend.entidades.Cliente;
import com.wb.wbbackend.verificadores.VerificadorEnderecoNulo;
import com.wb.wbbackend.verificadores.VerificadorStringNula;

@Component
public class AtualizadorCliente implements Atualizador<Cliente> {
	@Autowired
	private VerificadorStringNula verificadorString;
	@Autowired
	private VerificadorEnderecoNulo verificadorEndereco;
	@Autowired
	private AtualizadorEndereco atualizadorEndereco;

	@Override
	public void atualizar(Cliente alvo, Cliente atualizacao) {
		if (!verificadorString.verificar(atualizacao.getNome())) {
			alvo.setNome(atualizacao.getNome());
		}
		if (!verificadorString.verificar(atualizacao.getEmail())) {
			alvo.setEmail(atualizacao.getEmail());
		}
		if (!verificadorString.verificar(atualizacao.getSobreNome())) {
			alvo.setSobreNome(atualizacao.getSobreNome());
		}
		if (!verificadorString.verificar(atualizacao.getGenero())) {
			alvo.setGenero(atualizacao.getGenero());
		}
		if (!verificadorString.verificar(atualizacao.getCpf())) {
			alvo.setCpf(atualizacao.getCpf());
		}
		if (!verificadorEndereco.verificar(atualizacao.getEndereco())) {
			if (alvo.getEndereco() != null) {
				atualizadorEndereco.atualizar(alvo.getEndereco(), atualizacao.getEndereco());
			} else {
				alvo.setEndereco(atualizacao.getEndereco());
			}
		}
		if (!verificadorString.verificar(atualizacao.getTelefone())) {
			alvo.setTelefone(atualizacao.getTelefone());
		}
	}
}