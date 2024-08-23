/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Inputs;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.Commons.*;

public class RedBatInputComponent implements InputComponent {

    private GameObject target;
    private V2d targetVel;

    public RedBatInputComponent(GameObject t){

        target = t;
        this.targetVel = new V2d(0,0);
    }

    public RedBatInputComponent(){}

    @Override
    public void update(GameObject bat){


        this.targetVel.targetDirection(bat.getCurrentPos(), target.getCurrentPos());

        bat.setVel(this.targetVel);

    }

    public GameObject getTarget(){

        return this.target;
    }

        
}
