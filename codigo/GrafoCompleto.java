package codigo;

public class GrafoCompleto extends Grafo {

	/**
	 * Construtor que cria um Grafo Completo
	 * 
	 * @param nome
	 * @param ordem
	 */
	public GrafoCompleto(String nome, int ordem) {
		super(nome);
		int i, j;
		for (i = 1; i <= ordem; i++) {
			Vertice novo = new Vertice(i);
			this.vertices.add(i, novo);
		}
		for (i = 1; i <= ordem; i++) {
			for (j = 1; j <= ordem; j++) {
				if (i != j) {
					this.vertices.find(i).addAresta(j);
				}
			}
		}
	}
}
