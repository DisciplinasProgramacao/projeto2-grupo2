package codigo;

import java.util.ArrayList;
import java.util.List;

/*
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public class Grafo {
	public final String nome;
	ABB<Vertice> vertices;

	public static Grafo grafoCompleto(int ordem) {
		return null;
	}

	/**
	 * Construtor que cria um grafo passando o seu nome por parametro
	 * 
	 * @param nome
	 */
	public Grafo(String nome) {
		this.nome = nome;
		this.vertices = new ABB<>();
	}

	/**
	 * Retorna o nome do grafo (string), caso seja necessário em outras
	 * classes/sistemas
	 * 
	 * @return O nome do grafo (uma string)
	 */
	public String nome() {
		return this.nome;
	}

	/**
	 * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se
	 * já existir um vértice com este id
	 * 
	 * @param id O identificador do vértice a ser criado/adicionado
	 * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com
	 *         este id
	 */
	public boolean addVertice(int id) {
		Vertice novo = new Vertice(id);
		return this.vertices.add(id, novo);
	}

	/**
	 * Método que remove o vértice pelo id
	 * 
	 * @param id
	 * @return
	 */
	public Vertice removeVertice(int id) {
		return this.vertices.remove(id);
	}

	/**
	 * Classe que verifica se existe vértice pelo Id
	 * 
	 * @param idVertice
	 * @return
	 */
	public Vertice existeVertice(int idVertice) {
		return this.vertices.find(idVertice);
	}

	/**
	 * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices
	 * existam no grafo. Caso a aresta já exista, ou algum dos vértices não existir,
	 * o comando é ignorado e retorna FALSE.
	 * 
	 * @param origem  Vértice de origem
	 * @param destino Vértice de destino
	 * @param peso    Peso da aresta
	 * @return TRUE se foi inserida, FALSE caso contrário
	 */
	public boolean addAresta(int origem, int destino, int peso) {
		boolean adicionou = false;
		Vertice saida = this.existeVertice(origem);
		Vertice chegada = this.existeVertice(destino);
		if (saida != null && chegada != null) {
			adicionou = (saida.addAresta(destino, peso) && chegada.addAresta(origem, peso));
		}
		return adicionou;

	}

	/**
	 * Método que verifica se existe aresta entre dois vértices
	 * 
	 * @param verticeA
	 * @param verticeB
	 * @return
	 */
	public Aresta existeAresta(int verticeA, int verticeB) {
		if (this.vertices.find(verticeA).existeAresta(verticeB) != null) {
			return this.vertices.find(verticeA).existeAresta(verticeB);
		}
		return null;
	}

	/**
	 * Método que cria uma Lista de vertices e verifica se é completo
	 * 
	 * @return
	 */

	public boolean completo() {
		List<Vertice> listaVertices = new ArrayList<>();

	    for (Vertice vertice : listaVertices) {
	        if (vertice.grau() != listaVertices.size() - 1) {
	            return false;
	        }
	    }
	    return true;
	}
	/**
	 * Método que cria um subGrafo a partir de uma lista de vertices
	 * @param vertices
	 * @return
	 */
	public Grafo subGrafo(Lista<Integer> vertices) {
		Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);

		return subgrafo;
	}

	/**
	 * Método que calcula o tamanho do grafo
	 * 
	 * @return
	 */
	public int tamanho() {
		int tamanho = 0;
		List<Vertice> listVertices = new ArrayList<>();
		for (Vertice vertice : listVertices) {
			tamanho += vertice.grau();
		}
		tamanho /= 2;
		tamanho += ordem();
		return tamanho;
	}

	/**
	 * Método que calcula a ordem(quantidade de vértices) de um grafo
	 * @return
	 */
	public int ordem() {
		return this.vertices.size();
	}

}
