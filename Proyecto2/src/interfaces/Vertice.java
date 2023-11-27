/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author rgabr
 */
public class Vertice {
    String nombre;
    int numvertice;
    
    public Vertice(String x){
        nombre =x;
        numvertice=-1;
    }
    
    
    
    public boolean equals(Vertice n){
        return nombre.equals(n);
    }
    
    public String toString(){
        return nombre + " (" +numvertice+")";
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumvertice() {
        return numvertice;
    }

    public void setNumvertice(int numvertice) {
        this.numvertice = numvertice;
    }
    
    
    
    
    
    
}
