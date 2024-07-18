/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Bomb;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;
import progettofarfalla.View.Graphics.SwingGraphics;

/**
 *
 * @author Daniela
 */
public class BombGraphicsComponent implements GraphicsComponent{
    
    private int time;
    
    private final  ImageIcon bomb1;
    private final  Image  bombImage1;
    private final  JLabel bombLabel1;

    private final  ImageIcon bomb2;
    private final  Image  bombImage2;
    private final  JLabel bombLabel2;
    
    public BombGraphicsComponent(){
    
        this.time = 0;
    
        this.bomb1 = new ImageIcon(getClass().getResource("bombFrame1.png"));
        this.bombLabel1 = new JLabel(this.bomb1);
        this.bombImage1 = this.bomb1.getImage();

        this.bomb2 = new ImageIcon(getClass().getResource("bombFrame2.png"));
        this.bombLabel2 = new JLabel(this.bomb2);
        this.bombImage2 = this.bomb2.getImage();

    }
    
    @Override
    public void update(GameObject obj, SwingGraphics g) {
            
        g.drawBomb(obj, time);

        if(this.time < 1 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
    
    public Image getImage(int frame){
        
        Image sel = null;
    
        switch (frame) {
            case 0 -> sel = this.bombImage1;
            case 1 -> sel = this.bombImage2;

            default -> {}
        }
    
        return sel;
    }
    
    public JLabel getLabel(int frame){
        
        JLabel sel = null;
    
        switch (frame) {
            case 0 -> sel = this.bombLabel1;
            case 1 -> sel = this.bombLabel2;
            default -> {}
        }
    
        return sel;
    }   
}
