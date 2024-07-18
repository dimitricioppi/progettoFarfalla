/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Super;

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
public class SuperGraphicsComponent implements GraphicsComponent{

    private int time;
    
    private final  ImageIcon super1;
    private final  Image  superImage1;
    private final  JLabel superLabel1;
    
    private final  ImageIcon super2;
    private final  Image  superImage2;
    private final  JLabel superLabel2;
    
    private final  ImageIcon super3;
    private final  Image  superImage3;
    private final  JLabel superLabel3;
    
    private final  ImageIcon super4;
    private final  Image  superImage4;
    private final  JLabel superLabel4;
    
    private final  ImageIcon super5;
    private final  Image  superImage5;
    private final  JLabel superLabel5;
    
    private final  ImageIcon super6;
    private final  Image  superImage6;
    private final  JLabel superLabel6;
    
    private final  ImageIcon super7;
    private final  Image  superImage7;
    private final  JLabel superLabel7;
    
    private final  ImageIcon super8;
    private final  Image  superImage8;
    private final  JLabel superLabel8;
      
    public SuperGraphicsComponent(){
        
        this.time = 0;
    
        this.super1 = new ImageIcon(getClass().getResource("superFrame1.png"));
        this.superLabel1 = new JLabel(this.super1);
        this.superImage1 = this.super1.getImage();
        
        this.super2 = new ImageIcon(getClass().getResource("superFrame2.png"));
        this.superLabel2 = new JLabel(this.super2);
        this.superImage2 = this.super2.getImage();
        
        this.super3 = new ImageIcon(getClass().getResource("superFrame3.png"));
        this.superLabel3 = new JLabel(this.super3);
        this.superImage3 = this.super3.getImage();
        
        this.super4 = new ImageIcon(getClass().getResource("superFrame4.png"));
        this.superLabel4 = new JLabel(this.super4);
        this.superImage4 = this.super4.getImage();
        
        this.super5 = new ImageIcon(getClass().getResource("superFrame5.png"));
        this.superLabel5 = new JLabel(this.super5);
        this.superImage5 = this.super5.getImage();
        
        this.super6 = new ImageIcon(getClass().getResource("superFrame6.png"));
        this.superLabel6 = new JLabel(this.super6);
        this.superImage6 = this.super6.getImage();
        
        this.super7 = new ImageIcon(getClass().getResource("superFrame7.png"));
        this.superLabel7 = new JLabel(this.super7);
        this.superImage7 = this.super7.getImage();
        
        this.super8 = new ImageIcon(getClass().getResource("superFrame8.png"));
        this.superLabel8 = new JLabel(this.super8);
        this.superImage8 = this.super8.getImage();        
    }

    @Override
    public void update(GameObject obj, SwingGraphics g) {
        
        g.drawSuper(obj, time);

        if(this.time < 23 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
    
    public Image getImage(int frame){
        
        Image sel = null;
    
        switch (frame) {
            
            case 0  -> sel = this.superImage1;
            case 1  -> sel = this.superImage1;
            case 2  -> sel = this.superImage2;
            case 3  -> sel = this.superImage2;
            case 4  -> sel = this.superImage3;
            case 5  -> sel = this.superImage3;
            case 6  -> sel = this.superImage4;
            case 7  -> sel = this.superImage4;
            case 8  -> sel = this.superImage5;
            case 9  -> sel = this.superImage5;
            case 10 -> sel = this.superImage6;
            case 11 -> sel = this.superImage6;
            case 12 -> sel = this.superImage7;
            case 13 -> sel = this.superImage7;
            case 14 -> sel = this.superImage8;
            case 15 -> sel = this.superImage8;
            case 16 -> sel = this.superImage8;
            case 17 -> sel = this.superImage8;
            case 18 -> sel = this.superImage8;
            case 19 -> sel = this.superImage8;
            case 20 -> sel = this.superImage8;
            case 21 -> sel = this.superImage8;
            case 22 -> sel = this.superImage8;
            case 23 -> sel = this.superImage8;
            
            default -> {}
        }
    
        return sel;
    }
    
    public JLabel getLabel(int frame){
        
        JLabel sel = null;
    
        switch (frame) {
            case 0  -> sel = this.superLabel1;
            case 1  -> sel = this.superLabel1;
            case 2  -> sel = this.superLabel2;
            case 3  -> sel = this.superLabel2;
            case 4  -> sel = this.superLabel3;
            case 5  -> sel = this.superLabel3;
            case 6  -> sel = this.superLabel4;
            case 7  -> sel = this.superLabel4;
            case 8  -> sel = this.superLabel5;
            case 9  -> sel = this.superLabel5;
            case 10 -> sel = this.superLabel6;
            case 11 -> sel = this.superLabel6;
            case 12 -> sel = this.superLabel7;
            case 13 -> sel = this.superLabel7;
            case 14 -> sel = this.superLabel8;
            case 15 -> sel = this.superLabel8;
            case 16 -> sel = this.superLabel8;
            case 17 -> sel = this.superLabel8;
            case 18 -> sel = this.superLabel8;
            case 19 -> sel = this.superLabel8;
            case 20 -> sel = this.superLabel8;
            case 21 -> sel = this.superLabel8;
            case 22 -> sel = this.superLabel8;
            case 23 -> sel = this.superLabel8;
            
            default -> {}
        }
    
        return sel;
    }   
}
