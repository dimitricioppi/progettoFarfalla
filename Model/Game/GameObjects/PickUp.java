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

public class PickUp implements GameObject{
       
    public static enum Type { EXTRA_POINTS, PICKABLE_OBJ, LIFE, BOMB, CURSE, SUPER }

    private final Type type;
    private P2d pos;
    private V2d vel;
    private BoundingBox bbox;

    private final InputComponent input;
    private final GraphicsComponent graph;
    private final PhysicsComponent phys;

    private final double radius;

    public PickUp(Type type, P2d pos, V2d vel, BoundingBox box, InputComponent input,
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
    public void flipVelOnY(){}

    @Override
    public void flipVelOnX(){}

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
        
        return input;
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
    public double getDirectionAngle() {
        
        return 0;        
    }               
}
