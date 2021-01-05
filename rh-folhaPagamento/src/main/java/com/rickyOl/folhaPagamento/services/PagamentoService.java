package com.rickyOl.folhaPagamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rickyOl.folhaPagamento.entidades.Pagamento;
import com.rickyOl.folhaPagamento.entidades.Trabalhador;
import com.rickyOl.folhaPagamento.feignclients.TrabalhadorFeignClients;

@Service
public class PagamentoService {

//	@Value("${rh-trabalhador.host}")
//	private String trabalhadorHost; //UTILIZADO COM REST TEMPLATE
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private TrabalhadorFeignClients trabalhadorFeign;

	public Pagamento getPagamento(long trabalhadorId, int dias) {
		
		/* Utilizado para chamadas com restTemplate
		 * Map<String,String> uriParams = new HashMap<>();
		 * 
		 * uriParams.put("id", String.valueOf(trabalhadorId));
		 * 
		 * 
		 * Trabalhador trab = restTemplate.getForObject(trabalhadorHost +
		 * "/trabalhador/{id}", Trabalhador.class, uriParams );
		 */
		
		
		
		Trabalhador trab =  trabalhadorFeign.buscarPorId(trabalhadorId).getBody();
		
		return new Pagamento(trab.getNome(),trab.getValorDiaria(), dias);
	}
}
