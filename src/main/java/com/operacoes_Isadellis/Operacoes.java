/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.operacoes_Isadellis;

public class Operacoes {
    private double operando1;
    private double operando2;
    
    private String operador;
    private String auxOperando1;
    private String auxOperando2;
    private String visor;
    
    public Operacoes (){
        auxOperando1 = "";
        auxOperando2 = "";
        operador = "";
        visor = "";
    }
     
    public void concatenar (String valor) {
        //Caso não haja operador definido o número sendo digitado é o primeiro
        if(operador.isEmpty()){
            auxOperando1 += valor;
            atualizarVisor();
            
        } else { //Apósa a definição do operador o número digitado é o segundo
            auxOperando2 += valor;
            atualizarVisor();
        }
    }
     
    public void atualizarVisor (){
        //Atualiza o conteúdo do visor
        if(operador.isEmpty()){ //Se o operador estiver vazio há apenas o priemeiro operando
            visor = auxOperando1;
        } else {
            visor = auxOperando1 + " " + operador + " " + auxOperando2;
        }
    }
    
    public Double realizaOperacoes () {
        //Transforma as strings dos operandos em números inteiros
        operando1 = Double.parseDouble(auxOperando1);
        operando2 = Double.parseDouble(auxOperando2);
        
        double resultado = 0;
        
        //Verifica qual o operador e faz a operação condizente
        switch (operador){
            case "+":
                resultado = somar();
                break;
             
            case "-":
                resultado = subtrair();
                break;
                
            case "/":
                resultado = dividir();
                break;
                
            case "*":
                resultado = multiplicar();
                break;
                
            case "^":
                resultado = potencia();
                break;
                
            case "%":
                resultado = porcentagem();
                break;
            case "":
                resultado = operando1;
        }
        
        apagaTudo();
        visor = String.valueOf(resultado);
        return resultado;
    }
    
    public void apagaUltimoDigito () {
       //Caso não haja operador o último dígito está no primeiro operando
        if(operador.equals(""))
            auxOperando1 = auxOperando1.substring(0, auxOperando1.length() - 1);
       
        else if (visor.charAt(visor.length()) == operador.charAt(0)) //Caso o último dígito do visor seja o operador ele será redefinido 
            operador = "";
        else //Se não for nenhum dos casos acima, então o último dígito é parte do segundo operando
            auxOperando2 = auxOperando2.substring(0, auxOperando2.length() - 1);

           
       atualizarVisor();
    }
    
    public void apagaTudo () {
        //Reseta todas as variáveis retornando-as para o estado vazio
        auxOperando1 = "";
        auxOperando2 = "";
        operador = "";
        visor = "";
       
        atualizarVisor();
    }
    
    //Operações
    private double somar(){        
        return operando1 + operando2; 
    }
    
    private double subtrair(){        
        return operando1 - operando2;
    }
    
    private double multiplicar(){
        return operando1 * operando2;
    }
    
    private double dividir(){
        return operando1 / operando2;
    }
    
    private double potencia (){     
        return  Math.pow(operando1, operando2);
    }
    
    private double porcentagem(){
        return (operando1 * 100)/operando2;
    }
    
    //Getters

    public double getOperando1() {
        return operando1;
    }

    public double getOperando2() {
        return operando2;
    }

    public String getOperador() {
        return operador;
    }

    public String getAuxOperando1() {
        return auxOperando1;
    }

    public String getAuxOperando2() {
        return auxOperando2;
    }

    public String getVisor() {
        return visor;
    }
    
    //Setters
    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }

    public void setOperador(String operador) {
        this.operador = operador;
        atualizarVisor();
    }

    public void setAuxOperando1(String auxOperando1) {
        this.auxOperando1 = auxOperando1;
    }

    public void setAuxOperando2(String auxOperando2) {
        this.auxOperando2 = auxOperando2;
    }

    public void setVisor(String visor) {
        this.visor = visor;
    }
    
    
}
