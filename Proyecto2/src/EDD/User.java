/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author rgabr
 */
public class User {
    private String usuario;
    private String tipo ;
    private Document documentos;
    private User pNext;
    private int num;
    
    
    

    /**
     * Constructor
     * @param usuario
     * @param tipo
     * @param documentos 
     */
    public User(String usuario, String tipo, Document documentos) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.documentos = documentos;
        this.pNext = null;
    }

    /**
     * Constructor
     * @param usuario
     * @param tipo 
     */
    public User(String usuario, String tipo) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.documentos = null;
        this. pNext = null;
        this.num=0;
    }
    
    /**
     * Metodo para agregar documentos a la lista
     * @return 
     */
    public void addDocument(){
        
        String name;
        int size;
        String type;
        double priority;
        name = JOptionPane.showInputDialog("Nombre del documento: ");
        size = Integer.parseInt(JOptionPane.showInputDialog("Numero de paginas"));
        type = JOptionPane.showInputDialog("Tipo de domuento: ");
        int factorPriority;
        if ("prioridad_alta".equals(this.tipo)){
            factorPriority = 3;
        } else if ("prioridad_media".equals(this.tipo)){
            factorPriority = 2;
        } else {
            factorPriority = 1;
        }
        priority = size/factorPriority;
        Document newDoc = new Document(name, size, type, priority);
        this.getDocumentos().addAtTheEnd(newDoc);
    }
    
    public void print(){
        System.out.println(this.usuario + this.tipo);
    }
    
    /**
     * getUsuario
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * setUsuario
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * getTipo
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * setTipo
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * getDocumentos
     * @return 
     */
    public Document getDocumentos() {
        return documentos;
    }

    /**
     * setDocumentos
     * @param documentos 
     */
    public void setDocumentos(Document documentos) {
        this.documentos = documentos;
    }

    /**
     * getPNext
     * @return 
     */
    public User getPNext() {
        return pNext;
    }

    /**
     * setPNext
     * @param PNext 
     */
    public void setPNext(User PNext) {
        this.pNext = PNext;
    }
    
    
}
