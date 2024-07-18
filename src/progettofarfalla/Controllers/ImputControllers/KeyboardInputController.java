/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Controllers.ImputControllers;

/**
 *
 * @author Daniela
 */
public class KeyboardInputController implements InputController {

    private final int keyCodeMoveUp;
    private final int keyCodeMoveDown;
    private final int keyCodeMoveLeft;
    private final int keyCodeMoveRight;

    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isMoveLeft;
    private boolean isMoveRight;
    private boolean isNull;
       
	
    public KeyboardInputController(int keyCodeMoveUp, int keyCodeMoveDown, int keyCodeMoveLeft, int keyCodeMoveRight) {
        
        this.keyCodeMoveUp = keyCodeMoveUp;
        this.keyCodeMoveDown = keyCodeMoveDown;
        this.keyCodeMoveLeft = keyCodeMoveLeft;
        this.keyCodeMoveRight = keyCodeMoveRight;

    }

    @Override
    public boolean isMoveUp() {
        
        return isMoveUp;
    }

    @Override
    public boolean isMoveDown() {
        
        return isMoveDown;
    }

    @Override
    public boolean isMoveLeft() {
        
        return isMoveLeft;
    }

    @Override
    public boolean isMoveRight() {
        
        return isMoveRight;
    }

    @Override
    public boolean isNull(){

        return this.isNull;
    }



    public void notifyKeyPressed(int keyCode) {
        
        if (keyCode == keyCodeMoveUp){

            isMoveUp = true;
            this.isNull = false;

        } else if (keyCode == keyCodeMoveDown){

            isMoveDown = true;
            this.isNull = false;

        } else if (keyCode == keyCodeMoveRight){

            isMoveRight = true;
            this.isNull = false;

        } else if (keyCode == keyCodeMoveLeft){

            isMoveLeft = true;
            this.isNull = false;

        }		
    }

    public void notifyKeyReleased(int keyCode) {
        
        if (keyCode == keyCodeMoveUp){

            isMoveUp = false;  

        } else if (keyCode == keyCodeMoveDown){

            isMoveDown = false;

        } else if (keyCode == keyCodeMoveRight){

            isMoveRight = false;

        } else if (keyCode == keyCodeMoveLeft){

            isMoveLeft = false;

        }

        if (isMoveUp == false && isMoveDown == false && isMoveRight == false && isMoveLeft == false){

            this.isNull = true;
        }
    }
	
}
