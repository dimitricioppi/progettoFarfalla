/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package progettofarfalla.Model.World.Bounds;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Commons.P2d;

public interface BoundingBox {

    boolean isCollidingWith(P2d p, double radius);
	
}
