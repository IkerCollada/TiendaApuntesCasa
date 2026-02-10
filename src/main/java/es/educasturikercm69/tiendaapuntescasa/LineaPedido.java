/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educasturikercm69.tiendaapuntescasa;

/**
 *
 * @author Iker
 */
public class LineaPedido {
    private Articulo articulo;
    private int unidades;

    public LineaPedido(Articulo articulo, int unidades) {
        this.articulo = articulo;
        this.unidades = unidades;
    }
    
    //faltaban getter y setter
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}