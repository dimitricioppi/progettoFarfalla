/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Events;

/**
 *
 * @author Daniela
 */

import progettofarfalla.Model.Game.GameObjects.GameObject;

public class HitPickUpEvent implements WorldEvent {

    private final GameObject obj;
    private final GameObject butterfly;

    public HitPickUpEvent(GameObject b, GameObject obj){
        
        butterfly = b;
        this.obj = obj;
    }

    public GameObject getCollisionObj(){
        
        return obj;
    }

    @Override
    public GameObject getSelf() {

        return butterfly;
    }
}
