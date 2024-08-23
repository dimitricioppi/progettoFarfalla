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
import progettofarfalla.Model.Game.GameObjects.Entity;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.Model.World.Events.*;
import progettofarfalla.Model.World.World;

public class EntityPhysicsComponent extends PhysicsComponent {

    @Override
    public void update(long dt, GameObject obj, World w) {

        super.update(dt, obj, w);

        //w.checkBoundaries(obj);
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
        
        Entity entity = (Entity) obj;

        Optional<GameObject> kill = w.checkCollisionWithEnemy(entity.getCurrentPos(), bbox);

        if (kill.isPresent() && entity.getType() == Entity.Type.BAT_KILLER){

            w.notifyWorldEvent(new KillEnemyEvent(obj,kill.get()));
        }
        
        Optional<GameObject> pick = w.checkCollisionWithPickUpObj(obj.getCurrentPos(), bbox);
        if (pick.isPresent() && entity.getType() == Entity.Type.BUTTERFLY){

            w.notifyWorldEvent(new HitPickUpEvent(obj,pick.get()));
        }

        Optional<GameObject> hit = w.checkCollisionWithEnemy(obj.getCurrentPos(), bbox);
        if (hit.isPresent() && entity.getType() == Entity.Type.BUTTERFLY){


            w.notifyWorldEvent(new HitEnemyEvent(obj,hit.get()));
        }
    }
}