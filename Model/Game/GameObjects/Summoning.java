/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game.GameObjects;

import progettofarfalla.View.Graphics.SwingGraphics;
import progettofarfalla.Model.Inputs.RedBatInputComponent;
import progettofarfalla.Model.Inputs.NullInputComponent;
import progettofarfalla.Model.Inputs.InputComponent;
import progettofarfalla.Model.Inputs.DragonflyInputComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;
import progettofarfalla.Commons.P2d;
import progettofarfalla.Commons.V2d;
import progettofarfalla.Model.Game.GameFactory;
import progettofarfalla.Model.World.Bounds.BoundingBox;
import progettofarfalla.Model.World.Bounds.CircleBoundingBox;
import progettofarfalla.Model.World.Physics.PhysicsComponent;
import progettofarfalla.Model.World.World;
import progettofarfalla.View.Graphics.GraphicsComponents.Entities.Bats.BatGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.Entities.Dragonfly.DragonflyGraphicsComponent;

/**
 *
 * @author Daniela
 */
public class Summoning implements GameObject{
   

    private final long SUMMONING_TIME = 100;

    private boolean timeToSummon;
    private long time;
    private final Entity.Type summon;
    private P2d pos;
    private V2d vel;
    private BoundingBox bbox;
    private final World world;

    private final InputComponent input;
    private final GraphicsComponent graph;
    private final PhysicsComponent phys;

    private final double radius;

    public Summoning(P2d pos, V2d vel, BoundingBox box, InputComponent input,
                    GraphicsComponent graph, PhysicsComponent phys, double radius, Entity.Type t, World w){

        this.timeToSummon = false;
        this.time = 0;

        this.pos = pos;
        this.vel = vel;
        this.bbox = box;
        this.input = input;
        this.graph = graph;
        this.phys = phys;
        this.radius = radius;
        this.summon = t;
        this.world = w;
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
        this.time++;
        if(time >= this.SUMMONING_TIME){

            this.timeToSummon = true;
        }
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

    public void summonEntity(){

        if(this.summon == Entity.Type.BLACK_BAT){

            this.world.addEnemy(GameFactory.createEnemy(Entity.Type.BLACK_BAT, pos, radius, new V2d(),
                                new NullInputComponent(), new BatGraphicsComponent(false)));
        }

        if(this.summon == Entity.Type.DRAGONFLY){

            this.world.addEnemy(GameFactory.createEnemy(Entity.Type.DRAGONFLY, pos, radius, new V2d(),
                                new DragonflyInputComponent(), new DragonflyGraphicsComponent()));
        }

        if(this.summon == Entity.Type.RED_BAT){

            this.world.addEnemy(GameFactory.createEnemy(Entity.Type.RED_BAT, pos, radius, new V2d(),
                                new RedBatInputComponent(this.world.getButterfly()), new BatGraphicsComponent(true)));
        }
    }

    public boolean getTimeToSummon(){

        return this.timeToSummon;
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