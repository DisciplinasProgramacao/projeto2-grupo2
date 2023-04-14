package Teste;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import codigo.GrafoNaoDirecionado;

class GrafoNaoDirecionadoTeste {
	GrafoNaoDirecionado grafo = new GrafoNaoDirecionado("Grafo Não Direcionado");

	@Test
	public void testandoAddAresta() {

		assertTrue(grafo.addVertice(0));
		assertTrue(grafo.addVertice(1));
		assertTrue(grafo.addVertice(2));

		assertTrue(grafo.addAresta(0, 1, 10));
		assertTrue(grafo.addAresta(1, 2, 20));
	}

	@Test
	public void testandoRemoveAresta() {

		assertTrue(grafo.addVertice(0));
		assertTrue(grafo.addVertice(1));
		assertTrue(grafo.addVertice(2));

		assertTrue(grafo.addAresta(0, 1, 10));
		assertTrue(grafo.addAresta(1, 2, 20));

		assertNull(grafo.removeAresta(0, 2));
	}
}
