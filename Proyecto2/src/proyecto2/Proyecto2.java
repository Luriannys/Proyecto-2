/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import EDD.ArbolTDA;
import EDD.Document;
import EDD.Hashtable;
import EDD.User;
//import EDD.ArbolTDA;
//import EDD.Document;

import interfaces.MainMenu;

/**
 *
 * @author Luriannys Junco
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MainMenu m = new MainMenu();
        m.setVisible(true);
        
       
//        ArbolTDA arbolito= new ArbolTDA();
//        arbolito.Vacio();
//        Document doc = new Document("R",10,"Alta");
//        Document doc1 = new Document("R",5,"Alta");
//        Document doc2 = new Document("R",13,"Alta");
//        Document doc3 = new Document("R",1,"Alta");
//        Document doc4 = new Document("R",6,"Alta");
//        Document doc5 = new Document("R",17,"Alta");
//        arbolito.setNodoRaiz(doc);
//        arbolito.getNodoRaiz().insertar(doc1);
//        arbolito.getNodoRaiz().insertar(doc2);
//        arbolito.getNodoRaiz().insertar(doc3);
//        arbolito.getNodoRaiz().insertar(doc4);
//        arbolito.getNodoRaiz().insertar(doc5);
////        arbolito.insertar(doc4);
////        arbolito.insertar(doc5);
////       
//        
//
//        arbolito.inorden(arbolito.getNodoRaiz());

        
        User a=new User("a","a");
        User b=new User("b","b");
        
        Hashtable tabla=new Hashtable();
        tabla.insertar(b);
        tabla.buscar(b.getUsuario());
        tabla.insertar(a);
   
         
     
    }
    
}
