/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Imputs;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Commons.*;
import progettofarfalla.Model.Game.GameObjects.GameObject;

public class DragonflyInputComponent implements InputComponent {

    private long lastChoiceTime;
    private final V2d randDir;

    public DragonflyInputComponent(){
       
        lastChoiceTime = 0;
        this.randDir = new V2d(0,0);
    }

    @Override
    public void update(GameObject bat){

        if(lastChoiceTime % 20 == 0){

            this.randDir.randomDirection();
            bat.setVel(this.randDir);
        }
        
        this.lastChoiceTime++;
    }
}

