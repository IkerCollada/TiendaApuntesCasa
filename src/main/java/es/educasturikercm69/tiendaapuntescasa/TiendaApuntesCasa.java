/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educasturikercm69.tiendaapuntescasa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Iker
 */
public class TiendaApuntesCasa {
    
    private Scanner sc = new Scanner (System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
    
    public TiendaApuntesCasa() { //Esto es el constructor
        pedidos = new ArrayList();
        articulos= new HashMap();
        clientes = new HashMap();
    }
    /**
     * getter para el ArrayList pedidos, ya que sin un getter no podemos 
     * testear métodos de la clase Tienda2026.
     */
    public ArrayList <Pedido> getPedidos() {
        return pedidos;
    }
    
    public static void main(String[] args) {
        TiendaApuntesCasa t2026 = new TiendaApuntesCasa();
        t2026.cargaDatos();
        t2026.menu();
        //t2026.uno();
        //t2026.dos();
        //t2026.tres();
        //t2026.cuatro();
        //t2026.cinco();
    }
    
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    public void menu(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ TIENDA");
            System.out.println("\t\t\t1- ARTICULOS");
            System.out.println("\t\t\t2- CLIENTES");
            System.out.println("\t\t\t3- PEDIDOS");
            opcion = sc.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        menuArticulos();
                        break;
                    case 2:
                        menuClientes();
                        break;
                    case 3:
                        menuPedidos();
                        break;
                    default:
                        System.out.println("\n\nIntentalo de nuevo");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ha saltado la excepción: " + e.toString());
                System.out.println("Debe introducir por teclado un numero entero.");
                sc.nextLine(); //para limpiar
                opcion = 0; //para limpiar
            }
        } while (opcion != 9);
    }
    
    public void menuArticulos(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ ARTICULOS");
            System.out.println("\t\t\t1- ALTA");
            System.out.println("\t\t\t2- BAJA");
            System.out.println("\t\t\t3- REPOSICION");
            System.out.println("\t\t\t4- LISTADOS");
            System.out.println("\t\t\t9- SALIR");
            opcion = sc.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        altaArticulos();
                        break;
                    case 2:
                        bajaArticulos();
                        break;
                    case 3:
                        reposicionArticulos();
                        break;
                    case 4:
                        listarArticulos();
                        break;
                    default:
                        System.out.println("\n\nIntentalo de nuevo");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ha saltado la excepción: " + e.toString());
                System.out.println("Debe introducir por teclado un numero entero.");
                sc.nextLine(); //para limpiar
                opcion = 0; //para limpiar
            }
        } while (opcion != 9);
    }
    
    public void menuClientes(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ CLIENTES");
            System.out.println("\t\t\t1- ALTA");
            System.out.println("\t\t\t2- BAJA");
            System.out.println("\t\t\t3- MODIFICACION DE DATOS");
            System.out.println("\t\t\t4- LISTADOS");
            System.out.println("\t\t\t9- SALIR");
            opcion = sc.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        altaClientes();
                        break;
                    case 2:
                        bajaClientes();
                        break;
                    case 3:
                        modificarClientes();
                        break;
                    case 4:
                        listarClientes();
                        break;
                    default:
                        System.out.println("\n\nIntentalo de nuevo");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ha saltado la excepción: " + e.toString());
                System.out.println("Debe introducir por teclado un numero entero.");
                sc.nextLine(); //para limpiar
                opcion = 0; //para limpiar
            }
        } while (opcion != 9);
    }
    
    public void menuPedidos(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ PEDIDOS");
            System.out.println("\t\t\t1- NUEVO PEDIDO");
            System.out.println("\t\t\t2- LISTADOS");
            System.out.println("\t\t\t3- GENERAR ID PEDIDO");
            System.out.println("\t\t\t9- SALIR");
            opcion = sc.nextInt();
            
            try {
                switch (opcion) {
                case 1:
                    //nuevoPedido();
                    break;
                case 2:
                    listadoPedidos();
                    break;
                case 3:
                    //generaIdPedido();
                    break;
                default:
                    System.out.println("\n\nIntentalo de nuevo");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ha saltado la excepción: " + e.toString());
                System.out.println("Debe introducir por teclado un numero entero.");
                sc.nextLine(); //para limpiar
                opcion = 0; //para limpiar
            }
            
            
        } while (opcion != 9);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARTICULOS">
    /**
     * El método es un listado de los artículos. Tenemos un listado hecho con un for each. 
     * @param a es el valor que muestra la posición del HashMap
     */
    private void listarArticulos(){
        //Al ser un HashMap, necesitamos poner un ".values".
        System.out.println("");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
        }
        //en programación funcional sería:
        System.out.println("\n\nEn programación funcional:");
        articulos.values().stream().forEach(a->System.out.println(a));
        
        ArrayList <Articulo> articulosAux = new ArrayList(articulos.values());
        ArrayList <Articulo> articulosAux2 = new ArrayList(articulosAux);
    }
    
    private void altaArticulos(){
     String idArticulo,descripcion,existencias,pvp;
        sc.nextLine(); //para limpiar
        
        System.out.println("ALTA DE NUEVO ARTICULO");
        idArticulo = sc.next();
        
        do{
            System.out.println("idArticulo (IDENTIFICADO): ");
            idArticulo = sc.next();
        }while(!idArticulo.matches("[1-6][-][0-9][0-9]") || articulos.containsKey(idArticulo));
        System.out.println("DESCRIPCION");
        sc.nextLine(); //para limpiar
        descripcion = sc.nextLine();
        
        do{
            System.out.println("EXISTENCIAS:");
            existencias = sc.next();
        }while(!MetodosAux.esInt(existencias));
        
        do{
            System.out.println("PVP: ");
            sc.nextLine(); //para limpiar
            pvp = sc.next();
        }while(!MetodosAux.esDouble(pvp));
       
        Articulo a = new Articulo(idArticulo, descripcion, Integer.parseInt(existencias), Double.parseDouble(pvp));
        articulos.put(idArticulo, a);
        System.out.println("- Articulo añadido -");
    }
    
    private void bajaArticulos(){
        
    }
    
    private void reposicionArticulos(){
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CLIENTES">

    private void altaClientes(){
        
    }
    private void bajaClientes(){
        
    }
    private void modificarClientes(){
        
    }
    private void listarClientes(){
        System.out.println("");
        for (Cliente c: clientes.values()){
            System.out.println(c);  
        }
        System.out.println("\n\nEn programación funcional:");
        clientes.values().stream().forEach(c->System.out.println(c));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pedido">
    private void listadoPedidos(){
        System.out.println("");
        for (Pedido p : pedidos){
            System.out.println(p +"- Total:" + totalPedido(p));
        }
        System.out.println("\nPedidos de menor a mayor");
        pedidos.stream().sorted(Comparator.comparing(p->totalPedido(p))).forEach(p->System.out.println(p + "- Total: "+totalPedido(p)));
        
                pedidos.stream().filter(p->totalPedido(p)>1000).sorted(Comparator.comparing(p->totalPedido(p))).forEach(p->System.out.println(p + "- Total: "+totalPedido(p)));
    }
    
    public double totalPedido (Pedido p){
        double totalPedido=0;
        for (LineaPedido l : p.getCestaCompra()){
             totalPedido += l.getUnidades() * l.getArticulo().getPvp();
        }
        return totalPedido;
    }
    
    private void nuevoPedido() {
        String idCliente;
        do{
            System.out.println("DNI (id) CLIENTE:");
            idCliente = sc.nextLine().toUpperCase();
            if (!clientes.containsKey(idCliente)){
                System.out.println("No es cliente de la tienda."
                        + " Desea darse de alta o compra como invitado");
            }
        }while (!MetodosAux.validarDNI(idCliente));
        
        ArrayList <LineaPedido> cestaCompra = new ArrayList();
        String idArticulo;
        int unidades = 0;
        System.out.print("\nTeclea el ID del artículo deseado (FIN para terminar la compra)");
        idArticulo = sc.next();
        while (!idArticulo.equalsIgnoreCase("FIN")){
            System.out.print("\nTeclea las unidades deseadas: ");
            unidades = sc.nextInt();
            try {
                stock(idArticulo, unidades);
                cestaCompra.add(new LineaPedido(articulos.get(idArticulo),unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());
                System.out.println("Las quieres (SI/NO)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI")){
                    cestaCompra.add(new LineaPedido(articulos.get(idArticulo),articulos.get(idArticulo).getExistencias()));
                }
            }
            System.out.print("\nTeclee el ID del artículo deseado (FIN para terminar la compra)");
            idArticulo = sc.next();
        }
        if (!cestaCompra.isEmpty()){
            System.out.println("Este es tu pedido");
            double totalPedido = 0;
            double totalLinea = 0;
            for (LineaPedido l : cestaCompra){
                totalLinea = l.getUnidades() * l.getArticulo().getPvp();
                 totalPedido += totalLinea;    
                System.out.println(l.getArticulo() + " - " + l.getArticulo().getDescripcion() + " - " + l.getUnidades() + " - " + l.getArticulo().getPvp() + " - "  + totalLinea)  ;
            }
            System.out.println("\t\t\t\tTotal: " + totalPedido);
            System.out.println("Procedemos con la compra (SI/NO) "); 
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("SI")){
                pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente),
                LocalDate.now(), cestaCompra));
                for (LineaPedido l : cestaCompra){
                    cestaCompra.add(new LineaPedido(articulos.get(idArticulo),articulos.get(idArticulo).getExistencias()));
                }
            }
        }         
    }
    
    private void stock (String idArticulo, int unidades) throws StockCero, StockInsuficiente {
        if (articulos.get(idArticulo).getExistencias() == 0){
            throw new StockCero("0 unidades disponibles de: " 
                    + articulos.get(idArticulo).getDescripcion());
        }
        if (articulos.get(idArticulo).getExistencias() < unidades){
            throw new StockInsuficiente("Sólo hay " + articulos.get(idArticulo).getExistencias() 
                    + " unidades disponibles de: " + articulos.get(idArticulo).getDescripcion());
        }
    }
    
    private String generaIdPedido(String idCliente){ 
        String nuevoId; //vble String para ir construyendo un nuevo idPedido
         //Calculamos en la vble contador cuantos pedidos tiene el cliente aportado
        int contador = 0;  
        for (Pedido p : pedidos){
            if (p.getClientePedido().getIDcliente().equalsIgnoreCase(idCliente)){ //pone IDCliente en vez de IdCliente...
                contador++;
            }
        }
        contador++; //sumamos a contador 1 para el nuevo pedido
        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="EJERCICIOS EXAMEN (Corregido)">
    public void uno(){
        int opcion;
        do {            
            System.out.println("\n\n\t\t\tESCOGA UNA SECCION");
            System.out.println("\t\t\t1- PERIFERICOS");
            System.out.println("\t\t\t2- ALMECENAMIENTO");
            System.out.println("\t\t\t3- IMPRESORES");
            System.out.println("\t\t\t4- MONITORES");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    listadoPerifericos();
                    break;
                case 2:
                    listadoAlmacenamiento();
                    break;
                case 3:
                    listadoImpresores();
                    break;
                case 4:
                    listadoMonitores();
                    break;
            }
        } while (opcion != 9);
    }
    
    private void listadoPerifericos(){
        System.out.println("\n\nARTICULOS DE LA SECCION PERIFERICOS:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("1")) {
                System.out.println(a);
            }
        }
    }
    
    private void listadoAlmacenamiento(){
        System.out.println("\n\nARTICULOS DE LA SECCION ALMACENAMIENTO:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("2")) {
                System.out.println(a);
            }
        }
    }
    
    private void listadoImpresores(){
        System.out.println("\n\nARTICULOS DE LA SECCION IMPRESORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("3")) {
                System.out.println(a);
            }
        }
    }
    
    private void listadoMonitores(){
        System.out.println("\n\nARTICULOS DE LA SECCION MONITORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("4")) {
                System.out.println(a);
            }
        }
    }
    
    public void dos(){
        System.out.println("\n\nPERIFERICOS:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("1")) {
                System.out.println(a);
            }
        }
        System.out.println("\n\nALMACENAMIENTO:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("2")) {
                System.out.println(a);
            }
        }
        System.out.println("\n\nIMPRESORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("3")) {
                System.out.println(a);
            }
        }
        System.out.println("\n\nMONITORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("4")) {
                System.out.println(a);
            }
        }
    }
    
    public void tres(){ //Ejercicio que no ha sido resuelto en el examen
        /*String dni;
        do {            
           System.out.println("DNI CLIENTE:");
           dni = sc.next().toUpperCase(); 
        } while (!MetodosAux.validarDNI(dni));
        
        System.out.println("PEDIDOS DEL CLIENTE: " + clientes.get(dni).getNombre()); /*Habíamos hecho un buscaCliente, 
        pero al ser un HashMap, no se necesitaba hacer una búsqueda./
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIDcliente().equals(dni)) {
                System.out.println(p + "TOTAL: " + totalPedido(idArticulo));
            }
        }*/
    }    
    /*private double unidades (String idArticulo){
        for (Pedido p : pedidos) {
            int totalPedido = 0;
            for (LineaPedido lp : p.getCestaCompra()) {
                
                if (lp.getArticulo().equals(p.getIDpedido())) {
                    totalPedido += lp.getUnidades();
                }
            }
        }
        return totalPedido;
    }*/
    
    
    public void cuatro(){
        System.out.println("\n\n\t\tLISTADO ARTICULOS - \t\tUNIDADES VENDIDAS");
        for (Articulo a : articulos.values()) {
            int unidades = 0; 
            int totalVendido = vendido(unidades);
            System.out.println(a.getDescripcion() + " VENDIDAS: " + totalVendido);
        }
    }
    
    private int vendido(int unidades){ //revisar
        /*int totalUnidades = 0;
        for (Pedido p : pedidos) {
            for (LineaPedido lp : p.getCestaCompra()) {
                if (lp.get) {
                    
                }
            }
        }*/
        return unidades;
    }
    
    public void cinco(){
        ArrayList <Cliente> sinPedidos = new ArrayList();
        for (Cliente c : clientes.values()) {
            boolean hayPedido = false;
            for (Pedido p : pedidos) {
                if (c.getIDcliente().equals(p.getClientePedido().getIDcliente())) {
                    hayPedido = true;
                    break;
                }
            }
            if (hayPedido == false) {
                sinPedidos.add(new Cliente(c.getIDcliente(),c.getNombre(),c.getTelefono(),c.getEmail()));
            }
        }
        
        System.out.println("LISTADO CLIENTES SIN PEDIDOS:");
        sinPedidos.stream().forEach(sp->System.out.println(sp));
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="API DE STREAMS (SEGUNDA PARTE DEL R.A)">
    /**
     * Se darán unos determinados listados con streams.
     * Se seguirá trabajando con el filter, sorted y forEach, que ya los hemos dado. 
     * Pero esta vez se complicará y se irá viendo nuevas formas de la programación moderna
     * como el count, collect...etc.
     * 
     * El objetivo de este resultado de aprendizaje es dominar la programación moderna.
     */
    public void listadoConStreams(){
      System.out.println("ARTICULOS DE MENOS DE 100 EUROS POR PRECIO DE - A");
        articulos.values().stream()
                .filter(a->a.getPvp()<100)
                .sorted(Comparator.comparing(a -> a.getPvp()))
                .forEach(a->System.out.println(a));
        
        System.out.println("\n\nPEDIDOS ORDENADOS POR IMPORTE TOTAL");
       /*pedidos.stream()
                .sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p->System.out.println(p + "- Total: " totalPedido(p)));*/
                
       System.out.println("\n\nPEDIDOS DE MAS DE 1000 EUROS (filter) POR LA FECHA DEL PEDIDO");
                /*pedidos.stream().filter(p->totalPedido(p)>1000)
                        .sorted(Comparator.comparing(Pedido::getFechaPedido))
                        .forEach(p->System.out.println(p + "- Total: " + p.getFechaPedido());*/
                
        System.out.println("\n\n\nCONTABILIZAR LOS PEDIDOS DE UN DETERMINADO CLIENTE - PODRIA PEDIR NOMBRE O DNI POR TECLADO");
        long numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getIDcliente().equalsIgnoreCase("80580845T"))
                .count(); //LA VARIABLE COUNT ES PARA CONTABILIZAR LOS PEDIDOS DE UN CLIENTE.
                System.out.println(numPedidos); //para mostrar por consola el nº de pedidos del cliente
        
        //EL ESTILO TRADICIONAL SERÍA:
        System.out.println("\nCONTABILIZACION AL ESTILO TRADICIONAL:");
            long numPedidos2 = 0;
            for (Pedido p : pedidos) {
                if (p.getClientePedido().getIDcliente().equalsIgnoreCase("80580845T")) {
                    numPedidos2++;
                }
        }
                System.out.println(numPedidos2);
            
        System.out.println("CONTABILIZAR CUANTOS PEDIDOS HAY POR CLIENTE - PARA LAS AGRUPACIONES SON IDEALES");
        Map <Cliente, Long> numPedidosPorCliente =
                pedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getClientePedido, Collectors.counting())); //voy pedido a pedido (Pedido::) y pillo a los clientes y se agrupan.
                System.out.println(numPedidosPorCliente);
        //SE DEBE IMPORTAR "Map" Y "Collectors".
        System.out.println("\n\nTOTAL DE VENTAS POR PRODUCTO (groupingBy)");
    }  
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CARGA DATOS">
    public void cargaDatos(){
       clientes.put("80580845T",new Cliente("80580845T","ANA ","658111111","ana@gmail.com"));
       clientes.put("36347775R",new Cliente("36347775R","LOLA","649222222","lola@gmail.com"));
       clientes.put("63921307Y",new Cliente("63921307Y","JUAN","652333333","juan@gmail.com"));
       clientes.put("02337565Y",new Cliente("02337565Y","EDU","634567890","edu@gmail.com"));
              
       articulos.put("1-11",new Articulo("1-11","RATON LOGITECH ST ",14,15));
       articulos.put("1-22",new Articulo("1-22","TECLADO STANDARD  ",9,18));
       articulos.put("2-11",new Articulo("2-11","HDD SEAGATE 1 TB  ",16,80));
       articulos.put("2-22",new Articulo("2-22","SSD KINGSTOM 256GB",9,70));
       articulos.put("2-33",new Articulo("2-33","SSD KINGSTOM 512GB",0,200));
       articulos.put("3-22",new Articulo("3-22","EPSON PRINT XP300 ",5,80));
       articulos.put("4-11",new Articulo("4-11","ASUS  MONITOR  22 ",5,100));
       articulos.put("4-22",new Articulo("4-22","HP MONITOR LED 28 ",5,180));
       articulos.put("4-33",new Articulo("4-33","SAMSUNG ODISSEY G5",12,580));
       
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("80580845T-001/2025", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<>(List.of(new LineaPedido(articulos.get("1-11"), 3), new LineaPedido(articulos.get("4-22"), 3)))));
       pedidos.add(new Pedido("80580845T-002/2025", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-11"), 3), new LineaPedido(articulos.get("4-22"), 2), new LineaPedido(articulos.get("4-33"), 4)))));
       pedidos.add(new Pedido("36347775R-001/2025", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-22"), 1), new LineaPedido(articulos.get("2-22"), 3)))));
       pedidos.add(new Pedido("36347775R-002/2025", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-33"), 3), new LineaPedido(articulos.get("2-11"), 3)))));
       pedidos.add(new Pedido("63921307Y-001/2025", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<>(List.of(new LineaPedido(articulos.get("2-11"), 5), new LineaPedido(articulos.get("2-33"), 3), new LineaPedido(articulos.get("4-33"), 2)))));
    }
//</editor-fold>
}
