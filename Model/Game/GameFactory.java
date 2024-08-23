/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Inputs.PlayerInputComponentWithAcc;
import progettofarfalla.Model.Inputs.NullInputComponent;
import progettofarfalla.Model.Inputs.InputComponent;
import progettofarfalla.Model.Game.GameObjects.Button;
import progettofarfalla.Model.Game.GameObjects.Summoning;
import progettofarfalla.View.Graphics.GraphicsComponents.Entities.KillerGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.SummoningGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.Entities.Butterfly.ButterflyGraphicsComponent;
import progettofarfalla.Commons.*;
import progettofarfalla.Model.Game.GameObjects.*;
import progettofarfalla.Model.World.Physics.*;
import static progettofarfalla.Model.Game.GameObjects.Entity.Type.*;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.Model.World.World;
import progettofarfalla.View.Graphics.GraphicsComponents.ButtonGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;


public class GameFactory {

    public static Entity createButterfly(P2d pos, double radius, V2d vel, Player player){
        
        return new Entity(Entity.Type.BUTTERFLY, pos, vel, new CircleBoundingBox(new P2d(pos.getX(), pos.getY()), radius),
                        new PlayerInputComponentWithAcc(player),
                        new ButterflyGraphicsComponent(),
                        new EntityPhysicsComponent(),
                        radius);
    }

    public static Entity createEnemy(Entity.Type t,P2d pos, double radius, V2d vel, InputComponent input, GraphicsComponent graph){
        
        return new Entity(t, pos, vel, new CircleBoundingBox(new P2d(pos.getX(), pos.getY()), radius),
                        input,
                        graph,
                        new EntityPhysicsComponent(), radius);

    }

    public static PickUp createPickUpObject(PickUp.Type t,P2d pos, double edge, GraphicsComponent graph){

        return new PickUp(t, pos, new V2d(0,0), new CircleBoundingBox(new P2d(pos.getX(), pos.getY()), edge/2),
                    new NullInputComponent(),
                    graph,
                    new NullPhysicsComponent(), edge/2);
    }

    public static Summoning createSummoning(P2d pos, double radius, Entity.Type type, World world){
        
        return new Summoning(pos, new V2d(0,0), new CircleBoundingBox(new P2d(pos.getX(), pos.getY()), radius),
                        new NullInputComponent(),
                        new SummoningGraphicsComponent(),
                        new NullPhysicsComponent(), radius,
                        type, world);

    }

    public static Entity createKiller(P2d pos, double radius, V2d vel, InputComponent input){
        
        return new Entity(BAT_KILLER, pos, vel, new CircleBoundingBox(new P2d(pos.getX(), pos.getY()), radius),
                        input,
                        new KillerGraphicsComponent(),
                        new EntityPhysicsComponent(), radius);

    }

    public static Button createButton(P2d pos, double height, double base, Button.Type type, GameEngine engine){

        return new Button(type, pos, new NullInputComponent(),
                        new ButtonGraphicsComponent() ,
                        new NullPhysicsComponent(),
                        base, height, engine);
    }
}
