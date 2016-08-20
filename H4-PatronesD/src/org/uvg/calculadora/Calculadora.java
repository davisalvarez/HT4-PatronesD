/*
 * Autores:
 *		Jennifer Barillas -15307
 *		Davis Alvarez - 15842
 */

package org.uvg.calculadora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.uvg.stack.Stack;
import org.uvg.stack.StackArrayList;

public class Calculadora {
	
	private ArrayList<String[]> expresiones;
	private Stack<String> stackOperandos;
	
	public Calculadora(){
		expresiones = new ArrayList<String[]>();
		stackOperandos = new StackArrayList<String>();
	}
	
	public void lectorArchivo(){
		File datos;
		FileReader datosLeidos=null;
		BufferedReader br;
		try{
			datos = new File ("./datos.txt");
			datosLeidos = new FileReader (datos);
			br = new BufferedReader(datosLeidos);
			
			String linea;
			while((linea=br.readLine())!=null){
            		String [] expresionDividida = linea.split(" ");
	            	expresiones.add(expresionDividida);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{                    
            if( null != datosLeidos ){   
            	datosLeidos.close();     
            }                  
         }catch (Exception e){ 
            e.printStackTrace();
         }
	}
	
	public void realizaOperaciones(){
		int ln = 1;
		for(String[] linea: expresiones){//
			//this.ingresarDatosAlStack(ln);
			
			for(String e:linea){
				
				try{
					Integer.parseInt(e);	
					stackOperandos.push(e);
				}catch(Exception ex){
					//System.out.println("NO ES UN NUMERO!");
					stackOperandos.push(e);
					//System.out.println(this.operarElementos());
					stackOperandos.push(""+this.operarElementos()+"");
				}	
			}
			System.out.println("El resultado de la linea #"+ln+" es: "+stackOperandos.pop()+"");
			ln++;
		}
	}
	
	public int operarElementos(){
		
		String operacion = stackOperandos.pop();
		int n2= Integer.parseInt(stackOperandos.pop());
		int n1= Integer.parseInt(stackOperandos.pop());
		switch(operacion){
			case "+":
				return n1+n2;
			case "-":
				return n1-n2;
			case "/":
				return n1/n2;
			case "*":
				return n1*n2;
			default:
				return 0;
		}
	}
	
}
