/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Controllers;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Game.GameEngine;

public class MouseImputController {
    
    
    private final GameEngine engine;
    
    public MouseImputController(GameEngine e){
    
        this.engine = e;
    }
    
    public void notifyMouseClicked(int imput){
    
        switch (imput) {
            case 0 -> {
                this.engine.getGameState().setPlay(false);
                this.engine.getGameState().setHelp(false);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(false);
                this.engine.getGameState().exiting();
            }
            case 1 -> {
                this.engine.getGameState().setPlay(false);
                this.engine.getGameState().setHelp(false);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(true);
            }
            case 2 -> {
                this.engine.getGameState().setPlay(true);
                this.engine.getGameState().setHelp(false);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(false);
            }
            case 3 -> {
                this.engine.getGameState().setPlay(false);
                this.engine.getGameState().setHelp(true);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(false);
            }
            default -> {
            }
        }
    
    
    }
    
    
    
}
