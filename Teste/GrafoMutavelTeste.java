package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codigo.GrafoMutavel;

class GrafoMutavelTeste {

    private GrafoMutavel grafo;

    @BeforeEach
    void setUp() throws Exception {
        grafo = new GrafoMutavel("meuGrafo");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addAresta(1, 2, 5);
        grafo.addAresta(2, 3, 7);
    }

    @Test
    void testandoAddVertice() {
        assertFalse(grafo.addVertice(1));
        assertTrue(grafo.addVertice(4));
    }

    @Test
    void testandoRemoveVertice() {
        assertNull(grafo.removeVertice(4));
        assertNotNull(grafo.removeVertice(1));
    }

    @Test
    void testandoAddAresta() {
        assertFalse(grafo.addAresta(1, 2, 10));
        assertTrue(grafo.addAresta(1, 3, 3));
    }

    @Test
    void testandoRemoveAresta() {
        assertNull(grafo.removeAresta(1, 3));
        assertNotNull(grafo.removeAresta(1, 2));
    }

}
