package codigo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner menu = new Scanner(System.in);

		System.out.print("|-------------Grafos----------------|\n");
		System.out.print("| Opção 1 - Grafo Completo     |\n");
		System.out.print("| Opção 2 - Busca Em Profundidade Grafo Simples              |\n");
		System.out.print("| Opção 3 - Busca Em Profundidade Grafo Não Ponderado              |\n");
		System.out.print("| Opção 4 - Busca Em Profundidade Grafo Ponderado              |\n");
		System.out.print("|-----------------------------|\n");
		System.out.print("Digite uma opção: ");

		int opcao = menu.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("Digite a ordem");
			int ordem = menu.nextInt();
			Grafo grafo = new GrafoCompleto("Grafo completo de ordem 4", ordem);
			for (Vertice v : grafo.getVertices()) {
				System.out.print(v.getId() + ": ");
				List<String> verticesAdjacentes = new ArrayList<>();
				for (Aresta a : v.getArestas().allElements(new Aresta[v.getArestas().size()])) {
					String travessao = a.destino() + "-";
					verticesAdjacentes.add(travessao);
				}
				String resultado = String.join("", verticesAdjacentes);
				if (!resultado.isEmpty()) {
					resultado = resultado.substring(0, resultado.length() - 1);
				}
				System.out.println(resultado);
			}
			break;

		case 2:
			GrafoMutavel grafoMutavel = new GrafoMutavel("Grafo Mutável");

			System.out.println("Digite a quantidade de vertices que deseja adicionar: ");
			int idVertice = menu.nextInt();
			for (int i = 0; i <= idVertice; i++) {
				grafoMutavel.addVertice(i);
			}
			int arestas = idVertice * (idVertice - 1) / 2;
			for (int i = 1; i <= idVertice; i++) {
				for (int j = i + 1; j <= idVertice; j++) {
					grafoMutavel.addAresta(i, j, 0);
				}
			}
			for (int i = 0; i <= idVertice; i++) {
				List<Integer> resultado = grafoMutavel.buscaProfundidade(i);
				System.out.println("Busca em Profundidade a partir do vértice " + i + ": " + resultado);
			}

			try {
				grafoMutavel.salvar("buscaprofundidade.txt");
				System.out
						.println("Busca em profundidade salva com sucesso! O resultado da busca está no arquivo txt.");
			} catch (IOException e) {
				System.out.println("Erro ao salvar Busca em profundidade: " + e.getMessage());
			}
			break;

		case 3:
			GrafoMutavel grafoMutavelNaoPonderado = new GrafoMutavel("Grafo Não Ponderado");
			System.out.println("Digite a quantidade de vértices que deseja adicionar no grafo não ponderado: ");
			int qtdVerticesNaoPonderado = menu.nextInt();
			for (int i = 0; i < qtdVerticesNaoPonderado; i++) {
				grafoMutavelNaoPonderado.addVertice(i);
			}
	        System.out.println("Digite a quantidade de arestas que deseja adicionar: ");
	        
	        int qtdArestasNaoPonderado = menu.nextInt();
	        
	        for (int i = 0; i < qtdArestasNaoPonderado; i++) {
	            System.out.println("Digite o vértice de origem da aresta " + (i + 1) + ": ");
	            int origem = menu.nextInt();
	            System.out.println("Digite o vértice de destino da aresta " + (i + 1) + ": ");
	            int destino = menu.nextInt();
	            System.out.println("Digite o peso da aresta " + (i + 1) + ": ");
	            int peso = menu.nextInt();
	            grafoMutavelNaoPonderado.addAresta(origem, destino, peso);
	        }
			for (int i = 0; i < qtdVerticesNaoPonderado; i++) {
				List<Integer> resultado = grafoMutavelNaoPonderado.buscaProfundidade(i);
				System.out.println(
						"Busca em Profundidade a partir do vértice " + i + " " + resultado);
			}
			try {
				grafoMutavelNaoPonderado.salvar("buscaProfundidadeNaoPonderado.txt");
				System.out.println("Busca em profundidade do grafo não ponderado salva com sucesso!");
			} catch (IOException e) {
				System.out.println("Erro ao salvar busca em profundidade do grafo não ponderado: " + e.getMessage());
			}
			break;
			
		case 4:
			System.out.println("Digite a quantidade de vértices que deseja adicionar: ");
	        int qtdVerticesPonderados = menu.nextInt();
	        GrafoPonderado grafoPonderado = new GrafoPonderado("Grafo Ponderado");

	        for (int i = 0; i < qtdVerticesPonderados; i++) {
	            grafoPonderado.addVertice(i);
	        }

	        System.out.println("Digite a quantidade de arestas que deseja adicionar: ");
	        int numArestas = menu.nextInt();
	        for (int i = 0; i < numArestas; i++) {
	            System.out.println("Digite o vértice de origem da aresta " + (i + 1) + ": ");
	            int origem = menu.nextInt();
	            System.out.println("Digite o vértice de destino da aresta " + (i + 1) + ": ");
	            int destino = menu.nextInt();
	            System.out.println("Digite o peso da aresta " + (i + 1) + ": ");
	            int peso = menu.nextInt();
	            grafoPonderado.addAresta(origem, destino, peso);
	        }

	        System.out.println("Digite o vértice inicial da busca em profundidade: ");
	        int vertice = menu.nextInt();
	        List<Integer> resultadoBusca = grafoPonderado.buscaProfundidade(vertice);
	        System.out.println("Busca em profundidade a partir do vértice " + vertice + ": " + resultadoBusca);

	        try {
	            grafoPonderado.salvar("grafoPonderado.txt");
	            System.out.println("Grafo salvo com sucesso!");
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar grafo: " + e.getMessage());
	        }
			break;

		}
	}
}