/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Inputs;

import progettofarfalla.Commons.V2d;
import progettofarfalla.Model.Game.GameObjects.GameObject;

/**
 *
 * @author Daniela
 */
public class KillerInputComponent extends RedBatInputComponent {

    private final GameObject target;
    private final V2d targetVel;
    boolean aliveTarget;

    public KillerInputComponent(GameObject t){

        target = t;
        this.targetVel = new V2d(0,0);
    }

    @Override
    public void update(GameObject killer){

        if(target.getCurrentVel().module() != 0){

            this.targetVel.targetDirection(killer.getCurrentPos(), target.getCurrentPos());

            killer.setVel(this.targetVel);

        } 
    } 
}
