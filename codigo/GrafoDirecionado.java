package codigo;

public class GrafoDirecionado extends GrafoMutavel {

	public GrafoDirecionado(String nome) {
		super(nome);
	}
	/**
	 * Método que adicona aresta no grago direcionado
	 * @param origem, destino, peso
	 */
	@Override
    public boolean addAresta(int origem, int destino, int peso) {
        Vertice vOrigem = vertices.find(origem);
        Vertice vDestino = vertices.find(destino);

        if (vOrigem != null && vDestino != null) {
            Aresta aresta = new Aresta(vOrigem.getId(), vDestino.getId(), peso);
            vOrigem.addAresta(vDestino.getId());
            return true;
        }
        return false;
    }
	
	/**
	 * Método que remove aresta no grafo não direcionado
	 * @param origem, destino
	 */
	@Override
	public Aresta removeAresta(int origem, int destino) {
		Vertice vOrigem = vertices.find(origem);
	    Vertice vDestino = vertices.find(destino);
	    
	    if (vOrigem != null && vDestino != null) {
	        Aresta aresta = vOrigem.existeAresta(destino);
	        if (aresta != null) {
	            vOrigem.removeAresta(destino);
	            return aresta;
	        }
	    }
	    
	    return null;
	}
    
}
