/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Physics;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Commons.*;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.Model.World.World;

public abstract class PhysicsComponent {

    public void update(long dt, GameObject obj, World w){

        P2d pos = obj.getCurrentPos();
        V2d vel = obj.getCurrentVel();
        obj.setPos(pos.sum(vel.mul(0.001*dt)));
        obj.setBBox(pos);
    }
}
