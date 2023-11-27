/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Luriannys Junco
 */
public class Lista {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    /**
     * Constructor
     */
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Metodo que verifica si la lista esta vacia
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return pFirst == null;
    }

    /**
     * Vacia la lista
     */
    public void empty() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Metodo que agrega un nodo al final de la lista
     *
     * @param newNodo
     */
    public void addAtTheEnd(Nodo newNodo) {
        if (this.isEmpty()) {
            pFirst = pLast = newNodo;
        } else {
            pLast.setpNext(newNodo);
            pLast = newNodo;
        }
        size++;
    }

    /**
     * Metodo que agrega un nodo al inicio de la lista
     *
     * @param newNodo
     */
    public void addAtTheStart(Nodo newNodo) {
        if (this.isEmpty()) {
            pFirst = pLast = newNodo;
        } else {
            newNodo.setpNext(getpFirst());
            setpFirst(newNodo);
        }
        size++;
    }

    /**
     * Metodo que elimina un nodo al inicio de la lista
     */
    public void DeleteAtTheStart() {
        if (!this.isEmpty()) {
            if (size == 1) {
                this.empty();
            } else {
                pFirst = pFirst.getpNext();
                size--;
            }
        }
    }

    /**
     * Metodo que imprime cada nodo de la lista
     */
    public void print() {
        User element;
        Nodo temp = pFirst;
        if (this.isEmpty()) {
            System.out.println("The list is empty.");
        }
        while (temp != null) {
            element = (User) temp.getElement();
            element.print();
            temp = temp.getpNext();
        }
    }

    /**
     * Metodo que retorna los elementos como un string separado por comas
     *
     * @return
     */
    public String printString() {
        Document element;
        String str = "";
        User user = (User) getpFirst().getpNext().getElement();
        Lista list = user.getDocumentos();
        if (list != null) {
            Nodo temp = list.getpFirst();
            while (temp != null) {
                element = (Document) temp.getElement();
                str += element.getName() + ",";
                temp = temp.getpNext();
            }
        }
        return str;
    }
        /**
         * @return pFirst
         */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

}
