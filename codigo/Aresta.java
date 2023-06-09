package codigo;

/**
 * MIT License
 *
 * Copyright(c) 2021 Jo&atilde;o Caram <caram@pucminas.br>
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

public class Aresta {

    private int peso;
    private int destino;
    private boolean visitada;
    private int origem;

    /**
     * Construtor para arestas com peso. A aresta é criada como não-visitada.
     * @param peso Peso da aresta
     * @param destino Vértice de destino
     */
    public Aresta(int destino, int peso){
        this.peso = peso;
        this.destino = destino;
        this.visitada = false;
    }
    // Construtor para arestas sem peso.
    public Aresta(int destino){
        this.destino = destino;
        this.visitada = false;
    }
    
    public Aresta(int origem, int destino, int peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    /**
     * Método de acesso para o peso da aresta
     * @return Peso da aresta (int)
     */
    public int peso() {
        return this.peso;
    }
   
    /**
     * Método de acesso para o destino da aresta
     * @return Id do vértice de destino
     */
    public int destino() {
        return this.destino;
    }

    /**
     * Marca a aresta como visitada
     */
    public void visitar(){
        this.visitada = true;
    }

    /**
     * Marca a aresta como não visitada.
     */
    public void limparVisita(){
        this.visitada = false;
    }

    /**
     * Indica se a aresta foi visitada (TRUE) ou não (FALSE)
     * @return TRUE/FALSE conforme a aresta foi visitada ou não.
     */
    public boolean visitada(){
        return this.visitada;
    }
    
    /**
     * Getters e Setters
     * @return
     */
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}
	public int getOrigem() {
		return origem;
	}
	public void setOrigem(int origem) {
		this.origem = origem;
	}
    

    

}
