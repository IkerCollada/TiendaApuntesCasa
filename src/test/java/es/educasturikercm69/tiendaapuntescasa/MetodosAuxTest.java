/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package es.educasturikercm69.tiendaapuntescasa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Iker
 */
public class MetodosAuxTest {
    
    public MetodosAuxTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * PRUEBAS DE CAJA NEGRA (DAS UNOS DATOS Y SOLAMENTE INDICA SI TODO HA SIDO CORRECTO).
     * Están los asserts a secas, que si hay una equivocación, no nos dirá en qué línea está fallando.
     * En ese caso, tenemos la comodidad de los assertAll. Estos nos indican dónde ha fallado.
     */
    public void testEsInt() {
        //AssertAll (más cómodo, indican el error en x línea):
        assertAll(
                () -> assertTrue(MetodosAux.esInt("5")),
                () -> assertTrue(MetodosAux.esInt("-5")),
                () -> assertFalse(MetodosAux.esInt("55555555555555555555")),
                () -> assertFalse(MetodosAux.esInt("5.5")),
                () -> assertFalse(MetodosAux.esInt("dcdjcdc"))
        );
    }

    public void testEsDouble() {
        //Los asserts a secas, sin assertAll (estos no indican el error en x línea. Lo debes buscar tu mismo):
        assertTrue(MetodosAux.esDouble("5"));
        assertTrue(MetodosAux.esDouble("-5"));
        assertTrue(MetodosAux.esDouble("-5555555.5"));
        assertTrue(MetodosAux.esDouble("5.5"));
        assertFalse(MetodosAux.esDouble("dcdjcdc"));
    }

    public void testValidarDNI() {
        assertAll(
                () -> assertTrue(MetodosAux.validarDNI("80580845T")),
                () -> assertTrue(MetodosAux.validarDNI("36347775R")),
                () -> assertFalse(MetodosAux.validarDNI("36347775A")),
                () -> assertFalse(MetodosAux.validarDNI("3634777A")),
                () -> assertFalse(MetodosAux.validarDNI("3634775A")),
                () -> assertFalse(MetodosAux.validarDNI("80580845P"))
        );
    }
}
