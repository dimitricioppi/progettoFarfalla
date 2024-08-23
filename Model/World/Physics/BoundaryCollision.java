/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Physics;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Commons.P2d;

public class BoundaryCollision {

    public enum CollisionEdge { TOP, BOTTOM, LEFT, RIGHT }
    private final CollisionEdge edge;
    private final P2d where;

    public BoundaryCollision(CollisionEdge edge, P2d where){

        this.edge = edge; 
        this.where = where;
    }

    public CollisionEdge getEdge(){

        return edge;
    }

    public P2d getWhere(){

        return where;
    }
}
