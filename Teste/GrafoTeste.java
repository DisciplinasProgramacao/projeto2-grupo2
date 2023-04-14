package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codigo.Grafo;
import codigo.Vertice;

class GrafoTeste {

	Grafo grafo;
    
    @BeforeEach
    void setUp() throws Exception {
        grafo = new Grafo("Grafo Teste");
        Vertice v1 = new Vertice(1);
        Vertice v2 = new Vertice(2);
        Vertice v3 = new Vertice(3);
        grafo.getVertices().add(v1);
        grafo.getVertices().add(v2);
        grafo.getVertices().add(v3);
        v1.addAresta(1, 1);
        v1.addAresta(2, 1);
        v2.addAresta(3, 1);
    }

    @Test
    void testNome() {
        assertEquals("Grafo Teste", grafo.nome());
    }
    
    @Test
    void testExisteVertice() {
        assertNotNull(grafo.existeVertice(1));
        assertNull(grafo.existeVertice(4));
    }
    
    @Test
    void testExisteAresta() {
        assertNotNull(grafo.existeAresta(1, 2));
        assertNotNull(grafo.existeAresta(1, 3));
        assertNotNull(grafo.existeAresta(2, 3));
        assertNull(grafo.existeAresta(1, 4));
    }
    
    @Test
    void testTamanho() {
        
        Vertice v4 = new Vertice(4);
        
        v4.addAresta(4, 1);
        assertEquals(4, grafo.tamanho());
    }
    
    @Test
    void testOrdem() {
        assertEquals(3, grafo.ordem());
        grafo.getVertices().add(new Vertice(4));
        assertEquals(4, grafo.ordem());
    }
    
    @Test
    void testBuscaProfundidade() {
        List<Integer> listaEsperada = new ArrayList<>();
        listaEsperada.add(1);
        listaEsperada.add(2);
        listaEsperada.add(3);
        assertEquals(listaEsperada, grafo.buscaProfundidade(1));
    }
}
