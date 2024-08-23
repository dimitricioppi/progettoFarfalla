/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Inputs;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Game.Player;

public abstract class AbstractPlayerInputComponent implements InputComponent {

    private final Player player;

    public AbstractPlayerInputComponent(Player player) {
        
        this.player = player;
    }

    public Player getPlayer() {
        
        return player;
    }
	
}
