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
    
    private final Random rand;
    
    public RandomGenerator(){
    
        this.rand = new Random();
    
    }
        
    public int RandomBoundedN(int low, int high){
       
        return this.rand.nextInt(low, high);    
    }
    
    public boolean RandomBoolean(){
    
        return this.rand.nextBoolean();
    
    }
    
}
