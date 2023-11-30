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
public class Controlador {
    private Lienzo lienzo;
    private ArbolTDA arbol;

    public Controlador(Lienzo lienzo, ArbolTDA arbol) {
        this.lienzo = lienzo;
        this.arbol = arbol;
    }
    
    public void iniciar(){
        lienzo.setObj(arbol);
    }
}
