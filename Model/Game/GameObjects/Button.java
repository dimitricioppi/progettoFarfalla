/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game.GameObjects;

import progettofarfalla.Commons.P2d;
import progettofarfalla.Commons.V2d;
import progettofarfalla.Model.Inputs.InputComponent;
import progettofarfalla.Model.Game.GameEngine;
import progettofarfalla.Model.World.Bounds.BoundingBox;
import progettofarfalla.Model.World.Physics.PhysicsComponent;
import progettofarfalla.Model.World.World;
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;
import progettofarfalla.View.Graphics.SwingGraphics;
import progettofarfalla.View.Listeners.ButtonListenerPanel;

/**
 *
 * @author Daniela
 */
public class Button implements GameObject{


    public static enum Type { EXIT, MENU, HELP, START }
    
    private final Type type;
    private P2d pos;
    private V2d vel;
    private final BoundingBox bbox;
    private final ButtonListenerPanel panel;

    private final InputComponent input;
    private final GraphicsComponent graph;
    private final PhysicsComponent phys;

    private final double base;
    private final double height;
    
    private boolean selected;
    
    private final GameEngine engine;

    public Button(Type type, P2d pos, InputComponent input,
                  GraphicsComponent graph, PhysicsComponent phys, double b, double h, GameEngine e){
       
        this.type = type;
        this.pos = pos;
        this.vel = new V2d(0,0);
        this.input = input;
        this.graph = graph;
        this.phys = phys;
        this.base = b;
        this.height = h;
        this.engine = e;
        this.panel = new ButtonListenerPanel(pos, (int) base, (int) height, this, engine);
        this.selected = false;
        this.bbox = null;
        
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
    public void setBBox(P2d pos) {}

    @Override
    public BoundingBox getBBox(){
        return this.bbox;
    }

    @Override
    public P2d getCurrentPos(){
            return pos;
    }

    @Override
    public V2d getCurrentVel(){
            return vel;
    }
        
    public double getHeight(){
    
        return this.height;
    
    }
    
    public double getBase(){
    
        return this.base;
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
    
    public ButtonListenerPanel getPanel(){
    
        return this.panel;
    }
    
    public boolean getSelected(){
    
        return this.selected;
    }
    
    public void setSelected(boolean s){
    
        this.selected = s;
    }
}
