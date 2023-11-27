/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Luriannys Junco
 */
public class Document {

    private String name;
    private int size;
    private String type; //Posiblemente un int
    private boolean status;
    private Document derecha;
    private Document izquierda;
    private int fe;
    private double priority;

    /**
     * Constructor
     *
     * @param name
     * @param size
     * @param type
     * @param priority
     */
    public Document(String name, int size, String type, double priority) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.status = false; //No esta en la cola de impresion
        this.derecha = null;
        this.izquierda = null;
        this.fe = 0;
        this.priority = priority;
    }

    /**
     * Constructor
     *
     * @param name
     * @param size
     * @param type
     */
    public Document(String name, int size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.status = false; //No esta en la cola de impresion
        this.derecha = null;
        this.izquierda = null;
        this.fe = 0;
        this.priority = 1.0;
    }

    /**
     * Constructor (por si acaso)
     *
     * @param name
     * @param size
     */
    //    public Document(String name, int size) {
    //         this.name = name;
    //        this.size = size;
    //        this.type = "";
    //        this.status = false; //No esta en la cola de impresion
    //    }

    /**
     * getName
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getSize
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * setSize
     *
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * getType
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * setType
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getStatus
     *
     * @return the status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Document getDerecha() {
        return derecha;
    }

    public void setDerecha(Document derecha) {
        this.derecha = derecha;
    }

    public Document getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Document izquierda) {
        this.izquierda = izquierda;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public void imprimirDoc(Document doc) {
        if (doc != null) {
            System.out.println(doc.size);
        }

    }

    public int obtenerFe(Document doc) {
        if (doc == null) {
            return 0;
        } else {
            return doc.getFe();
        }
    }

    public int altura(Document n) {
        return (Math.max(obtenerFe(n.getIzquierda()), obtenerFe(n.getDerecha())) + 1);
    }

    public int alturaIzq() {
        if (izquierda == null) {
            return 0;
        }
        return izquierda.getFe();
    }

    public int alturaDer() {
        if (derecha == null) {
            return 0;
        }
        return derecha.getFe();
    }

    public void rotacionIzquierda(Document n) {
        Document aux = new Document(n.getName(), n.getSize(), n.getType());
        aux.setIzquierda(n.getIzquierda());
        aux.setDerecha(n.getDerecha().getIzquierda());
        n.setSize(n.getDerecha().getSize());
        n.setDerecha(n.getDerecha().getDerecha());
        n.setIzquierda(aux);

    }

    public void rotacionDerecha(Document n) {
        Document aux = new Document(n.getName(), n.getSize(), n.getType());
        aux.setDerecha(n.getDerecha());
        aux.setIzquierda(n.getIzquierda().getDerecha());
        n.setSize(n.getIzquierda().getSize());
        n.setIzquierda(n.getIzquierda().getIzquierda());
        n.setDerecha(aux);

    }

    public Document insertar(Document doc) {
        if (doc == null) {
            return doc;
        }
        if (doc.getSize() < this.getSize()) {
            if (this.getIzquierda() == null) {
                this.setIzquierda(doc);
            } else {
                this.getIzquierda().insertar(doc);
            }
        } else {
            if (this.getDerecha() == null) {
                this.setDerecha(doc);
            } else {
                this.getDerecha().insertar(doc);
            }
        }
        if (doc.alturaIzq() - doc.alturaDer() > 1) {
            if (doc.getIzquierda() != null && doc.getIzquierda().alturaDer() > doc.getIzquierda().alturaIzq()) {
                rotacionIzquierda(doc.getIzquierda());
                rotacionDerecha(doc);
            } else {
                rotacionDerecha(doc);
            }
            return doc;
        }
        if (doc.alturaDer() - doc.alturaIzq() > 1) {
            if (doc.getDerecha() != null && doc.getDerecha().alturaIzq() > doc.getDerecha().alturaDer()) {
                rotacionDerecha(doc.getDerecha());
                rotacionIzquierda(doc);
            } else {
                rotacionIzquierda(doc);
            }
        }
        return doc;
    }

     public boolean existe(Document rdoc,Document doc){
//        Document document = (Document) nodo.getElement();
        if (rdoc == null){
            return false;
        }
        if (rdoc.getSize() == doc.getSize()){
            return true;
        }
        else if (doc.getSize() < doc.getSize()){
            return existe(doc.getDerecha(), doc);
        }else{
            return existe(doc.getIzquierda(), doc);
        }
    }
    


    /**
     * @return the priority
     */
    public double getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(double priority) {
        this.priority = priority;
    }

    public boolean igualQue(Document q) {
        Document n2 = q;
        return this.priority == n2.getPriority();
    }

    public boolean menorQue(Document q) {
        Document n2 = q;
        return this.priority < n2.getPriority();
    }

    public boolean mayorQue(Document q) {
        Document n2 = q;
        return this.priority > n2.getPriority();
    }

    public boolean menorIgualQue(Document q) {
        Document n2 = q;
        return this.priority <= n2.getPriority();
    }

    public boolean mayorIgualQue(Document q) {
        Document n2 = q;
        return this.priority >= n2.getPriority();
    }
     
    public int nodosCompletos(Document n){
        if(n==null)
            return 0;
        else {
            if (n.getIzquierda()!= null && n.getDerecha()!= null){
                return nodosCompletos(n.getIzquierda())+ nodosCompletos(n.getDerecha())+1;
            }
            return nodosCompletos(n.getIzquierda())+ nodosCompletos(n.getDerecha());      
        }
    }
}
