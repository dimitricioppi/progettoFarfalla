/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents;

import progettofarfalla.Model.Game.GameObjects.Button;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.View.Graphics.SwingGraphics;

/**
 *
 * @author Daniela
 */
public class ButtonGraphicsComponent implements GraphicsComponent{

    
    @Override
    public void update(GameObject obj, SwingGraphics g) {
        
        g.drawButton((Button) obj);
        
    }   
}
