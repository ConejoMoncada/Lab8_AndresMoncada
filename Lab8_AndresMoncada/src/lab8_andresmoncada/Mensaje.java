/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_andresmoncada;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Mensaje implements Serializable{
    private static final long SerialVersionUID = 123L;
    private String destino;
    private String fuente;
    private boolean cifrado;
    private ArrayList<Character> chars = new ArrayList();
    private ArrayList<Integer> frec = new ArrayList();
    private String msg;
    private String[][] tabla;
    private ArrayList<Character> cord = new ArrayList();
    private ArrayList<Integer> ford = new ArrayList();

    public Mensaje(String destino, String fuente, boolean cifrado,String msg) {
        this.destino = destino;
        this.fuente = fuente;
        this.cifrado = cifrado;
        this.msg = msg;
        if(cifrado){
            cod();
        }
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public boolean isCifrado() {
        return cifrado;
    }

    public void setCifrado(boolean cirfrado) {
        this.cifrado = cirfrado;
    }

    public ArrayList<Character> getChars() {
        return chars;
    }

    public void setChars(ArrayList<Character> chars) {
        this.chars = chars;
    }

    public ArrayList<Integer> getFrec() {
        return frec;
    }

    public void setFrec(ArrayList<Integer> frec) {
        this.frec = frec;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private void setlistas() {
        char c;
        int j = 0;
        for (int i = 0; i < msg.length(); i++) {
            c = msg.charAt(i);
            if(i == 0){
                chars.add(c);
                frec.add(1);
            }else if(chars.contains(c)){
                j = chars.indexOf(c);
                frec.set(j, frec.get(j)+1);
            }
        }
        tabla = new String[2][chars.size()];
        tabla[0] = (String[])chars.toArray();
        tabla[1] = (String[])frec.toArray();
    }

    public String[][] getTabla() {
        return tabla;
    }

    public void setTabla(String[][] tabla) {
        this.tabla = tabla;
    }

    @Override
    public String toString() {
        return "De: " + fuente + "A: " +destino+ "----->"+msg;
    }
    public void cod(){
        for (int i = 0; i < msg.length(); i++) {
            for (int j = 0; j < frec.size(); j++) {
                if(frec.get(j) == i+1){
                    ford.set(j, frec.get(j));
                    cord.set(j, chars.get(j));
                }
            }
        }
        
    }
}
