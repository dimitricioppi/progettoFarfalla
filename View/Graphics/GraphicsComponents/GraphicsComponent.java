/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.View.Graphics.SwingGraphics;

public interface GraphicsComponent {
  
    public void update(GameObject obj, SwingGraphics w);
       
}
