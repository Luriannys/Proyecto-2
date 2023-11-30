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
    private String type;
    private boolean status;
    private Document derecha;
    private Document izquierda;
    private int fe;
    private double priority;
    private Document pNext;
    private Document head;
    private Document tail;

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
        this.pNext = null;
        this.head = null;
        this.tail = null;

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

    /**
     * getDerecha
     *
     * @return
     */
    public Document getDerecha() {
        return derecha;
    }

    /**
     * setDerecha
     *
     * @param derecha
     */
    public void setDerecha(Document derecha) {
        this.derecha = derecha;
    }

    /**
     * getIzquierda
     *
     * @return
     */
    public Document getIzquierda() {
        return izquierda;
    }

    /**
     * setIzquierda
     *
     * @param izquierda
     */
    public void setIzquierda(Document izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * getFe
     *
     * @return
     */
    public int getFe() {
        return fe;
    }

    /**
     * setFe
     *
     * @param fe
     */
    public void setFe(int fe) {
        this.fe = fe;
    }

    /**
     * imprimirDoc
     *
     * @param doc
     */
    public void imprimirDoc(Document doc) {
        if (doc != null) {
            System.out.println(doc.size);
        }
    }

    /**
     * getFe
     *
     * @param doc
     * @return
     */
    public int obtenerFe(Document doc) {
        if (doc == null) {
            return 0;
        } else {
            return doc.getFe();
        }
    }

    /**
     * altura
     *
     * @param n
     * @return
     */
    public int altura(Document n) {
        return (Math.max(obtenerFe(n.getIzquierda()), obtenerFe(n.getDerecha())) + 1);
    }

    /**
     * alturaIzq
     *
     * @return
     */
    public int alturaIzq() {
        if (izquierda == null) {
            return 0;
        }
        return izquierda.getFe();
    }

    /**
     * alturaDer
     *
     * @return
     */
    public int alturaDer() {
        if (derecha == null) {
            return 0;
        }
        return derecha.getFe();
    }

    /**
     * rotacionIzquierda
     *
     * @param n
     */
    public void rotacionIzquierda(Document n) {
        Document aux = new Document(n.getName(), n.getSize(), n.getType());
        aux.setIzquierda(n.getIzquierda());
        aux.setDerecha(n.getDerecha().getIzquierda());
        n.setSize(n.getDerecha().getSize());
        n.setDerecha(n.getDerecha().getDerecha());
        n.setIzquierda(aux);

    }

    /**
     * rotacionDerecha
     *
     * @param n
     */
    public void rotacionDerecha(Document n) {
        Document aux = new Document(n.getName(), n.getSize(), n.getType());
        aux.setDerecha(n.getDerecha());
        aux.setIzquierda(n.getIzquierda().getDerecha());
        n.setSize(n.getIzquierda().getSize());
        n.setIzquierda(n.getIzquierda().getIzquierda());
        n.setDerecha(aux);

    }

    /**
     * insertar
     *
     * @param doc
     * @return
     */
    public Document insertar(Document doc) {
        if (doc == null) {
            getHead().queue(doc);
            return doc;
        }
        if (doc.getSize() < this.getSize()) {
            if (this.getIzquierda() == null) {
                this.setIzquierda(doc);
                setHead(doc);
            } else {
                this.getIzquierda().insertar(doc);
            }
        } else {
            if (this.getDerecha() == null) {
                this.setDerecha(doc);
                setTail(doc);
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

    /**
     * Existe
     *
     * @param rdoc
     * @param doc
     * @return
     */
    public boolean existe(Document rdoc, Document doc) {
//        Document document = (Document) nodo.getElement();
        if (rdoc == null) {
            return false;
        }
        if (rdoc.getSize() == doc.getSize()) {
            return true;
        } else if (doc.getSize() < doc.getSize()) {
            return existe(doc.getDerecha(), doc);
        } else {
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

    /**
     * IgualQue
     *
     * @param q
     * @return
     */
    public boolean igualQue(Document q) {
        Document n2 = q;
        return this.priority == n2.getPriority();
    }

    /**
     * menorQue
     *
     * @param q
     * @return
     */
    public boolean menorQue(Document q) {
        Document n2 = q;
        return this.priority < n2.getPriority();
    }

    /**
     * mayorQue
     *
     * @param q
     * @return
     */
    public boolean mayorQue(Document q) {
        Document n2 = q;
        return this.priority > n2.getPriority();
    }

    /**
     * menorIgualQue
     *
     * @param q
     * @return
     */
    public boolean menorIgualQue(Document q) {
        Document n2 = q;
        return this.priority <= n2.getPriority();
    }

    /**
     * mayorIgualQue
     *
     * @param q
     * @return
     */
    public boolean mayorIgualQue(Document q) {
        Document n2 = q;
        return this.priority >= n2.getPriority();
    }

    /**
     * nodosCompletos
     *
     * @param n
     * @return
     */
    public int nodosCompletos(Document n) {
        if (n == null) {
            return 0;
        } else {
            if (n.getIzquierda() != null && n.getDerecha() != null) {
                return nodosCompletos(n.getIzquierda()) + nodosCompletos(n.getDerecha()) + 1;
            }
            return nodosCompletos(n.getIzquierda()) + nodosCompletos(n.getDerecha());
        }
    }

    /**
     * queue
     *
     * @param nuevo
     */
    public void queue(Document nuevo) {
        if (this.isEmpty()) {
            setHead(nuevo);

        } else {
            getTail().setpNext(nuevo);

        }
        setTail(nuevo);
        setSize(getSize() + 1);
    }

    /**
     * getDoc
     * @return 
     */
    public Document getDoc() {
        if (this.isEmpty()) {
            return null;
        } else {
            return getHead();
        }

    }

    /**
     * getpNext
     * @return 
     */
    public Document getpNext() {
        return pNext;
    }

    /**
     * setpNext
     * @param pNext 
     */
    public void setpNext(Document pNext) {
        this.pNext = pNext;
    }

    /**
     * getHead
     * @return 
     */
    public Document getHead() {
        return head;
    }

    /**
     * setHead
     * @param head 
     */
    public void setHead(Document head) {
        this.head = head;
    }

    /**
     * getTail
     * @return 
     */
    public Document getTail() {
        return tail;
    }

    /**
     * setTail
     * @param tail 
     */
    public void setTail(Document tail) {
        this.tail = tail;
    }

    /**
     * empty
     */
    public void empty() {
        this.setHead(this.tail = null);
        this.setSize(0);
    }

    /**
     * isEmpty
     * @return 
     */
    public boolean isEmpty() {
        return getHead() == null;
    }

    /**
     * dequeue
     */
    public void dequeue() {
        if (this.isEmpty()) {
            System.out.println("La cola esta vacia");
        } else if (getSize() == 1) {
            this.empty();
        } else {
            Document elim = getHead();
            setHead(getHead().getpNext());
            setSize(getSize() - 1);
            elim.setpNext(null);
        }
    }

}
