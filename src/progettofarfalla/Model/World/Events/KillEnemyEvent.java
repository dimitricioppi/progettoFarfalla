/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World.Events;

import progettofarfalla.Model.Game.GameObjects.GameObject;

/**
 *
 * @author Daniela
 */
public class KillEnemyEvent implements WorldEvent {

    private final GameObject obj;
    private final GameObject killer;

    public KillEnemyEvent(GameObject k, GameObject enemy){
        
        killer = k;
        this.obj = enemy;
    }

    public GameObject getCollisionObj(){
            return obj;
    }

    @Override
    public GameObject getSelf() {

        return killer;
    }
}
