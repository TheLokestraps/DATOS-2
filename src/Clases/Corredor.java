/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Calendar;

/**
 *
 * @author ieperez
 */
public class Corredor {
    public String Nombre;
    public String Nacionalidad;
    public String Equipo;
    public int Numero;
    public int Edad;
    public String Foto;
    
    public Corredor(int Numero,String Nombre, String Nacion, String Equipo, int Edad, String Foto){
        this.Nombre = Nombre;
        this.Equipo = Equipo;
        this.Nacionalidad = Nacion;
        this.Numero = Numero;
        this.Edad = Edad;
        this.Foto = Foto;
    }
    
}
