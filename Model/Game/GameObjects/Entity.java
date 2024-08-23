/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game.GameObjects;

/**
 *
 * @author Daniela
 */

import progettofarfalla.View.Graphics.SwingGraphics;
import progettofarfalla.Model.Inputs.InputComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;
import progettofarfalla.Commons.*;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.Model.World.Physics.*;
import progettofarfalla.Model.World.World;


public class Entity implements GameObject{

    
    public static enum Type { BUTTERFLY, BLACK_BAT, DRAGONFLY, RED_BAT, BAT_KILLER }

    private final Type type;
    private P2d pos;
    private V2d vel;
    private BoundingBox bbox;

    private final InputComponent input;
    private final GraphicsComponent graph;
    private final PhysicsComponent phys;

    private final double radius;

    public Entity(Type type, P2d pos, V2d vel, BoundingBox box, InputComponent input,
                    GraphicsComponent graph, PhysicsComponent phys, double radius){

        this.type = type;
        this.pos = pos;
        this.vel = vel;
        this.bbox = box;
        this.input = input;
        this.graph = graph;
        this.phys = phys;
        this.radius = radius;
    }


    public Type getType(){

        return type;
    }
	
    @Override
    public void setPos(P2d pos){
            this.pos = pos;
    }

    @Override
    public void setVel(V2d vel){
            this.vel = vel;
    }

    @Override
    public void flipVelOnY(){
        this.vel = new V2d(vel.getX(), -vel.getY());
    }

    @Override
    public void flipVelOnX(){
        this.vel = new V2d(-vel.getX(), vel.getY());
    }


    @Override
    public void setBBox(P2d pos) {

        this.bbox = new CircleBoundingBox(pos, this.radius);
    }

    @Override
    public BoundingBox getBBox(){
        
        return bbox;
    }

    @Override
    public P2d getCurrentPos(){
        
        return pos;
    }

    @Override
    public V2d getCurrentVel(){
        
        return vel;
    }

    @Override
    public void updateInput(){
        
        input.update(this);
    }

    @Override
    public void updatePhysics(long dt, World w){
        
        phys.update(dt, this, w);
    }

    @Override
    public void updateGraphics(SwingGraphics g){
        
        graph.update(this, g);
    }

    @Override
    public InputComponent getInputComponent() {
        
        return this.input;
    }

    @Override
    public PhysicsComponent getPhysics(){

        return this.phys;
    }

    @Override
    public GraphicsComponent getGraphicsComponent(){

        return this.graph;
    }
        
    
    @Override
    public double getDirectionAngle(){
    
        double angle = 0;
        
        if(this.getCurrentVel().module() == 0){
        
            angle = 0;
        
        }else if(this.getCurrentVel().getX() == 0){
        
            if(this.getCurrentVel().getY() > 0){
            
                angle = 0;
            } else{
            
                angle = 180;
            }
        
        }else if(this.getCurrentVel().getY() == 0){
        
            if(this.getCurrentVel().getX() > 0){
            
                angle = 90;
            } else{
            
                angle = 270;
            }
        
        } else if(this.getCurrentVel().getX()/this.getCurrentVel().getY() > 0){
            
            if(this.getCurrentVel().getX() > 0){

                angle = Math.atan(this.getCurrentVel().getX()/this.getCurrentVel().getY());

            }else{

                angle = Math.atan(this.getCurrentVel().getX()/this.getCurrentVel().getY()) + 180;
            }
                
        } else if (this.getCurrentVel().getX()/this.getCurrentVel().getY() < 0){
        
        
            if(this.getCurrentVel().getX() > 0){
                
                angle = Math.atan(this.getCurrentVel().getX()/this.getCurrentVel().getY()) + 90;
                
            }else{

                angle = Math.atan(this.getCurrentVel().getX()/this.getCurrentVel().getY()) + 270;
            }
        }
        
        return angle;
    }    
}
