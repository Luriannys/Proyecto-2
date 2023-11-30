/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import EDD.ArbolTDA;
import EDD.Controlador;
import EDD.Document;
import EDD.Lienzo;
import EDD.Lista;
import EDD.Nodo;
import EDD.User;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import resources.ManejoArchivo;

/**
 *
 * @author Luriannys Junco
 */
public class MainMenu extends javax.swing.JFrame {

    DefaultTableModel table = new DefaultTableModel();
    public Lista data = new Lista();
    public Lista carga = new Lista();

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();

        /**
         * Reloj
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runnable runnable;
        runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        tagWatch.setText(formatter.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        cerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Usuarios = new javax.swing.JPanel();
        cargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        deleteUser = new javax.swing.JButton();
        addUser = new javax.swing.JButton();
        help = new javax.swing.JButton();
        ColaImpresion = new javax.swing.JPanel();
        verArbol = new javax.swing.JButton();
        tagWatch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(61, 69, 76));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/_6b327199-1d6b-4bdc-add3-314a4fe511b4.jpeg"))); // NOI18N
        background.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 240, 20));

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        background.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, -1, -1));

        Usuarios.setBackground(new java.awt.Color(94, 105, 116));
        Usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargar.setText("Cargar");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });
        Usuarios.add(cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, -1, -1));

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuarios", "Prioridad", "Documentos"
            }
        ));
        jScrollPane1.setViewportView(tableUsers);

        Usuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 160));

        deleteUser.setText("Eliminar Usuario");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });
        Usuarios.add(deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));

        addUser.setText("Agregar Usuario");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        Usuarios.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        help.setText("Ayuda");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        Usuarios.add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jTabbedPane1.addTab("Usuarios", Usuarios);

        ColaImpresion.setBackground(new java.awt.Color(94, 105, 116));
        ColaImpresion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verArbol.setText("Ver Arbol");
        verArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verArbolActionPerformed(evt);
            }
        });
        ColaImpresion.add(verArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jTabbedPane1.addTab("Cola de impresion", ColaImpresion);

        background.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 460));
        jTabbedPane1.getAccessibleContext().setAccessibleName("Usuarios");

        tagWatch.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        tagWatch.setForeground(new java.awt.Color(255, 255, 255));
        tagWatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tagWatch.setText("HOUR");
        tagWatch.setToolTipText("");
        tagWatch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tagWatch.setMaximumSize(new java.awt.Dimension(50, 30));
        tagWatch.setMinimumSize(new java.awt.Dimension(50, 30));
        tagWatch.setName(""); // NOI18N
        tagWatch.setPreferredSize(new java.awt.Dimension(50, 30));
        background.add(tagWatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 160, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton "Cargar"
     *
     * @param evt
     */
    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        try {
            JFileChooser file = new JFileChooser(); // JFileChooser
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv", "csv"); // Crear filtro "csv"
            file.setFileFilter(filter);
            file.showOpenDialog(this);
            File openFile = file.getSelectedFile();
            carga = ManejoArchivo.readCsv(openFile); // Montar el archivo
            Nodo nodo;
            if (!carga.isEmpty()) {
                nodo = carga.getpFirst();
                for (int i = 0; i < carga.getSize(); i++) {
                    data.addAtTheEnd(nodo);
                    nodo = nodo.getpNext();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " " + "\nNo se ha encontrado el archivo", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        updateTable();
    }

    /**
     * Actualizar tabla de usuarios
     */
    public void updateTable() {
        table.setRowCount(0); //Vacia la tabla
        String ids[] = {"Usuarios", "Prioridad", "Documentos"}; //Identificadores de columnas
        table.setColumnIdentifiers(ids);
        tableUsers.setModel(table);
        if (!data.isEmpty()) {
            Nodo nodo;
            nodo = data.getpFirst();
            for (int i = 0; i < data.getSize(); i++) {
                String info[] = new String[3];
                User element = (User) nodo.getElement();
                info[0] = element.getUsuario();
                info[1] = element.getTipo();
                info[2] = data.printString();
                table.addRow(info);
                nodo = nodo.getpNext();
            }
        } else {
            String message[] = {"No hay usuarios"};
            table.addRow(message);
        }
    }//GEN-LAST:event_cargarActionPerformed
    /**
     * Boton "Cerrar"
     *
     * @param evt
     */
    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        System.exit(0); // Cierra el programa
    }//GEN-LAST:event_cerrarActionPerformed

    /**
     * Boton "Ver Arbol"
     *
     * @param evt
     */
    private void verArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verArbolActionPerformed
        Lienzo lien=new Lienzo();
        JFrame vent=new JFrame();
        ArbolTDA arbolito= new ArbolTDA();
        Controlador contrl=new Controlador(lien,arbolito);
        
        Document doc = new Document("R",10,"Alta");
        Document doc1 = new Document("a",5,"Alta");
        Document doc2 = new Document("b",13,"Alta");
        Document doc3 = new Document("c",1,"Alta");
        Document doc4 = new Document("d",6,"Alta");
        Document doc5 = new Document("e",17,"Alta");
        arbolito.setNodoRaiz(doc);
        arbolito.getNodoRaiz().insertar(doc1);
        arbolito.getNodoRaiz().insertar(doc2);
        arbolito.getNodoRaiz().insertar(doc3);
        arbolito.getNodoRaiz().insertar(doc4);
        arbolito.getNodoRaiz().insertar(doc5);
        lien.setObj(arbolito);
        vent.getContentPane().add(lien);
        vent.setDefaultCloseOperation(3);
        vent.setSize(600, 600);
        vent.setVisible(true);
    }//GEN-LAST:event_verArbolActionPerformed

    /**
     * Boton "Agregar Usuario"
     *
     * @param evt
     */
    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        String nameUser = JOptionPane.showInputDialog("Nombre de usuario: ");
        String[] priorities = {"prioridad_alta", "prioridad_media", "prioridad_baja"}; // Opciones de JComboBox
        JComboBox election = new JComboBox(priorities);
        String priorityUser = (String) JOptionPane.showInputDialog(null, "Prioridad:", "Elegir", JOptionPane.QUESTION_MESSAGE, null, priorities, priorities[0]);
        User user = new User(nameUser, priorityUser);
        Nodo nodo = new Nodo(user);
        data.addAtTheStart(nodo);
        updateTable();
    }//GEN-LAST:event_addUserActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
        int selectedRow = tableUsers.getSelectedRow();
        String value = (String) tableUsers.getValueAt(selectedRow, 0);
        table.removeRow(selectedRow);
        Nodo nodo = data.getpFirst();
        for (int i = 0; i < data.getSize(); i++) {
            User user = (User) nodo.getElement();
            if (user.getUsuario().equals(value)) {
                data.remove(value);
                break;
            }
            nodo = nodo.getpNext();
        }
    }//GEN-LAST:event_deleteUserActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
         JOptionPane.showMessageDialog(null, "¡Bienvenido!\nPara cargar usuarios desde un archivo .csv presione 'Cargar'\nPara agregar usuarios individualmente presione 'Agregar Usuario'\nPara eliminar un usuario de la lista seleccione la fila y presione 'Eliminar Usuario'");
    }//GEN-LAST:event_helpActionPerformed

    /**
     * getCarga
     *
     * @return carga
     */
    public Lista getCarga() {
        return carga;
    }

    /**
     * getData
     *
     * @return data
     */
    public Lista getData() {
        return data;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ColaImpresion;
    private javax.swing.JPanel Usuarios;
    private javax.swing.JButton addUser;
    private javax.swing.JPanel background;
    private javax.swing.JButton cargar;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton deleteUser;
    private javax.swing.JButton help;
    private javax.swing.JLabel image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableUsers;
    private javax.swing.JLabel tagWatch;
    private javax.swing.JButton verArbol;
    // End of variables declaration//GEN-END:variables
}
