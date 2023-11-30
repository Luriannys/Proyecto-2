package resources;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.PrintWriter;
import javax.swing.JOptionPane;
import EDD.Lista;
import EDD.User;
import EDD.Nodo;

/**
 *
 * @author Luriannys Junco
 */
public class ManejoArchivo {

//      No creo que sea necesario este metodo
//    /**
//     * Escribir archivo csv
//     *
//     * @param clientes
//     */
//    public void write_csv(ListaDoc clientes) {
//        String clientes_actuales = "";
//        if (!clientes.isEmpty()) {
//            NodoDoc temp = clientes.getpFirst(); //cambiar el tipo de nodo en la lista
//            for (int i = 0; i < clientes.getSize(); i++) {
//                clientes_actuales = temp.getName() + "," + temp.getType() + "/n";
//                temp = temp.getpNext();
//            }
//        }
//        try {
//            PrintWriter pw = new PrintWriter("test\\cliente.csv");
//            //Borrar toda la informacion y colocar nueva
//            pw.print(clientes_actuales);
//            // Agregar informacion manteniendo la anterior
//            pw.append("Luri, 30345893");
//            pw.append("\n");
//            //Cerrar archivo
//            pw.close();
//            JOptionPane.showMessageDialog(null, "Guardado exitoso");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    /**
     * Leer archivo csv
     *
     * @param file
     * @return
     */
    public static Lista readCsv(File file) {
        Lista clientes = new Lista();
        String line;
        String file_csv = "";
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        file_csv += line + "\n";
                    }
                }
                if (!"".equals(file_csv)) {
                    String[] user_split = file_csv.split("\n");
                    for (int i = 0; i < user_split.length; i++) {
                        String[] user_att = user_split[i].split(";");
                        User user = new User(user_att[0], user_att[1]);
                        Nodo newNodo = new Nodo(user);
                        clientes.addAtTheEnd(newNodo);
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return clientes;
    }

}
