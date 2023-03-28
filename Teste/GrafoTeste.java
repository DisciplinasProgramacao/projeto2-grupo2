package Teste;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import codigo.Grafo;

class GrafoTeste {

	Grafo grafo;

    @BeforeEach
    void init() {
        grafo = new Grafo("Grafo de Teste");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addAresta(1, 2, 1);
        grafo.addAresta(2, 3, 2);
        grafo.addAresta(3, 4, 3);
    }

    @Nested
    @DisplayName("Testes dos métodos de vértices")
    class TestesVertices {

        @Test
        @DisplayName("Teste do método addVertice")
        void testandoAdicionarVertice() {
            assertTrue(grafo.addVertice(5));
            assertFalse(grafo.addVertice(2));
        }

//        @Test
//        @DisplayName("Teste do método removeVertice")
//        void testandoRemoveVertice() {
//        	grafo.addVertice(1);
//            assertEquals(1, grafo.removeVertice(1));
//        }

        @Test
        @DisplayName("Teste do método existeVertice")
        void testandoExisteVertice() {
            assertNotNull(grafo.existeVertice(2));
            assertNull(grafo.existeVertice(5));
        }

    }
    @Nested
    @DisplayName("Testes dos métodos de arestas")
    class TestesArestas {

        @Test
        @DisplayName("Teste do método addAresta")
        void testandoAddAresta() {
            assertTrue(grafo.addAresta(2, 4, 2));
            assertFalse(grafo.addAresta(2, 5, 1));
            assertFalse(grafo.addAresta(5, 6, 3));
        }

        @Test
        @DisplayName("Teste do método existeAresta")
        void testandoExisteAresta() {
            assertNull(grafo.existeAresta(2, 4));
        }

    }

    @Nested
    @DisplayName("Testes dos métodos de grafos")
    class TestesGrafo {

        @Test
        @DisplayName("Teste do método completo")
        void testCompleto() {
             grafo.addAresta(1, 3, 1);
             grafo.addAresta(1, 4, 1);
             grafo.addAresta(2, 4, 1);
             assertTrue(grafo.completo());
        }
    }
}
