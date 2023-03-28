package Teste;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import codigo.Grafo;
import codigo.GrafoCompleto;

class GrafoCompletoTeste {
	Grafo grafoCompleto;
	
	@BeforeEach
	void init() throws Exception {
		grafoCompleto = new GrafoCompleto("Grafo com 5 vértices", 5);
	}

	@Test
	@DisplayName("Teste que verica se o grafo criado é completo")
	void testandoGrafoCompleto() {
		  assertTrue(grafoCompleto.completo());
	}

}
