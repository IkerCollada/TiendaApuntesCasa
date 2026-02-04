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
 private String idArticulo;
    private int unidades;

    public LineaPedido(String IidArticulo, int unidades) {
        this.idArticulo = idArticulo;
        this.unidades = unidades;
    }
    //faltaban getter y setter
    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }   
}