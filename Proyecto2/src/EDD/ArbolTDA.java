
package EDD;

/**
 *
 * @author rgabr
 */
public class ArbolTDA {
    private Document nodoRaiz;
    
    
    /**
     * Constructor
     */
    public ArbolTDA(){
        nodoRaiz=null;
    }
   
    /**
     * Vaciar
     */
    public void vaciar() {
	nodoRaiz = null;
    }
    /**
     * Vacio
     * @return 
     */
    public boolean Vacio() {
	return nodoRaiz == null;
    }
    
        /**
    * Imprimir inorden
    * @param n 
    */
    public void inorden(Document n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDoc(n);
            inorden(n.getDerecha());
        }
    }

    
    /**
     * getNodoRaiz
     * @return 
     */
    public Document getNodoRaiz() {
        return nodoRaiz;
    }
    
    

    /**
     * setNodoRaiz
     * @param nodoRaiz 
     */
    public void setNodoRaiz(Document nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }
}

