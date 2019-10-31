/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Calendar;
import javax.swing.JOptionPane;
import java.time.*;

/**
 *
 * @author TheLokestraps
 */
public class Nodo {
    
    public Nodo link;
    public Corredor Player;
    public Duration Time;
    
   
    
    public static Nodo addPila(Nodo ptr, Corredor Player){
        Nodo q = new Nodo();
        q.Player = Player;
        q.link = ptr;
        ptr = q;
        return ptr;
    }
    public static Nodo addCola(Nodo ptr, Corredor Player){
        Nodo p =  ptr;
        Nodo q = new Nodo();
        q.Player = Player;
        if(ptr == null){
            ptr = q;
        }else{
            while(p.link != null){
                p = p.link;
            }
            p.link = q;
        }
        return ptr;
    }
    

    public static Nodo Ordenado(Nodo ptr, Corredor Player, Duration Time){
            if(ptr == null){
                Nodo q = new Nodo();
                q.Player = Player;
                q.Time = Time;
                ptr = q;
            }else{
                Nodo antp = null;
                Nodo p = ptr;
                while(p.Time.compareTo(Time)<= 0 && p.link != null && !p.Player.Nombre.equals(Player.Nombre)){
                    antp = p;
                    p = p.link;
                }if(p.Player.Nombre.equals(Player.Nombre)){
                    JOptionPane.showMessageDialog(null, "No se permite introducir mismo corredor", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    Nodo q = new Nodo();
                    q.Player = Player;
                    q.Time = Time;
                    if(p.Time.compareTo(Time)>0){
                        if(p == ptr){
                            q.link = ptr;
                            ptr = q;
                        }else{
                            if(antp != null){  
                                antp.link = q;
                                q.link = p;
                            }
                        }
                    }else{
                        p.link = q;
                        q.link = null;
                    }
                }
             
            }
            return ptr;
        }


    public static Nodo Eliminar(Nodo ptr, Corredor Player){
        Nodo ant = null;
        Nodo p = ptr;
        if(Player != null && ptr != null){
            while(p.link != null && p.Player != Player){
                ant = p;
                p = p.link;
            }
            if(p.Player == Player){
                if(p == ptr){
                    ptr = ptr.link;
                }else{
                    if(ant != null){
                        ant.link = p.link;
                    }
                }
            }
        }
        return ptr;
    }
    
    
}