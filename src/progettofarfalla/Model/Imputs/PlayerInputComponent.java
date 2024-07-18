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

public class PlayerInputComponent extends AbstractPlayerInputComponent {

    public PlayerInputComponent(Player player) {
        
            super(player);
    }

    @Override
    public void update(GameObject ball){

        InputController ctrl = getPlayer().getController();
        if (ctrl.isMoveUp()){
            double speed = ball.getCurrentVel().module();
            ball.setVel(new V2d(0,1).mul(speed));
        } else if (ctrl.isMoveDown()){
            double speed = ball.getCurrentVel().module();
            ball.setVel(new V2d(0,-1).mul(speed));
        } else if (ctrl.isMoveLeft()){
            double speed = ball.getCurrentVel().module();
            ball.setVel(new V2d(-1,0).mul(speed));			
        } else if (ctrl.isMoveRight()){
            double speed = ball.getCurrentVel().module();
            ball.setVel(new V2d(1,0).mul(speed));			
        }
    }
}
