/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Bounds;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Commons.P2d;

public class RectBoundingBox implements BoundingBox {

	private final P2d p0,p1;
	
	public RectBoundingBox(P2d p0, P2d p1){
		this.p0 = p0;
		this.p1 = p1;
	}
        
        public RectBoundingBox(P2d p0, double h, double b){
                   
            // p0 = up-left corner 
            // p1 = down-right corner
            this.p0 = p0;
            this.p1 = new P2d(p0.getX()+b,p0.getY()-h);        
        }
	
	public P2d getULCorner(){
            
            return p0;
	}
	
	public P2d getBRCorner(){
            
            return p1;
	}
	
        @Override
	public boolean isCollidingWith(P2d p, double radius){
            
            assert(false);
            return false;
	}
}
