/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Bounds;

/**
 *
 * @author Daniela
 */

import progettofarfalla.Commons.*;


public class CircleBoundingBox implements BoundingBox{

	private final P2d center;
	private final double radius;
	
	public CircleBoundingBox(P2d center, double radius){
            
            this.center = center;
            this.radius = radius;
	}
	
	public double getRadius(){
            
            return radius;
	}
	
    /**
     *
     * @param p
     * @param radius
     * @return
     */
    @Override
	public boolean isCollidingWith(P2d p, double radius){
            
            return new V2d(p,center).module() <= radius+this.radius;		
	}
}
