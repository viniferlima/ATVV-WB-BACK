package com.wb.wbbackend.verificadores;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class VerificadorStringNula implements Verificador<String> {
	@Override
	public boolean verificar(String objeto) {
		boolean nulo = true;
		if (!(objeto == null)) {
			nulo = StringUtils.isBlank(objeto);
		}
		return nulo;
	}
}