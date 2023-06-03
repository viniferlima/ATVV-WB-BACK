package com.wb.wbbackend.verificadores;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class VerificadorPrecoNulo implements Verificador<BigDecimal> {
	@Override
	public boolean verificar(BigDecimal objeto) {
		boolean nulo = true;
		if (objeto != null && objeto.compareTo(BigDecimal.ZERO) > 0) {
			nulo = false;
		}
		return nulo;
	}
}