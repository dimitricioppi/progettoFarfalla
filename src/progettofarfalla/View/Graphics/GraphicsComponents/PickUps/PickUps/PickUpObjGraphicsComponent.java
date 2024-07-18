/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.PickUps.PickUps;

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

public class PickUpObjGraphicsComponent implements GraphicsComponent {
    
    private int time;
    private final boolean extra;
    
    private final  ImageIcon flower;
    private final  Image  flowerImage;
    private static  JLabel flowerLabel;
    
    private final  ImageIcon extraFlower;
    private final  Image  extraFlowerImage;
    private static  JLabel extraFlowerLabel;
   
    public PickUpObjGraphicsComponent(boolean extraPoints){
        
        this.time = 0;
        this.extra = extraPoints;

        this.flower = new ImageIcon(getClass().getResource("pickUpFlower.png"));
        this.flowerLabel = new JLabel(this.flower);
        this.flowerImage = this.flower.getImage();
        
        this.extraFlower = new ImageIcon(getClass().getResource("extraPointsFlower.png"));
        this.extraFlowerLabel = new JLabel(this.flower);
        this.extraFlowerImage = this.extraFlower.getImage();    
    }

    @Override
    public void update(GameObject obj, SwingGraphics w) {
                
        
        w.drawPickableObj(obj, this.time);
        time++;
    }
    
    public Image getImage(){
        
        Image sel;
        
        if(this.extra == false){
    
            sel = this.flowerImage;
            
        } else {
        
            sel = this.extraFlowerImage;
        }
        
        return sel;       
    }
    
    public JLabel getLabel(){
      
        JLabel sel;
        
        if(this.extra == false){
    
            sel = this.flowerLabel;
        } else {
        
            sel = this.extraFlowerLabel;
        }
        
        return sel;
    }
}