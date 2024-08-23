/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Life;

/**
 *
 * @author Daniela
 */

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;
import progettofarfalla.View.Graphics.SwingGraphics;

public class LifeGraphicsComponent implements GraphicsComponent {
    
    private int time;

    
    private final  ImageIcon life1;
    private final  Image  lifeImage1;
    private final  JLabel lifeLabel1;
    
    private final  ImageIcon life2;
    private final  Image  lifeImage2;
    private final  JLabel lifeLabel2;
    
    private final  ImageIcon life3;
    private final  Image  lifeImage3;
    private final  JLabel lifeLabel3;
    
    
   
    public LifeGraphicsComponent(){
        
        this.time = 0;
    
        this.life1 = new ImageIcon(getClass().getResource("lifeFrame1.png"));
        this.lifeLabel1 = new JLabel(this.life1);
        this.lifeImage1 = this.life1.getImage();
        
        this.life2 = new ImageIcon(getClass().getResource("lifeFrame2.png"));
        this.lifeLabel2 = new JLabel(this.life2);
        this.lifeImage2 = this.life2.getImage();
        
        this.life3 = new ImageIcon(getClass().getResource("lifeFrame3.png"));
        this.lifeLabel3 = new JLabel(this.life3);
        this.lifeImage3 = this.life3.getImage();  
    }

    @Override
    public void update(GameObject obj, SwingGraphics g) {
        /*
         * @TODO
         * select the proper sprite according to the ball state... 
         */
        g.drawLife(obj, time);

        if(this.time < 23 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
    
    public Image getImage(int frame){
        
        Image sel = null;
    
        switch (frame) {
            
            case 0  -> sel = this.lifeImage1;
            case 1  -> sel = this.lifeImage1;
            case 2  -> sel = this.lifeImage1;
            case 3  -> sel = this.lifeImage1;
            case 4  -> sel = this.lifeImage1;
            case 5  -> sel = this.lifeImage1;
            case 6  -> sel = this.lifeImage1;
            case 7  -> sel = this.lifeImage1;
            case 8  -> sel = this.lifeImage1;
            case 9  -> sel = this.lifeImage1;
            case 10 -> sel = this.lifeImage2;
            case 11 -> sel = this.lifeImage2;
            case 12 -> sel = this.lifeImage3;
            case 13 -> sel = this.lifeImage3;
            case 14 -> sel = this.lifeImage3;
            case 15 -> sel = this.lifeImage3;
            case 16 -> sel = this.lifeImage3;
            case 17 -> sel = this.lifeImage3;
            case 18 -> sel = this.lifeImage3;
            case 19 -> sel = this.lifeImage3;
            case 20 -> sel = this.lifeImage3;
            case 21 -> sel = this.lifeImage3;
            case 22 -> sel = this.lifeImage2;
            case 23 -> sel = this.lifeImage2;
            
            default -> {}
        }
    
        return sel;
    }
    
    public JLabel getLabel(int frame){
        
        JLabel sel = null;
    
        switch (frame) {
            case 0  -> sel = this.lifeLabel1;
            case 1  -> sel = this.lifeLabel1;
            case 2  -> sel = this.lifeLabel1;
            case 3  -> sel = this.lifeLabel1;
            case 4  -> sel = this.lifeLabel1;
            case 5  -> sel = this.lifeLabel1;
            case 6  -> sel = this.lifeLabel1;
            case 7  -> sel = this.lifeLabel1;
            case 8  -> sel = this.lifeLabel1;
            case 9  -> sel = this.lifeLabel1;
            case 10 -> sel = this.lifeLabel2;
            case 11 -> sel = this.lifeLabel2;
            case 12 -> sel = this.lifeLabel3;
            case 13 -> sel = this.lifeLabel3;
            case 14 -> sel = this.lifeLabel3;
            case 15 -> sel = this.lifeLabel3;
            case 16 -> sel = this.lifeLabel3;
            case 17 -> sel = this.lifeLabel3;
            case 18 -> sel = this.lifeLabel3;
            case 19 -> sel = this.lifeLabel3;
            case 20 -> sel = this.lifeLabel3;
            case 21 -> sel = this.lifeLabel3;
            case 22 -> sel = this.lifeLabel2;
            case 23 -> sel = this.lifeLabel2;
            
            default -> {}
        }
    
        return sel;
    }
}