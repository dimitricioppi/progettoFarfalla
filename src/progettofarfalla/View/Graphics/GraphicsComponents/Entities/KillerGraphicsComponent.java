/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.Entities;

import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;
import progettofarfalla.View.Graphics.SwingGraphics;

/**
 *
 * @author Daniela
 */
public class KillerGraphicsComponent implements GraphicsComponent {

    boolean pulse = true;
    
    @Override
    public void update(GameObject obj, SwingGraphics g) {

        g.drawKiller(obj, pulse);

        pulse = !pulse;               
    }       
}
