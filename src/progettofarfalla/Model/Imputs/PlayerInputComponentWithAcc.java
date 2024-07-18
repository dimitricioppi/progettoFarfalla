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
import progettofarfalla.Controllers.ImputControllers.InputController;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.Model.Game.Player;

public class PlayerInputComponentWithAcc extends AbstractPlayerInputComponent {
	
    public PlayerInputComponentWithAcc(Player player) {
        super(player);
    }

    @Override
    public void update(GameObject entity){
        
        InputController ctrl = this.getPlayer().getController();
        V2d vel = entity.getCurrentVel();

        if (ctrl.isMoveUp() && vel.getY() < 12  && !ctrl.isMoveDown()){

            entity.setVel(vel.sum(new V2d(0,1)));

        } else if (ctrl.isMoveDown() && vel.getY() > -12 && !ctrl.isMoveUp()){

            entity.setVel(vel.sum(new V2d(0,-1)));

        } else if (ctrl.isMoveLeft() && vel.getX() > -12 && !ctrl.isMoveRight()){

            entity.setVel(vel.sum(new V2d(-1,0)));

        } else if (ctrl.isMoveRight() && vel.getX() < 12 && !ctrl.isMoveLeft()){

            entity.setVel(vel.sum(new V2d(1,0)));

        } else if (ctrl.isNull() && vel.module() > 0 && vel.module() !=0 ){

            entity.setVel(vel.slowDown(vel));

        } 
    }
}
