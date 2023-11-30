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
    
    private User pFirst;
    private User pLast;
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
     * @param user
     * @param newNodo
     */
    public void addAtTheEnd(User user) {
        if (this.isEmpty()) {
            pFirst = pLast = user;
        } else {
            pLast.setPNext(user);
            pLast = user;
        }
        size++;
    }

    /**
     * Metodo que agrega un nodo al inicio de la lista
     *
     * @param newNodo
     */
    public void addAtTheStart(User newNodo) {
        if (this.isEmpty()) {
            pFirst = pLast = newNodo;
        } else {
            newNodo.setPNext(getpFirst());
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
                pFirst = pFirst.getPNext();
                size--;
            }
        }
    }

    /**
     * Metodo que imprime cada nodo de la lista
     * @param element
     */
//    public void print(String element) {
//        
//        User temp = pFirst;
//        if (this.isEmpty()) {
//            System.out.println("The list is empty.");
//        }
//        while (temp != null) {
//            element = temp.getUsuario();
//            temp.print(element);
//            element.print();
//            temp = temp.getPNext();
////        }
////    }

    /**
     * Metodo que retorna los elementos como un string separado por comas
     *
     * @return
     */
    public String printString() {
        Document element;
        String str = "";
        User user = this.getpFirst();
        Document list = user.getDocumentos();
        if (list != null) {
            Document temp= list.getpFirst();
            
            while (temp != null) {
                
                str += temp.getName() + ",";
                temp = temp.getpNext();
            }
        }
        return str;
    }
        /**
         * @return pFirst
         */
    public User getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst
     */
    public void setpFirst(User pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return pLast
     */
    public User getpLast() {
        return pLast;
    }

    /**
     * @param pLast
     */
    public void setpLast(User pLast) {
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
