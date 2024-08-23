/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Commons;


import java.util.Random;
/**
 *
 * @author Daniela
 */
public class RandomGenerator {
    
    
    public static double RandomBoundedN(double low, double high){
        
        Random rand = new Random();
       
        return rand.nextDouble(low, high);    
    }
    
    public static boolean RandomBoolean(){
        
        Random rand = new Random();
    
        return rand.nextBoolean();
    
    }
    
}
