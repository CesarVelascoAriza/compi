/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import java.util.ArrayList;
import java.util.Scanner;

import co.ucentral.edu.model.Palabra;
import com.co.ucentral.edu.automatas.AutomataPrograma;
import java.util.List;
import co.ucentral.edu.analizadores.Semantico;
/**
 *
 * @author Adolfo
 */
public class Lexico {
    
    private Scanner escaner; 
    private Scanner escanerSparte;
    ArrayList<Palabra> listaPalabras= new ArrayList<Palabra>();    
    private AutomataPrograma automata;

    private Semantico semantico=new Semantico();

    //private AnalizarPrograma automata;
    private String mensaje;

    public Lexico() {
    }

    public ArrayList<Palabra> analizadorLexico(String texto){
        escaner = new Scanner(texto);
        int linea =1;
        while(escaner.hasNext()){
            //System.out.printf("Texto = %s \t Linea = %d \n" , escaner.nextLine(),linea);
            tablaSimbolos(escaner.nextLine(), linea);
            linea++;
        }
        //automata= new AutomataPrograma(listaPalabras);
        mensaje="-------------Termina analisis lexico --------------";
        automata= new AutomataPrograma(listaPalabras);
        if(automata.isEstadoCadena())
            analizarInstrucción(listaPalabras);
        
        return listaPalabras;
    }
    
    public void analizarInstrucción(ArrayList<Palabra> listaPalabras){
        int linea=0;
        String strlinea="";
        for (Palabra p : listaPalabras)
        {
            switch(p.getPalabra())
            {
                case "variable":
                case "var":
                   strlinea=traeLinea(p.getLinea());
                   semantico.analizadorVariable(strlinea,p.getLinea());  
                break;
                case "escriba":
                   strlinea=traeLinea(p.getLinea());
                   semantico.analizadorEscriba(strlinea,p.getLinea()); 
                break;
                
                case "lea":
                    strlinea=traeLinea(p.getLinea());
                    semantico.analizadorLea(strlinea,p.getLinea());
                break;
                case "si":
                case "sin":
                case "fsi":
                    strlinea=traeLinea(p.getLinea());
                    semantico.analizadorSi(strlinea,p.getLinea());
                break;
                case "para":
                    strlinea=traeLinea(p.getLinea());
                    semantico.analizadorPara(strlinea,p.getLinea());
                break;
                    
            }
            
        }
        
    }
    
    public String traeLinea(int linea)
    {
        String strlinea = "";
       for(int i=0;i<listaPalabras.size();i++)
       {
           if(linea==listaPalabras.get(i).getLinea())
           {
               strlinea += listaPalabras.get(i).getPalabra() + " ";
           }
       }
       return strlinea;
    }
    
    public void tablaSimbolos(String linea, int numeroLinea){
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
        
    }

//    private String tipoPalabra(String palabra) {
//        String tipoPal="";
//        Simbolos simbolo=new Simbolos();
//        if(simbolo.definiTipo(palabra, simbolo.palabrasReservadas))
//        {
//            tipoPal="RESERVADA";
//        }
//        else if(simbolo.definiTipo(palabra, simbolo.operadoresMatemáticos))
//        {
//            tipoPal="MATHOPERADOR";
//        }
//        else if(simbolo.definiTipo(palabra, simbolo.caracteresEspeciales))
//        {
//            tipoPal="CARACTERESP";
//        }
//        else if(simbolo.definiTipo(palabra, simbolo.operadoresRelComplejos))
//        {
//            tipoPal="OPERADORRELCOMPLEJO";
//        }
//        else if(simbolo.definiTipo(palabra, simbolo.operadoresRel))
//        {
//            tipoPal="OPERADORREL";
//        }
//        else if(simbolo.validaNumeros(palabra))
//        {
//            tipoPal="NUMERICO";
//        }
//        else
//        {
//            tipoPal="IDENTIFICADOR";
//        }
//        return tipoPal;
//    }
//
//    private String separar(String[] signos, String pal) {
//        String newPal = pal;
//        
//        switch(signos[0])
//        {
//            case "=" :
//                //String [] signos = {"=" , "(" , ")" , "\"" , "+" , "-" , "*" , "/" , "^"};
//                if(pal.contains(signos[0])){ newPal= newPal.replace("=", " = ");}
//                if(pal.contains(signos[1])){ newPal= newPal.replace("(", " ( ");}
//                if(pal.contains(signos[2])){ newPal= newPal.replace(")", " ) ");}
//                if(pal.contains(signos[3])){ newPal= newPal.replace("\"", " \" ");}
//                if(pal.contains(signos[4])){ newPal= newPal.replace("+", " + ");}
//                if(pal.contains(signos[5])){ newPal= newPal.replace("-", " - ");}
//                if(pal.contains(signos[6])){ newPal= newPal.replace("*", " * ");}
//                if(pal.contains(signos[7])){ newPal= newPal.replace("/", " / ");}
//                if(pal.contains(signos[8])){ newPal= newPal.replace("^", " ^ ");}
//                break;
//            case ">=" :
//                //String [] signosCompl = { ">=" , "<=" , "<>" , "==" , "(" , ")" , "\"" };
//                if(pal.contains(signos[0])){ newPal= newPal.replace(">=", " >= ");}
//                if(pal.contains(signos[1])){ newPal= newPal.replace("<=", " <= ");}
//                if(pal.contains(signos[2])){ newPal= newPal.replace("<>", " <> ");}
//                if(pal.contains(signos[3])){ newPal= newPal.replace("==", " == ");}
//                if(pal.contains(signos[4])){ newPal= newPal.replace("(", " ( ");}
//                if(pal.contains(signos[5])){ newPal= newPal.replace(")", " ) ");}
//                if(pal.contains(signos[6])){ newPal= newPal.replace("\"", " \" ");}
//                break;
//                    
//        }
//        
//        return newPal;
//    }

    /*public AutomataPrograma getAutomata() {
        return automata;
    }*/
    public AutomataPrograma getAutomata() {
        return automata;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
