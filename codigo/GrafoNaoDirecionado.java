package codigo;

public class GrafoNaoDirecionado extends GrafoMutavel {

	public GrafoNaoDirecionado(String nome) {
		super(nome);
	}

	/**
	 * Método que adiciona Arestas no grafo
	 * @param origem, destino, peso 
	 */
	@Override
	public boolean addAresta(int origem, int destino, int peso) {
		Vertice vOrigem = vertices.find(origem);
		Vertice vDestino = vertices.find(destino);

		if (vOrigem != null && vDestino != null) {
			Aresta aresta = new Aresta(vOrigem.getId(), vDestino.getId(), peso);
			vOrigem.addAresta(origem);
			vDestino.addAresta(destino);
			return true;
		}
		return false;
	}

	/**
	 * Método que remove Arestas no grafo
	 * @param origem destino
	 */
	public Aresta removeAresta(int origem, int destino) {
		Vertice vOrigem = existeVertice(origem);
		Vertice vDestino = existeVertice(destino);

		if (vOrigem != null && vDestino != null) {
			Aresta aresta = vOrigem.existeAresta(destino);
			if (aresta != null) {
				vOrigem.removeAresta(destino);
				vDestino.removeAresta(origem);
				return aresta;
			}
		}

		return null;
	}
}