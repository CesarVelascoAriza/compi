/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ucentral.edu.automatas;

import co.ucentral.edu.analizadores.ConstantesTipo;
import co.ucentral.edu.model.Palabra;
import com.co.ucentral.edu.error.ErrorSintactico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class AutomataPrograma {

    private int count;
    private List<Palabra> cadena;
    private ErrorSintactico error;
    private List<ErrorSintactico> errorSintactico;
    private boolean estado;
    private String finAnalizar;
    private boolean cadenaAceptada;

    public AutomataPrograma(List<Palabra> cadena) {
        count = 0;
        this.cadena = cadena;
        error = new ErrorSintactico();
        errorSintactico = new ArrayList<>();
        estado = false;
        cadenaAceptada = false;
        estadoUno();
    }

    public void estadoUno() {
        System.out.println("estadoUno  ");
        if (cadenaAceptada) {

        } else if (!cadena.get(count).equals("prog")) {
            count++;
            estadoDos();
        } else {
            error.setError(1);
            error.setDescripcion("falata la palabra prog en la liena "
                    + cadena.get(count).getLinea());
            errorSintactico.add(error);
        }

    }

    public void estadoDos() {
        if (!cadenaAceptada) {
            System.out.println("estado2  ");
            if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {
                count++;
                estadoTres();
            } else {

                error.setError(1);
                error.setDescripcion("falata el identificiador del programa en la liena "
                        + cadena.get(count).getLinea());
                errorSintactico.add(error);
            }
        }
    }

    private void estadoTres() {
        if (!cadenaAceptada) {
            System.out.println("estado3  ");
            if (cadena.get(count).getTipo().equals("RESERVADA")) {
                if (cadena.get(count).getPalabra().equals("var")) {
                    count++;
                    estadoCuatro();
                } else if (cadena.get(count).getPalabra().equals("variable")) {
                    count++;
                    estadoCuatro();
                } else {
                    error.setError(1);
                    error.setDescripcion("falta palabra reservada "
                            + cadena.get(count).getLinea());
                    errorSintactico.add(error);
                }
            }
        }
    }

    private void estadoCuatro() {
        if (!cadenaAceptada) {
            System.out.println("estado4  ");
            if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {
                count++;
                estadoCinco();
            } else {
                error.setError(1);
                error.setDescripcion("falta palabra declaracion "
                        + cadena.get(count).getLinea());
                errorSintactico.add(error);
            }
        }
    }

    private void estadoCinco() {
        if (!cadenaAceptada) {
            System.out.println("estado5  ");
            if (cadena.get(count).getTipo().equals("RESERVADA")) {
                count++;
                estadoSeis();
            } else {
                error.setError(1);
                error.setDescripcion("falta palabra reservada "
                        + cadena.get(count).getLinea());
                errorSintactico.add(error);

            }
        }
    }

    private void estadoSeis() {
        if (!cadenaAceptada) {
            System.out.println("estado6  ");
            if (cadena.get(count).getTipo().equals("RESERVADA")) {
                count++;
                estadoSiete();
                System.out.println(ConstantesTipo.CARACTERESP);
            } else {
                error.setError(1);
                error.setDescripcion("falta palabra reservada "
                        + cadena.get(count).getLinea());
                errorSintactico.add(error);

            }
        }
    }

    private void estadoSiete() {
        System.out.println("estado7  ");
        if (cadena.get(count).getTipo().equals("RESERVADA") && cadena.get(count).getPalabra().equals("fprogram")) {
            estadoDies();

        } else if (!cadenaAceptada) {
            System.out.println("estado  " + cadenaAceptada);
            if (cadena.get(count).getTipo().equals("RESERVADA")) {
                count++;
                estadoOcho();
            } else {
                error.setError(1);
                error.setDescripcion("falta palabra reservada "
                        + cadena.get(count).getLinea());
                errorSintactico.add(error);

            }
        }
    }

    private void estadoOcho() {
        if (!cadenaAceptada) {
            if (cadena.get(count).getTipo().equals("CARACTERESP")) {
                String caracter = cadena.get(count).getPalabra();
                if (caracter.equals("(") || caracter.equals("[")) {
                    estado = true;
                    count++;
                    estadoOcho();

                } else if (caracter.equals("\"")) {
                    count++;
                    estadoNueve();
                } else if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {

                    estadoNueve();

                }
                if (estado) {
                    if (cadena.get(count).getPalabra().equals("\"")) {
                        count++;
                        estadoOcho();

                    } else if (cadena.get(count).getPalabra().equals(")") || cadena.get(count).getPalabra().equals("]")) {
                        estado = false;
                        count++;
                        estadoSiete();

                    } else {
                        error.setError(1);
                        error.setDescripcion("falta cerrar correctamete la exprescion "
                                + cadena.get(count).getLinea());
                        errorSintactico.add(error);

                    }

                }

            } else if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {
                estadoNueve();
            } else if (cadena.get(count).getTipo().equals("RESERVADA")) {
                estadoSiete();
            } else {
                error.setError(count);
                error.setDescripcion("falta palabra reservada "
                        + cadena.get(count).getPalabra()
                        + cadena.get(count).getLinea());
                System.err.println("error en el estado ocho ");
                errorSintactico.add(error);

            }
        }
    }

    private void estadoNueve() {
        if (!cadenaAceptada) {
            if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {
                count++;
                estadoNueve();
            } else if (cadena.get(count).getTipo().equals("CARACTERESP")) {
                count++;
                estadoOcho();

            } else if (cadena.get(count).getTipo().equals("MATHOPERADOR")) {
                count++;
                estadoOnce();
            } else if (cadena.get(count).getTipo().equals("RESERVADA")) {
                estadoSiete();
            } else {
                error.setError(1);
                error.setDescripcion("falta palabra declaracion "
                        + cadena.get(count).getLinea());
                errorSintactico.add(error);
            }
        }
    }

    public void estadoDies() {
        System.out.println("estado10  ");
        setFinAnalizar("Termina correctamente ");
        cadenaAceptada = true;

    }

    public List<ErrorSintactico> getErrorSintactico() {
        return errorSintactico;
    }

    public void estadoOnce() {
        if (!cadenaAceptada) {
            if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {
                count++;
                estadoNueve();
            } else {
                error.setError(1);
                error.setDescripcion("falta palabra declaracion "
                        + cadena.get(count).getLinea());
                errorSintactico.add(error);
            }
        }
    }

    public String getFinAnalizar() {
        return finAnalizar;
    }

    public void setFinAnalizar(String finAnalizar) {
        this.finAnalizar = finAnalizar;
    }

}
