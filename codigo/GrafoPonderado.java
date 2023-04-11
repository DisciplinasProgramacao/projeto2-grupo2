package codigo;

public class GrafoPonderado extends GrafoMutavel {

	public GrafoPonderado(String nome) {
		super(nome);
	}
	
	@Override
    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice entrada = this.existeVertice(destino);
        if(saida!=null && entrada !=null){
            saida.addAresta(destino,peso);
            entrada.addAresta(origem,peso);
            adicionou = true;
        }
        return adicionou;
    }
	@Override
	public Aresta removeAresta(int origem, int destino) {
	    Vertice vOrigem = existeVertice(origem);
	    Vertice vDestino = existeVertice(destino);
	    
	    if (vOrigem != null && vDestino != null) {
	        Aresta aresta = vOrigem.existeAresta(destino);
	        if (aresta != null) {
	            vOrigem.removeAresta(destino);
	            vDestino.removeAresta(origem);
	            return new Aresta(destino);
	        }
	    }
	    
	    return null;
	}
    
}
