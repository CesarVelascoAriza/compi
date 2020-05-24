/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ucentral.edu.automatas;

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
    private boolean cierreCararter;
    private boolean estadoCadena;
    private boolean accion;
    private String mensaje;
    private String variblesDeclaradas;

    public boolean isEstadoCadena() {
        return estadoCadena;
    }

    public void setEstadoCadena(boolean estadoCadena) {
        this.estadoCadena = estadoCadena;
    }
    
    

    public AutomataPrograma(List<Palabra> cadena) {
        this.cadena = cadena;
        error = new ErrorSintactico();
        errorSintactico = new ArrayList<>();
        estadoIniciar();
        if (estadoCadena) {
            mensaje = "--------------- final analisis sintáctico ------------";
        }
    }

    public void estadoIniciar() {
        count = 0;
        estadoCadena = false;
        accion= false;
        cierreCararter = false;
        q0();
    }

    public void q0() {
        if (count < cadena.size()) {
            System.out.println("en q0");
            if (cadena.get(count).getPalabra().equals("prog")) {
                count++;
                q1();
            } else {
                estadoError(cadena, error);
            }
        }
    }

    private void q1() {
        if (count < cadena.size()) {
            System.out.println("en q1");
            if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {
                count++;
                q2();
            } else {
                estadoError(cadena, error);
            }
        }
    }

    private void q2() {
        if (count < cadena.size()) {
            System.out.println("en q2");
            if (cadena.get(count).getTipo().equals("RESERVADA")) {
                if (cadena.get(count).getPalabra().equals("var")) {
                    count++;
                    variblesDeclaradas=cadena.get(count).getPalabra();
                    q1();
                } else if (cadena.get(count).getPalabra().equals("variable")) {
                    count++;
                    variblesDeclaradas =variblesDeclaradas.concat(" "+ cadena.get(count).getPalabra());
                    q1();
                } else if (cadena.get(count).getPalabra().equals("inicio")) {
                    count++;
                    q2();
                } else if (cadena.get(count).getPalabra().equals("escriba")) {
                    count++;
                    q2();
                } else if (cadena.get(count).getPalabra().equals("lea")) {
                    count++;
                    System.out.println(""+ variblesDeclaradas);
                    q2();
                } else if (cadena.get(count).getPalabra().equals("entero")) {
                    count++;
                    q2();
                }else if (cadena.get(count).getPalabra().equals("si")) {
                    count++;
                    q2();
                }else if (cadena.get(count).getPalabra().equals("sin")) {
                    count++;
                    q2();
                }else if (cadena.get(count).getPalabra().equals("fsin")) {
                    count++;
                    q2();
                }else if (cadena.get(count).getPalabra().equals("mientras")) {
                    count++;
                    q2();
                }else if (cadena.get(count).getPalabra().equals("haga")) {
                    count++;
                    q2();
                }else if (cadena.get(count).getPalabra().equals("fmientras")) {
                    count++;
                    q2();
                }
                else if (cadena.get(count).getPalabra().equals("fprogram")) {
                    estadoFinal();
                } else {
                    /*count++;
                    q2();*/
                    estadoError(cadena, error);
                }
            } else if (cadena.get(count).getTipo().equals("CARACTERESP")) {
                q3();
            } else if (cadena.get(count).getTipo().equals("MATHOPERADOR")) {
                count++;
                q1();
            } else if (cadena.get(count).getTipo().equals("IDENTIFICADOR")) {
                q1();
            }else if (cadena.get(count).getTipo().equals("OPERADORRELCOMPLEJO")) {
                count++;
            	q4();
            } 
            else {
                estadoError(cadena, error);
            }
        }
    }

    private void q3() {
        if (count < cadena.size()) {
            System.out.println("en q3");
            String caracter = cadena.get(count).getPalabra();
            if (caracter.equals("(") || caracter.equals("[")) {
                cierreCararter = true;
                count++;
                q2();
            } else if (caracter.equals("\"")) {
                count++;
                q2();
            }
            if (cierreCararter) {
                if (cadena.get(count).getPalabra().equals("\"")) {
                    count++;

                } else if (cadena.get(count).getPalabra().equals(")") || cadena.get(count).getPalabra().equals("]")) {
                    cierreCararter = false;
                    count++;
                    q2();
                } else {
                    estadoError(cadena, error);
                }

            }
        } else {
            estadoError(cadena, error);
        }
    }

    private void q4() {
        if (count < cadena.size()) {
            System.out.println("en q4");
            if (cadena.get(count).getTipo().equals("NUMERICO")) {
                count++;
                q2();
            } else {
                estadoError(cadena, error);
            }
        }
    }

    public void estadoFinal() {
        if (count < cadena.size()) {
            System.out.println("en estadoFinal");
            estadoCadena = true;
            if (cadena.get(count).getPalabra().equals("fprogram")) {
                count++;
                estadoFinal();
            } else {
                estadoError(cadena, error);
            }
        }
    }

    public void estadoError(List<Palabra> cadena, ErrorSintactico error) {
        error.setError(count);
        error.setDescripcion("se falta la expresión antes de la palabra "
                + " " + cadena.get(count).getPalabra() + " "
                + " en la linea " + cadena.get(count).getLinea() + "Tipo de palabra "
                + cadena.get(count).getTipo());
        errorSintactico.add(error);
    }

    public List<ErrorSintactico> getErrorSintactico() {
        return errorSintactico;
    }

    public String getMensaje() {
        return mensaje;
    }

}