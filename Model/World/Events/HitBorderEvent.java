/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Events;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Commons.*;
import progettofarfalla.Model.Game.GameObjects.GameObject;

public class HitBorderEvent implements WorldEvent {

    private final P2d where;
    private final GameObject self;

    public HitBorderEvent(GameObject b, P2d where){
        
        self = b;
        this.where = where;
    }

    public P2d getWhere(){
        
        return where;
    }

    @Override
    public GameObject getSelf() {

        return self;
    }
}
