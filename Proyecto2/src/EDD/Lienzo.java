/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author rgabr
 */
public class Lienzo extends JPanel {
    private ArbolTDA obj;
    public static final int diametro=30;
    public static final int radio=diametro/2;
    public static final int ancho=50;

    /**
     * setObj
     * @param obj 
     */
    public void setObj(ArbolTDA obj) {
        this.obj = obj;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g,getWidth()/2,20,obj.getNodoRaiz());
    }
    
    /**
     * Pintar
     * @param g
     * @param x
     * @param y
     * @param d 
     */
    private void pintar(Graphics g , int x,int y, Document d){
        if (d==null){
            {}
        }else{
            int extra=d.nodosCompletos(d)*(ancho/2);
            g.drawOval(x, y, diametro,diametro);
            g.drawString(String.valueOf(d.getSize()),x+12,y+18);
//            if (d.getIzquierda()!=null){
//                g.drawLine(x+radio, y+radio, x-ancho-extra+radio, y+ancho+radio);
//            }
//            if (d.getDerecha()!=null){
//                g.drawLine(x+radio, y+radio, x-ancho+extra+radio, y+ancho+radio);
//            }
            pintar(g,x-ancho-extra,y+ancho,d.getIzquierda());
            pintar(g,x+ancho+extra,y+ancho,d.getDerecha());

        }
    }

    

}
