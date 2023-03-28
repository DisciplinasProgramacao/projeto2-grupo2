package codigo;

public class GrafoCompleto extends Grafo {
	private int ordem;

	/**
	 * Construtor que cria um Grafo Completo
	 * 
	 * @param nome
	 * @param ordem
	 */
	public GrafoCompleto(String nome, int ordem) {
		super(nome);

		for (int i = 1; i <= ordem; i++) {
			addVertice(i);
		}

		for (int i = 1; i <= ordem; i++) {
			for (int j = i + 1; j <= ordem; j++) {
				addAresta(i, j, 1);
			}
		}
	}
}
