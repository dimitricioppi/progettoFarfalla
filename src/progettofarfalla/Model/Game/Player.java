/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game;

import progettofarfalla.Controllers.ImputControllers.InputController;

public class Player{
	
    private int score;
    private int lives;
    private int pikUpsTaken;
    private final InputController controller;

    public Player(InputController controller) {

        this.score = 0;
        this.lives = 3;
        this.pikUpsTaken = 0;
        this.controller = controller;
    }

    public InputController getController() {
        
        return controller;
    }

    public int getScore() {
        
        return score;
    }

    public void updateScore(int delta) {
        
        score += delta;
    }

    public int getLives(){

        return this.lives;
    }

    public void updateLives(int delta){

        this.lives += delta;
    }

    public int getPickUpsTaken(){

        return this.pikUpsTaken;
    }

    public void updatePickUpsTaken(int delta){

        this.pikUpsTaken += delta;
    }
}
