package Modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Modelo {
       
    //Lee el archivo y guarda los numeros en el arraylist
    public ArrayList<Integer> lectura2(){
        try{
            File archivo = new File("C:\\Users\\danie\\Documents\\archivos\\numeros.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Variables de Control
            String bfRead;       
            int i=0;
            ArrayList<Integer> arreglo = new ArrayList();
            //Ciclo que me almacena en un arreglo los numeros mientras existan
            while( (bfRead = br.readLine()) != null  ){ 
                arreglo.add(Integer.parseInt(bfRead));
            }
            fr.close();
            return(arreglo);
        } catch (IOException e){
            System.out.println("Error: "+e);
            return(null);
        }        
    }
    
    //Metodo Burbuja
    public ArrayList<Integer> MetodoBurbuja(ArrayList<Integer> arreglo){
        long Tinicio, Tfin, tiempo;                                            //Variables para medir el tiempo de ejecucion
        Tinicio = System.currentTimeMillis();
        int aux;                                                               //Variable auxiliar de cambio
        for (int i = 0; i < (arreglo.size()-1); i++) {                         //For para saber cuantas vueltas tiene que dar   
            for (int j = 0; j < (arreglo.size()-1); j++) {                     //For para ordenar los numeros para irlos intercambiando
                if(arreglo.get(j) > arreglo.get(j+1)) {
                    aux = arreglo.get(j);
                    arreglo.set(j, arreglo.get(j+1));
                    arreglo.set(j+1, aux);
                }
            }
        }
        Tfin = System.currentTimeMillis();
        long seconds_ini = (Tinicio / 1000) % 60;                              //Conversion de los milisegundos a segundos
        long seconds_fin = (Tfin / 1000) % 60;
        tiempo = seconds_fin - seconds_ini;
        JOptionPane.showMessageDialog(null," Orden finalizado con Metodo Burbuja y tomo: " + tiempo + " Segundos");
        return(arreglo);
    }
    
    //MetodoQuickSort
    public ArrayList<Integer> MetodoQuickSort(ArrayList<Integer> arreglo, int primero, int ultimo){
        long Tinicio, Tfin, tiempo;                                            //Variables para medir el tiempo de ejecucion
        Tinicio = System.currentTimeMillis();
        int i, j, pivote, aux;
        i = primero;
        j = ultimo;        
        pivote = arreglo.get((primero+ultimo)/2);                               //Dividir el arreglo en 2 partes 
        do{
            while(arreglo.get(i) < pivote){
                i++;
            }
            while(arreglo.get(j)> pivote){
                j--;
            }
            //Se hace el intercambio
            if(i <= j){
                aux = arreglo.get(i);
                arreglo.set(i, arreglo.get(j));
                arreglo.set(j, aux);
                i++;
                j--;
            }
        }while(i<=j);             
        
        if(primero < j){
            MetodoQuickSort(arreglo, primero, j);                               //Invoca al metodo para que se repita el proceso
        }
        if(i < ultimo){
            MetodoQuickSort(arreglo, i, ultimo);                                //Invoca al metodo para que se repita el proceso
        }
     return arreglo;       
    }
    
    //Metodo para crear el archivo y guardar los numeros segun el ordenamiento burbuja
    public void orden(ArrayList<Integer> arreglo, String tipo){
        FileWriter fichero = null;
        PrintWriter pw = null;
        if(tipo.equals("Ascendente")){
            try{
                File ficheros = new File("C:\\Users\\danie\\Documents\\archivos\\ascb.txt");             //Busca el archivo ascb
                ficheros.delete();                                                                       //Borra el archivo ascb, esto con el fin de que no se sobreescriba si se ejecuta otra vez 
                fichero = new FileWriter("C:\\Users\\danie\\Documents\\archivos\\ascb.txt", true);       //Lo vuelve a crear
                pw = new PrintWriter(fichero);
                for(int i = 0; i < arreglo.size();  i++){
                    pw.println(arreglo.get(i));
                } 
            } catch (IOException e){
                System.out.println("Error: "+e);
            } finally {
                try{
                    if(null != fichero)
                        fichero.close();        
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        
        }
        else {
            try{
                File ficheros = new File("C:\\Users\\danie\\Documents\\archivos\\descb.txt");             //Busca el archivo descb
                ficheros.delete();                                                                        //Borra el archivo ascb, esto con el fin de que no se sobreescriba si se ejecuta otra vez 
                fichero = new FileWriter("C:\\Users\\danie\\Documents\\archivos\\descb.txt", true);       //Lo vuelve a crear
                pw = new PrintWriter(fichero);
                for(int i = arreglo.size()-1; i>=0; i--){
                    pw.println(arreglo.get(i));
                } 
            } catch (IOException e){
                System.out.println("Error: "+e);
            } finally {
                try{
                    if(null != fichero)
                        fichero.close();        
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }      
        }   
    }
    
    //Metodo para crear el archivo y guardar los numeros segun el ordenamiento quick
    public void orden2(ArrayList<Integer> arreglo, String tipo){
        FileWriter fichero = null;
        PrintWriter pw = null;
        if(tipo.equals("Ascendente")){
            try{
                File ficheros = new File("C:\\Users\\danie\\Documents\\archivos\\ascqs.txt");            //Busca el archivo ascqs
                ficheros.delete();                                                                       //Borra el archivo ascqs, esto con el fin de que no se sobreescriba si se ejecuta otra vez 
                fichero = new FileWriter("C:\\Users\\danie\\Documents\\archivos\\ascqs.txt", true);      //Lo vuelve a crear
                pw = new PrintWriter(fichero);
                for(int i = 0; i < arreglo.size();  i++){
                    pw.println(arreglo.get(i));
                } 
            } catch (IOException e){
                System.out.println("Error: "+e);
            } finally {
                try{
                    if(null != fichero)
                        fichero.close();        
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        
        }
        else {
            try{
                File ficheros = new File("C:\\Users\\danie\\Documents\\archivos\\descqs.txt");            //Busca el archivo ascqs
                ficheros.delete();                                                                        //Borra el archivo ascqs, esto con el fin de que no se sobreescriba si se ejecuta otra vez 
                fichero = new FileWriter("C:\\Users\\danie\\Documents\\archivos\\descqs.txt", true);      //Lo vuelve a crear
                pw = new PrintWriter(fichero);
                for(int i = arreglo.size()-1; i>=0; i--){
                    pw.println(arreglo.get(i));
                } 
            } catch (IOException e){
                System.out.println("Error: "+e);
            } finally {
                try{
                    if(null != fichero)
                        fichero.close();        
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }      
        }   
    } 

}
