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
public class ViewTree extends javax.swing.JPanel {
        int numVerts;
        static int Maxverts=20;
        Vertice []verts;
        int [][]matAD;
    /**
     * Creates new form Grafo
     * @param mx
     */
    public ViewTree(int mx) {
        matAD= new int [mx][mx];
        verts= new Vertice[mx];
        for (int i =0; i <mx;i++)
            for (int j=0;j<mx;j++)
                matAD[i][j]=0;
        numVerts=0;
        initComponents();
    }
    
    public void insertarVertice(String c){
        boolean existe=numVertice(c);
        if (!existe){
            Vertice v =new Vertice(c);
            v.setNumvertice(numVerts);
            verts[numVerts++]=v;
        }
    }
    
    public boolean numVertice (String c){
        Vertice v=new Vertice(c);
        boolean encontrado =false;
        int i=0;
        for (; (i< numVerts) && !encontrado;){
            encontrado=verts[i].equals(v);
            if (!encontrado) i++;
        }
        return (i < numVerts);
    }
    
    public void nuevoArco(int va, int vb){
//        int va,vb;
//        va=numVertice(a);
//        vb=numVertice(b);
        

        if(va<0||vb <0);
        matAD[va][vb]=1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}