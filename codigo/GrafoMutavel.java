package codigo;

public class GrafoMutavel extends Grafo {

    /**
     * Construtor que cria um grafo passando o seu nome por parametro
     *
     * @param nome
     */
    public GrafoMutavel(String nome) {
        super(nome);
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

}
