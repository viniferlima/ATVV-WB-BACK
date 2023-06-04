package com.wb.wbbackend;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.wb.wbbackend.entidades.Cliente;
import com.wb.wbbackend.entidades.Consumo;
import com.wb.wbbackend.entidades.Endereco;
import com.wb.wbbackend.entidades.Item;
import com.wb.wbbackend.entidades.ProdutoServico;
import com.wb.wbbackend.repositorios.RepositorioCliente;
import com.wb.wbbackend.repositorios.RepositorioConsumo;
import com.wb.wbbackend.repositorios.RepositorioProdutoServico;

@SpringBootApplication
public class WbbackendApplication {

	public static void main(String[] args) {
		// Propriedades
		Map<String,Object> propriedades = new HashMap<>();
		propriedades.put("server.port", "32832");
		propriedades.put("spring.jpa.show-sql", "true");
		
		// Inicialização de propriedades em código
		SpringApplication app = new SpringApplication(WbbackendApplication.class);
		app.setDefaultProperties(propriedades);
        app.run(args);
        
        // Forma padrão para iniciar a aplicação
		//SpringApplication.run(WbbackendApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public RepositorioCliente repositorioCliente;
		
		@Autowired
		public RepositorioProdutoServico repositorioProdutoServico;
		
		@Autowired
		private RepositorioConsumo repositorioConsumo;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			
			// Inserindo clientes 
			
			Cliente cliente = new Cliente();
			cliente.setNome("Pedro Alcântara de Bragança e Bourbon");
			cliente.setSobreNome("Dom Pedro");
			cliente.setGenero("Masculino");
			cliente.setCpf("48923872822");
			cliente.setTelefone("12987037082");
			cliente.setQtdConsumida(0);
			cliente.setValorConsumido(new BigDecimal(0));

			Endereco endereco = new Endereco();
			endereco.setCidade("Rio de Janeiro");
			endereco.setEstado("Rio de Janeiro");
			endereco.setBairro("Centro");
			endereco.setRua("Praça Quinze de Novembro");
			endereco.setNumero("48");
			endereco.setCodigoPostal("20010-010");
			endereco.setInformacoesAdicionais("O Paço Imperial é " + "um edifício histórico localizado na "
					+ "atual Praça XV de Novembro, no centro " + "da cidade do Rio de Janeiro, Brasil.");

			repositorioCliente.save(cliente);

			Cliente cliente2 = new Cliente();
			cliente2.setNome("Teresa Cristina de Bourbon-Duas Sicílias");
			cliente2.setSobreNome("Mãe dos Brasileiros");
			cliente2.setGenero("Feminino");
			cliente2.setCpf("16498470274");
			cliente2.setTelefone("1298744510");
			cliente2.setQtdConsumida(0);
			cliente2.setValorConsumido(new BigDecimal(0));
			
			endereco = new Endereco();
			endereco.setCidade("Rio de Janeiro");
			endereco.setEstado("Rio de Janeiro");
			endereco.setBairro("Centro");
			endereco.setRua("Praça Quinze de Novembro");
			endereco.setNumero("48");
			endereco.setCodigoPostal("20010-010");
			endereco.setInformacoesAdicionais("O Paço Imperial é " + "um edifício histórico localizado na "
					+ "atual Praça XV de Novembro, no centro " + "da cidade do Rio de Janeiro, Brasil.");

			cliente2.setEndereco(endereco);
			repositorioCliente.save(cliente2);

			Cliente cliente3 = new Cliente();
			cliente3.setNome("Isabel Cristina Leopoldina Augusta Gonzaga de Bourbon e Bragança");
			cliente3.setSobreNome("Pricesa Isabel");
			cliente3.setGenero("Feminino");
			cliente3.setCpf("87945210265");
			cliente3.setTelefone("12987451025");
			cliente3.setQtdConsumida(0);
			cliente3.setValorConsumido(new BigDecimal(0));

			endereco = new Endereco();
			endereco.setCidade("Rio de Janeiro");
			endereco.setEstado("Rio de Janeiro");
			endereco.setBairro("Centro");
			endereco.setRua("Praça Quinze de Novembro");
			endereco.setNumero("48");
			endereco.setCodigoPostal("20010-010");
			endereco.setInformacoesAdicionais("O Paço Imperial é " + "um edifício histórico localizado na "
					+ "atual Praça XV de Novembro, no centro " + "da cidade do Rio de Janeiro, Brasil.");

			cliente3.setEndereco(endereco);
			repositorioCliente.save(cliente3);

			Cliente cliente4 = new Cliente();
			cliente4.setNome("Leopoldina Teresa Gonzaga de Bragança e Bourbon-Duas Sicílias");
			cliente4.setSobreNome("Pricesa Leopoldina");
			cliente4.setGenero("Feminino");
			cliente4.setCpf("09997097801");
			cliente4.setTelefone("12977451710");
			cliente4.setQtdConsumida(0);
			cliente4.setValorConsumido(new BigDecimal(0));

			endereco = new Endereco();
			endereco.setCidade("Rio de Janeiro");
			endereco.setEstado("Rio de Janeiro");
			endereco.setBairro("Centro");
			endereco.setRua("Praça Quinze de Novembro");
			endereco.setNumero("48");
			endereco.setCodigoPostal("20010-010");
			endereco.setInformacoesAdicionais("O Paço Imperial é " + "um edifício histórico localizado na "
					+ "atual Praça XV de Novembro, no centro " + "da cidade do Rio de Janeiro, Brasil.");

			cliente4.setEndereco(endereco);
			repositorioCliente.save(cliente4);
			
			
			// Inserindo Produtos/Serviços

			ProdutoServico ps1 = new ProdutoServico();
			ps1.setNome("Esmalte");
			ps1.setPreco(new BigDecimal(10.00));
			ps1.setQtdConsumida(0);
			ps1.setQtdConsumidaGeneroMasculino(0);
			ps1.setQtdConsumidaGeneroFeminino(0);
			ps1.setQtdConsumidaGeneroOutro(0);
			ps1.setTipo("Produto");
			repositorioProdutoServico.save(ps1);
			
			ProdutoServico ps2 = new ProdutoServico();
			ps2.setNome("Corte de cabelo");
			ps2.setPreco(new BigDecimal(30.00));
			ps2.setQtdConsumida(0);
			ps2.setQtdConsumidaGeneroMasculino(0);
			ps2.setQtdConsumidaGeneroFeminino(0);
			ps2.setQtdConsumidaGeneroOutro(0);
			ps2.setTipo("Servico");
			repositorioProdutoServico.save(ps2);
			
			ProdutoServico ps3 = new ProdutoServico();
			ps3.setNome("Shampoo");
			ps3.setPreco(new BigDecimal(50.00));
			ps3.setQtdConsumida(0);
			ps3.setQtdConsumidaGeneroMasculino(0);
			ps3.setQtdConsumidaGeneroFeminino(0);
			ps3.setQtdConsumidaGeneroOutro(0);
			ps3.setTipo("Produto");
			repositorioProdutoServico.save(ps3);
			
			ProdutoServico ps4 = new ProdutoServico();
			ps4.setNome("Limpeza de pele");
			ps4.setPreco(new BigDecimal(80.00));
			ps4.setQtdConsumida(0);
			ps4.setQtdConsumidaGeneroMasculino(0);
			ps4.setQtdConsumidaGeneroFeminino(0);
			ps4.setQtdConsumidaGeneroOutro(0);
			ps4.setTipo("Servico");
			repositorioProdutoServico.save(ps4);

			
			// Inserindo consumo
			
			Consumo consumo = new Consumo();			
	        Date dataAtual = new Date();	        
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        String dataFormatada = sdf.format(dataAtual);
			consumo.setDataCriacao(dataFormatada);
			consumo.setCliente(cliente2);
			Item itemConsumo = new Item();
			itemConsumo.setProdutoServico(ps1);
			consumo.getItens().add(itemConsumo);
			consumo.getItens().get(0).setQuantidade(2);
			consumo.getItens().get(0)
			.setSubtotal(consumo.getItens().get(0).getProdutoServico().getPreco()
					.multiply(new BigDecimal(consumo.getItens().get(0).getQuantidade())));
			consumo.setTotal(consumo.getItens().get(0).getSubtotal());
			repositorioConsumo.save(consumo);
			
			ps1.setQtdConsumida(2);
			ps1.setQtdConsumidaGeneroFeminino(2);
			repositorioProdutoServico.save(ps1);
			
			cliente2.setQtdConsumida(2);
			cliente2.setValorConsumido(consumo.getTotal());
			repositorioCliente.save(cliente2);
		}
	}
}