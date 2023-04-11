package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    /**
     * Método que carrega um arquivo e cria um grafo a partir dos dados fornecidos
     * @param nomeArquivo
     */
    public void carregar(String nomeArquivo) throws FileNotFoundException {
        int i;
        int origem, destino;
        int numeroVertices;
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        numeroVertices = Integer.parseInt(linha);
        for(i=1;i<=numeroVertices;i++){
            addVertice(i);
        }
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            origem = Integer.parseInt(detalhes[0]);
            destino = Integer.parseInt(detalhes[1]);
            addAresta(origem,destino, numeroVertices);
        }
    }
    /**
     * Salva um grafo em um arquivo
     * @param nomeArquivo
     */

    public void salvar(String nomeArquivo) throws IOException {
        int i,j;
        FileWriter writer = new FileWriter(nomeArquivo);
        writer.write(Integer.toString(ordem()));
        writer.write("\n");
        Vertice[] arrayvertices = this.vertices.allElements(new Vertice[this.vertices.size()]);
        for(i=0;i<=this.vertices.size();i++){
            for(j=i+1;j<this.vertices.size();j++){
                if(existeAresta(arrayvertices[i].getId(),arrayvertices[j].getId())!=null){
                    writer.write(Integer.toString(arrayvertices[i].getId()));
                    writer.write(";");
                    writer.write(Integer.toString(arrayvertices[j].getId()));
                    writer.write("\n");
                }
            }
        }
        writer.close();

    }

}
