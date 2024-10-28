/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arreglos;

import Clases.Libro;
import java.util.Arrays;


public class LibrosArray {
    private int indice;
    private int tamaño;
    private Libro[] Lista;
    
    
    
    public LibrosArray(int tamaño){
        this.indice = 0;
        this.tamaño = tamaño;
        Lista = new Libro[this.tamaño];
    }
    
    public int obtenerIndice(){
        return this.indice;
    }
    
    public void establecerIndice(int indice){
        this.indice = indice;
    }
    
    public int obtenerIndiceVacio(){
        int ind = this.obtenerElementosValidos() + 1;
        return ind;
    }
    
    public Libro[] obtenerLista(){
        return Lista;
    }
    
    public Libro obtenerLibro(int codigo){
        for (int i=0; i<Lista.length; i++){
            if (Lista[i].getCodigo() == codigo){
                return Lista[i];
            }
        }
        return null;
    }
    
    public void llenarLista(Libro[] Lista){
        this.Lista = Lista;
    }
    
    public void agregar(Libro libro){
        Lista[indice] = libro;
        indice++;
    }
    
    public void editar(Libro LibroEdicion){
        int codigo = LibroEdicion.getCodigo();
        int indice = codigo - 1;
        String nuevo_titulo = LibroEdicion.getTitulo();
        String nuevo_autor = LibroEdicion.getAutor();
        String nuevo_isbn = LibroEdicion.getISBN();
        Lista[indice].setTitulo(nuevo_titulo);
        Lista[indice].setAutor(nuevo_autor);
        Lista[indice].setISBN(nuevo_isbn);
    }
    
    public void eliminar(int codigo){
        Libro[] new_array = new Libro[this.tamaño];
        int new_index = 0;
        for(int i=0; i<Lista.length; i++){
            if (Lista[i] != null && Lista[i].getCodigo() != codigo){
                Lista[i].setCodigo(new_index + 1);
                new_array[new_index] = Lista[i];
                new_index++;
            }
        }
        Lista = new_array;
        establecerIndice(new_index);
        
    }
    
    public void limpiarLista(){
        Arrays.fill(Lista, null);
    }
    
    // obtener elementos de tipo 'Libro' que no sean vacios o nulos
    public int obtenerElementosValidos(){
        int validos = 0;
        for (Libro libro: Lista){
            if (libro != null){
                validos++;
            }
        }
        
        return validos;
    }
    
    public void crearLibro(int index, Libro libro){
        System.out.println("IN: "+index);
        Lista[index] = libro;
    }
}
