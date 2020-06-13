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
import com.sun.tools.javac.util.Convert;
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
                       defaultval="falso";
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
    
    public void analizadorAsignacion(String strlinea, int linea)
    {
        System.out.println(strlinea);
        ArrayList<Palabra> listaLinea=new ArrayList<Palabra>();
        Variables variable=new Variables();
        listaLinea=tablaSimbolos(strlinea, linea);
        
        float valorVar=0;//Valor de la variable 
        float _valorSumando=0;
        float _valorSumandoB=0;
        String valorEntrega="";
        
        String [] ArrayLinea=strlinea.split(" ");
        
        switch(ArrayLinea[1])
        {
            case "+=":
                System.out.println("Igualador Complejo" + ArrayLinea[1]);
                variable=getVariable(listaLinea.get(0).getPalabra());
                switch (variable.getTipo())
                {
                    case "entero":
                        float valor=0; //Valor resultante de la operación
                        valorVar=Integer.parseInt(variable.getValor());//Valor de la variable 
                         _valorSumando=0;
                        Variables varMas = new Variables();//Captura de valor Operador
                        varMas=getVariable(listaLinea.get(2).getPalabra());
                        if(varMas.getValor()!=null)
                        {
                            _valorSumando=Integer.parseInt(varMas.getValor());
                        }
                        else
                        {
                            _valorSumando=Integer.parseInt(listaLinea.get(2).getPalabra());
                        }
                        
                        valor=operacionMath(valorVar,_valorSumando,"+");
                        valorEntrega = Integer.toString((int)valor);
                        sendResult(listaLinea.get(0).getPalabra(),valorEntrega);
                        
                    break;
                    case "real":
                        valor=0; //Valor resultante de la operación
                        valorVar=Integer.parseInt(variable.getValor());//Valor de la variable 
                         _valorSumando=0;
                        varMas = new Variables();//Captura de valor Operador
                        varMas=getVariable(listaLinea.get(2).getPalabra());
                        if(varMas!=null)
                        {
                            _valorSumando=Integer.parseInt(varMas.getValor());
                        }
                        else
                        {
                            _valorSumando=Integer.parseInt(listaLinea.get(2).getPalabra());
                        }
                        
                        valor=operacionMath(valorVar,_valorSumando,"+");
                        valorEntrega = String.valueOf(valor);
                        sendResult(listaLinea.get(0).getPalabra(),valorEntrega);
                    break;
                }
            break;
            case "=":
                if(strlinea.contains("+") || strlinea.contains("-") || strlinea.contains("*") || strlinea.contains("/") || strlinea.contains("^"))
                {
                    System.out.println("igualador simple: "+ArrayLinea[1]);
                    variable=getVariable(listaLinea.get(0).getPalabra());
                    switch (variable.getTipo())
                    {
                        case "entero":
                            float valor=0; //Valor resultante de la operación
                            valorVar=Integer.parseInt(variable.getValor());//Valor de la variable 
                             _valorSumando=0;
                            Variables varA = new Variables();//Captura de valor Operador a
                            Variables varB = new Variables();//Captura de valor Operador a
                            varA=getVariable(listaLinea.get(2).getPalabra());
                            varB=getVariable(listaLinea.get(4).getPalabra());

                            _valorSumando=(varA.getValor()!=null)? Integer.parseInt(varA.getValor()) : Integer.parseInt(listaLinea.get(2).getPalabra());
                            _valorSumandoB=(varB.getValor()!=null)? Integer.parseInt(varB.getValor()) : Integer.parseInt(listaLinea.get(4).getPalabra());

                            valor=operacionMath(_valorSumando,_valorSumandoB,listaLinea.get(3).getPalabra());
                            valorEntrega = Integer.toString((int)valor);
                            sendResult(listaLinea.get(0).getPalabra(),valorEntrega);

                        break;
                        case "real":
                            valor=0; //Valor resultante de la operación
                            valorVar=Integer.parseInt(variable.getValor());//Valor de la variable 
                             _valorSumando=0;
                            varA = new Variables();//Captura de valor Operador a
                            varB = new Variables();//Captura de valor Operador a
                            varA=getVariable(listaLinea.get(2).getPalabra());
                            varB=getVariable(listaLinea.get(4).getPalabra());

                            _valorSumando=(varA.getValor()!=null)? Integer.parseInt(varA.getValor()) : Integer.parseInt(listaLinea.get(2).getPalabra());
                            _valorSumandoB=(varB.getValor()!=null)? Integer.parseInt(varB.getValor()) : Integer.parseInt(listaLinea.get(4).getPalabra());

                            valor=operacionMath(_valorSumando,_valorSumandoB,listaLinea.get(3).getPalabra());
                            valorEntrega = String.valueOf(valor);
                            sendResult(listaLinea.get(0).getPalabra(),valorEntrega);
                        break;
                    }
                 
                }
                else
                {
                    System.out.println("igualador simple: "+ArrayLinea[1]);
                    variable=getVariable(listaLinea.get(0).getPalabra());
                    switch (variable.getTipo())
                    {
                        case "entero":
                            sendResult(variable.getIdentificador(), listaLinea.get(2).getPalabra());
                        break;
                        case "real":
                            sendResult(variable.getIdentificador(), listaLinea.get(2).getPalabra());
                        break;
                        case "booleano":
                            sendResult(variable.getIdentificador(), listaLinea.get(2).getPalabra());    
                        break;
                    }       
                }
                
                
            break;
        }
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
            String [] signosCompl = { ">=" , "<=" , "<>" , "==" , "(" , ")" , "\"", "+=" };
            if(pal.contains(signosCompl[0]) || pal.contains(signosCompl[1]) || pal.contains(signosCompl[2]) || pal.contains(signosCompl[3]) || pal.contains(signosCompl[4]) || pal.contains(signosCompl[5]) || pal.contains(signosCompl[6]) || pal.contains(signosCompl[7]))
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
    
    float operacionMath(float a, float b, String op) {
        float r;
        switch (op) {
            case "+":
                r = (a + b);
                break;
            case "-":
                r = (a - b);
                break;
            case "*":
                r = a * b;
                break;
            case "/":
                r = (a / b);
                break;
            case "^":
                r = (float) Math.pow(a, b);
                break;
            default:
                r = Float.NaN; // Error....
        }
        return r;
    }
    
    
    public Variables getVariable(String identificador)
    {
        Variables var=new Variables();
//        String ident="";
//        String tipo="";
//        String valor="";
        for (Variables v : listaVar )
        {
            if(v.getIdentificador().equals(identificador))
            {
                var.setIdentificador(v.getIdentificador());
                var.setTipo(v.getTipo());
                var.setValor(v.getValor());
                
            }
        }
        
        return var;
    }
    
    
    public void sendResult(String identificador, String valor)
    {
        for (Variables v:listaVar)
        {
            if(v.getIdentificador().equals(identificador))
            v.setValor(valor);
        }
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
