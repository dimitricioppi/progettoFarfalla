/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.View.Graphics.SwingGraphics;

public class SummoningGraphicsComponent implements GraphicsComponent {

    private int time;
        
    @Override
    public void update(GameObject obj, SwingGraphics g) {

 
        g.drawSummoningBall(obj, this.time);
        
        if(this.time < 6 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
}
