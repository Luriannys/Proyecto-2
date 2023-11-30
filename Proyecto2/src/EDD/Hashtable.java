/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author rgabr
 */
public class Hashtable {
    public static final int tamanio=101; // se decide de un principio
    private int numElem;
    private User [] tabla;
    private double factorCarga;

    /**
     * Constructor
     */
    public Hashtable() {
        this.numElem = 0;
        this.tabla = new User[tamanio];
        for (int i =0;i<tamanio;i++){
            tabla[i]=null;
        }
        this.factorCarga = 0.0;
    }
        
    /**
     * Index
     * @param clave
     * @return 
     */
    public int index(String clave){
        int i=0,p;
        int d;
        d =transformarCadena(clave);
        p=hash(d);
        return p;
    }
    public int transformarCadena(String c){
        int d;
        d=0;
        for (int i =0 ;i< c.length();i++){
            d=d*27+(int)c.charAt(i);
        }
        if(d<0){
            d=-d;
        }
        return d;
    }
    
    /**
     * Hash
     * @param k
     * @return 
     */
    private int hash(int k){
        int key=k%tamanio;
        return key;
    }
    
    /**
     * Insertar
     * @param r 
     */
    public void insertar(User r){
        int posicion;
        posicion=index(r.getUsuario());
        this.tabla[posicion]=r;
        numElem++;
        setFactorCarga(getNumElem()/getTamanio());
        if(getFactorCarga()>0.5){
            System.out.println("\n Factor de carga supera el 50%");
        }
    }
        
    /**
     * Buscar
     * @param clave
     * @return 
     */
    public User buscar(String clave){
        User pr;
        int posicion;
        posicion= index(clave);
        pr=tabla [posicion];
        return pr;
    }
    
    /**
     * Eliminar
     * @param clave 
     */
    public void eliminar(String clave){
        int posicion;
        posicion= index(clave);
        this.tabla[posicion]=null;
    }
       
    /**
     * getTamanio
     * @return 
     */
    public static int getTamanio() {
        return tamanio;
    }

    /**
     * getNumElem
     * @return 
     */
    public int getNumElem() {
        return numElem;
    }

    /**
     * setNumElem
     * @param numElem 
     */
    public void setNumElem(int numElem) {
        this.numElem = numElem;
    }

    /**
     * getTabla
     * @return 
     */
    public User[] getTabla() {
        return tabla;
    }

    /**
     * setTabla
     * @param tabla 
     */
    public void setTabla(User[] tabla) {
        this.tabla = tabla;
    }

    /**
     * getFactorCarga
     * @return 
     */
    public double getFactorCarga() {
        return factorCarga;
    }

    /**
     * setFactorCarga
     * @param factorCarga 
     */
    public void setFactorCarga(double factorCarga) {
        this.factorCarga = factorCarga;
    }
    
    
}
