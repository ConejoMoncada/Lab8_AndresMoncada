/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_andresmoncada;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Empleado {
    private String nombre;
    private int id;
    private String pass;
    private Empleado jefe;
    private int salario;
    private String puesto;
    private ArrayList<Empleado> empleados = new ArrayList();

    public Empleado() {
    }

    public Empleado(String nombre, int id, String pass, Empleado jefe, int salario, String puesto) {
        this.nombre = nombre;
        this.id = id;
        this.pass = pass;
        this.jefe = jefe;
        this.salario = salario;
        this.puesto = puesto;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Empleado getJefe() {
        return jefe;
    }

    public void setJefe(Empleado jefe) {
        this.jefe = jefe;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void addEmpleados(Empleado e){
        if(!puesto.equals("Gerente general")){
            empleados.add(e);
            puesto = "Gerente de area";
        }
    }
    @Override
    public String toString() {
        return puesto + " " + nombre;
    }
    
}
