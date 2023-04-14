package codigo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean x = false;
		do {
			System.out.print("|-------------Grafos----------------|\n");
			System.out.print("| Opção 1 - Grafo Completo     |\n");
			System.out.print("| Opção 2 - Busca Em Profundidade Grafo Simples              |\n");
			System.out.print("| Opção 3 - Grafo Direcionado              |\n");
			System.out.print("| Opção 4 - Grafo Não Direcionado              |\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("Digite uma opção: ");

			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite a ordem");
				int ordem = scanner.nextInt();
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
				int idVertice = scanner.nextInt();
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
					System.out.println(
							"Busca em profundidade salva com sucesso! O resultado da busca está no arquivo txt.");
				} catch (IOException e) {
					System.out.println("Erro ao salvar Busca em profundidade: " + e.getMessage());
				}
				break;

			case 3:

				GrafoDirecionado grafoDirecionado = new GrafoDirecionado("Grafo Direcionado");

				System.out.println("Digite a quantidade de vértices que deseja adicionar: ");
				int numVertices = scanner.nextInt();
				for (int i = 0; i < numVertices; i++) {
					grafoDirecionado.addVertice(i);
				}

				System.out.println("Digite a quantidade de arestas que deseja adicionar: ");
				int numeroArestas = scanner.nextInt();
				for (int i = 0; i < numeroArestas; i++) {
					System.out.println("Digite a origem, destino e peso da aresta " + (i + 1) + ":");
					int origemDirecionado = scanner.nextInt();
					int destinoDirecionado = scanner.nextInt();
					int peso = scanner.nextInt();
					grafoDirecionado.addAresta(origemDirecionado, destinoDirecionado, peso);
				}
				System.out.println("Deseja remover arestas? S/N");
				String removerAresta = scanner.next();
				if (removerAresta == "S") {
					System.out.println("Digite a origem e destino da aresta que deseja remover: ");
					int origemDirecionadoRemover = scanner.nextInt();
					int destinoDirecionadoRemover = scanner.nextInt();
					grafoDirecionado.removeAresta(origemDirecionadoRemover, destinoDirecionadoRemover);
				}
				break;

			case 4:
				GrafoNaoDirecionado grafoNaoDirecionado = new GrafoNaoDirecionado("Grafo Não Direcionado");

				System.out.println("Digite a quantidade de vértices que deseja adicionar: ");
				numVertices = scanner.nextInt();
				for (int i = 0; i < numVertices; i++) {
					grafoNaoDirecionado.addVertice(i);
				}

				System.out.println("Digite a quantidade de arestas que deseja adicionar: ");
				numeroArestas = scanner.nextInt();
				for (int i = 0; i < numeroArestas; i++) {
					System.out.println("Digite a origem, destino e peso da aresta " + (i + 1) + ":");
					int origemNaoDirecionado = scanner.nextInt();
					int destinoNaoDirecionado = scanner.nextInt();
					int peso = scanner.nextInt();
					grafoNaoDirecionado.addAresta(origemNaoDirecionado, destinoNaoDirecionado, peso);
				}
				System.out.println("Deseja remover arestas? S/N");
				String removerArestaNaoDirecionado = scanner.next();
				if (removerArestaNaoDirecionado == "S") {
				System.out.println("Digite a origem e destino da aresta que deseja remover: ");
				int origemNaoDirecionadoRemover = scanner.nextInt();
				int destinoNaoDirecionadoRemover = scanner.nextInt();
				grafoNaoDirecionado.removeAresta(origemNaoDirecionadoRemover, destinoNaoDirecionadoRemover);
				}
				break;
		     default:
		         System.out.println("Não existe está opção!");
		         x=true;
		         break;
			}
		} while (!x);

	}
}