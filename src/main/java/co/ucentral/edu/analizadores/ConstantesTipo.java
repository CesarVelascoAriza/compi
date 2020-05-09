/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

/**
 *
 * @author Adolfo
 */
public enum ConstantesTipo {
    RESERVADA("RESERVADA"),
    MATHOPERADOR("MATHOPERADOR"),
    CARACTERESP("CARACTERESP"),
    OPERADORRELCOMPLEJO("OPERADORRELCOMPLEJO"),
    OPERADORREL("OPERADORREL"),
    NUMERICO("NUMERICO"),
    IDENTIFICADOR("IDENTIFICADOR");
    
    private final String contante;

    private ConstantesTipo(String contante) {
        this.contante = contante;
    }

    public static ConstantesTipo getRESERVADA() {
        return RESERVADA;
    }

    public static ConstantesTipo getMATHOPERADOR() {
        return MATHOPERADOR;
    }

    public static ConstantesTipo getCARACTERESP() {
        return CARACTERESP;
    }

    public static ConstantesTipo getOPERADORRELCOMPLEJO() {
        return OPERADORRELCOMPLEJO;
    }

    public static ConstantesTipo getOPERADORREL() {
        return OPERADORREL;
    }

    public static ConstantesTipo getNUMERICO() {
        return NUMERICO;
    }

    public static ConstantesTipo getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public String getContante() {
        return contante;
    }
    
    
    
    
}
