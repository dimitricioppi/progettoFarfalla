/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Physics;

/**
 *
 * @author Daniela
 */
import java.util.Optional;

import progettofarfalla.Commons.P2d;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.Model.World.Events.*;
import progettofarfalla.Model.World.World;

public class ButterflyPhysicsComponent extends PhysicsComponent {
    
    @Override
    public void update(long dt, GameObject obj, World w) {

        super.update(dt, obj, w);
        CircleBoundingBox bbox = (CircleBoundingBox) obj.getBBox();
        
        Optional<BoundaryCollision> binfo = w.checkCollisionWithBoundaries(obj.getCurrentPos(), bbox);
        if (binfo.isPresent()){
            
            BoundaryCollision info = binfo.get();
            P2d pos = obj.getCurrentPos();

            switch (info.getEdge()){

            case TOP -> {
                obj.setPos(new P2d(pos.getX(), info.getWhere().getY() - bbox.getRadius()));
                obj.flipVelOnY();
                w.notifyWorldEvent(new HitBorderEvent(obj,info.getWhere()));
            }
            case BOTTOM -> {

                obj.setPos(new P2d(pos.getX(), info.getWhere().getY() + bbox.getRadius()));
                obj.flipVelOnY();
                w.notifyWorldEvent(new HitBorderEvent(obj,info.getWhere()));
            }
            case LEFT -> {

                obj.setPos(new P2d(info.getWhere().getX() + bbox.getRadius(), pos.getY()));
                obj.flipVelOnX();
                w.notifyWorldEvent(new HitBorderEvent(obj,info.getWhere()));
            }
            case RIGHT -> {

                obj.setPos(new P2d(info.getWhere().getX() - bbox.getRadius(), pos.getY()));
                obj.flipVelOnX();
                w.notifyWorldEvent(new HitBorderEvent(obj,info.getWhere()));
            }
            }
        }

        Optional<GameObject> pick = w.checkCollisionWithPickUpObj(obj.getCurrentPos(), bbox);
        if (pick.isPresent()){

            w.notifyWorldEvent(new HitPickUpEvent(obj,pick.get()));
        }

        Optional<GameObject> hit = w.checkCollisionWithEnemy(obj.getCurrentPos(), bbox);
        if (hit.isPresent()){


            w.notifyWorldEvent(new HitBatEvent(obj,hit.get()));
        }
    }
}
