/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Commons;

/**
 *
 * 2-dimensional point
 * objects are completely state-less
 *
 */

import java.awt.Point;
import java.util.Random;
import progettofarfalla.Model.World.World;

public class P2d extends Point implements java.io.Serializable {

    private  double x, y;
    private Random rand;

    public P2d(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public P2d(World w){
    
        this.rand = new Random();
        this.x = this.rand.nextDouble(w.getBBox().getULCorner().getX()+1, w.getBBox().getBRCorner().getX()-1);
        this.y = this.rand.nextDouble(w.getBBox().getBRCorner().getY()+1, w.getBBox().getULCorner().getY()-1);
    
    }

    public P2d sum(V2d v){
        return new P2d(x+v.getX(), y+v.getY());
    }

    public V2d sub(P2d v){
        return new V2d(x-v.x, y-v.y);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "P2d("+x+","+y+")";
    }
    
    @Override
    public double getX(){
    
        return this.x;
    }
    
    @Override
    public double getY(){
        
        return this.y;
    }

}