/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import co.ucentral.edu.analizadores.Simbolos;
import co.ucentral.edu.model.Palabra;
import co.ucentral.edu.analizadores.Lexico;
import co.ucentral.edu.model.Variables;
import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import com.ucentral.compiladores.scorte.FrameSCorte;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import org.w3c.dom.NodeList;
/**
 *
 * @author rosemberg
 */

/**
 * public String[] palabrasReservadas={"prog","haga","lea","escriba",
        "var", "inicio" ,"fprogram","entero", "real", "verdadero", "falso", "cadena" ,"y"
    ,"o", "no", "mientras", "haga", "fmientras","si", "sin", "fsi"};
    
    public String[] operadoresMatemáticos={"*" , "+" , "-" , "/" , "^" , "="};
    
    public String[] caracteresEspeciales={"@" , "." , ";" , "," , "{" , "}" , "(" , ")" ,"\""};
    
    public String[] operadoresRelComplejos= {">=" , "<=" , "<>" , "=="};
    
    public String[] operadoresRel= {">" , "<" };
 * @author rosemberg
 */
public class Semantico {
    Simbolos simbolo= new Simbolos();
    ArrayList<Variables> listaVar=new ArrayList<Variables>();
    private String tAEscriba;
    FrameSCorte sCFrame;
    
    public String[] iniciaProg={ simbolo.palabrasReservadas[0], simbolo.palabrasReservadas[0]+" IDENTIFICADOR "};
    public String[] asignaVar={simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[7],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[8],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[9],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[10],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[11],
                            };
    public String[] indicarEscriba={simbolo.palabrasReservadas[3]+simbolo.caracteresEspeciales[6]+simbolo.caracteresEspeciales[8]+" LISTIDENTIFICADOR "+simbolo.caracteresEspeciales[8]+simbolo.caracteresEspeciales[7],
                                    simbolo.palabrasReservadas[3]+simbolo.caracteresEspeciales[6]+" IDENTIFICADOR "+simbolo.caracteresEspeciales[7]};
    //public String[] indicarEscribaVar={"RESERVADA CARACTERESP IDENTIFICADOR CARACTERESP"};
    public String[] indicarLea={simbolo.palabrasReservadas[2]+simbolo.caracteresEspeciales[6]+" IDENTIFICADOR "+simbolo.caracteresEspeciales[7]};
    
    
    public void analizadorEscriba(String strlinea, int linea)
    {
       System.out.println(strlinea);
       ArrayList<Palabra> listaLinea=new ArrayList<Palabra>();
       listaLinea=tablaSimbolos(strlinea, linea);
       String identificador ="";
       boolean esVar=false;
       
       for (Palabra p : listaLinea)
       {
           if(p.getTipo().equals("IDENTIFICADOR"))
           {
               for (Variables lv : listaVar)
               {
                   //Busca que el identificador exista en la lista de Variables, si lo encuentra muestra el valor, 
                   //en caso de no encontrarlo, lo mostrará como mensaje.
                   if(p.getPalabra().equals(lv.getIdentificador()))
                   {
                       identificador=lv.getValor();
                       esVar=true;
                   }
               }
                
               if(!esVar)
                identificador += p.getPalabra()+ " ";
                   
           }
       }
       identificador +="\n";
       tAEscriba= identificador;
    }

    public void analizadorLea(String strlinea, int linea) 
    {
       System.out.println(strlinea);
       ArrayList<Palabra> listaLinea=new ArrayList<Palabra>();
       String identificador= "";
       String tipoVar = "";
       String defaultval = ""; 
       String _defaultval="";
       boolean esVar=false;
       String _pInt = "";
       String _pDec = "";
       listaLinea=tablaSimbolos(strlinea, linea);
       
       for (Palabra p : listaLinea)
       {
            if(p.getTipo().equals("IDENTIFICADOR"))
            {
                for (Variables lv : listaVar)
               {
                   if(p.getPalabra().equals(lv.getIdentificador()))
                   {
                       _defaultval= JOptionPane.showInputDialog(null,"Valor para variable "+p.getPalabra()+" tipo "+lv.getTipo());
                       tipoVar=lv.getTipo();
                       switch (tipoVar)
                       {
                            case "entero":
                                if(simbolo.validaNumeros(_defaultval))
                                {
                                    defaultval=_defaultval;
                                    lv.setValor(defaultval);
                                    esVar=true;
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "DATO ENTERO INVALIDO");
                                }
                                
                            break;
                            case "real":
                                if(!_defaultval.contains("."))
                                {
                                    defaultval=_defaultval+".0";
                                    lv.setValor(defaultval);
                                    esVar=true;
                                }
                                else
                                {
                                    String[] _real= _defaultval.split("\\.");
                                    _pInt = _real[0];
                                    _pDec = _real[1];
                                    if(simbolo.validaNumeros(_pInt) && simbolo.validaNumeros(_pDec))
                                    {
                                        defaultval=_defaultval;
                                        lv.setValor(defaultval);
                                        esVar=true;
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "DATO REAL INVALIDO");
                                    }
                                }
                                
                            break;
                            case "booleano":
                                if(_defaultval.equals("verdadero") || _defaultval.equals("falso"))
                                {
                                    defaultval=_defaultval;
                                    lv.setValor(defaultval);
                                    esVar=true;
                                }
                            break;
                            case "cadena":
                                defaultval=_defaultval;
                                lv.setValor(defaultval);
                                esVar=true;
                                
                            break;
                       }
                   }
//                   if(!esVar)
//                    JOptionPane.showMessageDialog(null, "No hay variable asignada para "+p.getPalabra());
               }
             
            }
       }
    }
    
    public void analizadorVariable(String strlinea, int linea) 
    {
       System.out.println(strlinea);
       ArrayList<Palabra> listaLinea=new ArrayList<Palabra>();
       String identificador= "";
       String tipoVar = "";
       String defaultval = "";       
       listaLinea=tablaSimbolos(strlinea, linea);
       
       for (Palabra p : listaLinea)
       {
           if(p.getTipo().equals("IDENTIFICADOR"))
           {
               identificador=p.getPalabra();
           }
           else if(p.getTipo().equals("RESERVADA"))
           {
               tipoVar=p.getPalabra();
               switch (p.getPalabra())
               {
                   case "entero":
                   case "real":
                       defaultval="0";
                   break;
                   case "booleano":
                       defaultval="false";
                   break;
                   case "cadena":
                       defaultval="";
                   break;
                       
               }
           }
       }
       Variables var=new Variables(identificador,tipoVar,defaultval);
       listaVar.add(var);
    }

    public void analizadorSi(String strlinea, int linea) {
        System.out.println(strlinea);
       ArrayList<Palabra> listaLinea=new ArrayList<Palabra>();
       listaLinea=tablaSimbolos(strlinea, linea); 
    }

    public void analizadorPara(String strlinea, int linea) {
       System.out.println(strlinea);
       ArrayList<Palabra> listaLinea=new ArrayList<Palabra>();
       listaLinea=tablaSimbolos(strlinea, linea);
       
       
    }
    
    public ArrayList<Palabra> tablaSimbolos(String linea, int numeroLinea){
         Scanner escaner; 
         Scanner escanerSparte;
        ArrayList<Palabra> listaPalabras= new ArrayList<Palabra>(); 
        escanerSparte = new Scanner(linea);
        Simbolos simbolo = new Simbolos();
        String tipo;
        int i;
        while (escanerSparte.hasNext()) { 
            String pal=escanerSparte.next();
            String [] signos = {"=" , "(" , ")" , "\"" , "+" , "-" , "*" , "/" , "^"};
            String [] signosCompl = { ">=" , "<=" , "<>" , "==" , "(" , ")" , "\"" };
            if(pal.contains(signosCompl[0]) || pal.contains(signosCompl[1]) || pal.contains(signosCompl[2]) || pal.contains(signosCompl[3] ))
            {
                String newStr = simbolo.separar(signosCompl,pal);
                Scanner escanNewStr = new Scanner(newStr);
                while(escanNewStr.hasNext())
                {
                    String newPal=escanNewStr.next();
                    tipo = simbolo.tipoPalabra(newPal);
                    Palabra palabra=new Palabra(numeroLinea, tipo, newPal);
                    listaPalabras.add(palabra);
                }
            }
            else if(pal.contains(signos[0]) || pal.contains(signos[1]) || pal.contains(signos[2]) || pal.contains(signos[3]) || pal.contains(signos[4]) || pal.contains(signos[5]) || pal.contains(signos[6]) || pal.contains(signos[7])|| pal.contains(signos[8]))
            {
                String newStr = simbolo.separar(signos,pal);
                Scanner escanNewStr = new Scanner(newStr);
                while(escanNewStr.hasNext())
                {
                    String newPal=escanNewStr.next();
                    tipo = simbolo.tipoPalabra(newPal);
                    Palabra palabra=new Palabra(numeroLinea, tipo, newPal);
                    listaPalabras.add(palabra);
                }
                
            }
            else
            {
                tipo = simbolo.tipoPalabra(pal);
                Palabra palabra=new Palabra(numeroLinea, tipo, pal);
                listaPalabras.add(palabra);
            }
        }
        return listaPalabras;
    }
    
    
    public ArrayList<String> getArray(String strlinea) {
        ArrayList<String> listLineas= new ArrayList();
        
        String[] separar = strlinea.split("\n");
        for (int i=0;i< separar.length; i++)
        {
            listLineas.add(separar[i]);
        }
        
        return listLineas;
    }
    

    public String gettAEscriba() {
        return tAEscriba;
    }

    public ArrayList<Variables> getListaVar() {
        return listaVar;
    }   
    
}
