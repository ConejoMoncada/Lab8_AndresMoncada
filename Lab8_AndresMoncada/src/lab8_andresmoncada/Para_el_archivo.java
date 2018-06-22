/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_andresmoncada;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Para_el_archivo {
    private ArrayList<Mensaje> mensajes= new ArrayList();
    private File archivo = null;
    
    public Para_el_archivo(String path) {
        archivo = new File(path);
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensaje) {
        this.mensajes = mensajes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "mensajes: " + mensajes;
    }

    public void addM (Mensaje m){
        mensajes.add(m);
    }

    public void cargarArchivo(){
        try {
            mensajes = new ArrayList();
            Mensaje temp;
            if(archivo.exists()){
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while((temp = (Mensaje) objeto.readObject()) != null){
                        mensajes.add(temp);
                    }
                } catch (EOFException ex) {
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo(){
        FileOutputStream fo = null;
        ObjectOutputStream os = null;
        try {
            fo = new FileOutputStream(archivo);
            os = new ObjectOutputStream(fo);
            for (Mensaje m : mensajes) {
                os.writeObject(m);
            }
            os.flush();
        } catch (Exception e) {
        }finally{
            try {
                os.close();
                fo.close();
            } catch (Exception e) {
            }
        }
    }
}
