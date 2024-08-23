/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Curse;

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
public class CurseGraphicsComponent implements GraphicsComponent {
    
    private int time;
   
    private final  ImageIcon curse1;
    private final  Image  curseImage1;
    private final  JLabel curseLabel1;
    
    private final  ImageIcon curse2;
    private final  Image  curseImage2;
    private final  JLabel curseLabel2;
    
    private final  ImageIcon curse3;
    private final  Image  curseImage3;
    private final  JLabel curseLabel3;
    
    private final  ImageIcon curse4;
    private final  Image  curseImage4;
    private final  JLabel curseLabel4;
    
    private final  ImageIcon curse5;
    private final  Image  curseImage5;
    private final  JLabel curseLabel5;
    
    private final  ImageIcon curse6;
    private final  Image  curseImage6;
    private final  JLabel curseLabel6;
    
    private final  ImageIcon curse7;
    private final  Image  curseImage7;
    private final  JLabel curseLabel7;
    
    private final  ImageIcon curse8;
    private final  Image  curseImage8;
    private final  JLabel curseLabel8;
       
    public CurseGraphicsComponent(){
        
        this.time = 0;
    
        this.curse1 = new ImageIcon(getClass().getResource("curseFrame1.png"));
        this.curseLabel1 = new JLabel(this.curse1);
        this.curseImage1 = this.curse1.getImage();
        
        this.curse2 = new ImageIcon(getClass().getResource("curseFrame2.png"));
        this.curseLabel2 = new JLabel(this.curse2);
        this.curseImage2 = this.curse2.getImage();
        
        this.curse3 = new ImageIcon(getClass().getResource("curseFrame3.png"));
        this.curseLabel3 = new JLabel(this.curse3);
        this.curseImage3 = this.curse3.getImage();
        
        this.curse4 = new ImageIcon(getClass().getResource("curseFrame4.png"));
        this.curseLabel4 = new JLabel(this.curse4);
        this.curseImage4 = this.curse4.getImage();
        
        this.curse5 = new ImageIcon(getClass().getResource("curseFrame5.png"));
        this.curseLabel5 = new JLabel(this.curse5);
        this.curseImage5 = this.curse5.getImage();
        
        this.curse6 = new ImageIcon(getClass().getResource("curseFrame6.png"));
        this.curseLabel6 = new JLabel(this.curse6);
        this.curseImage6 = this.curse6.getImage();
        
        this.curse7 = new ImageIcon(getClass().getResource("curseFrame7.png"));
        this.curseLabel7 = new JLabel(this.curse7);
        this.curseImage7 = this.curse7.getImage();
        
        this.curse8 = new ImageIcon(getClass().getResource("curseFrame8.png"));
        this.curseLabel8 = new JLabel(this.curse8);
        this.curseImage8 = this.curse8.getImage();      
    }

    @Override
    public void update(GameObject obj, SwingGraphics g) {
        
        g.drawCurse(obj, time);

        if(this.time < 23 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
    
    public Image getImage(int frame){
        
        Image sel = null;
    
        switch (frame) {
            
            case 0  -> sel = this.curseImage1;
            case 1  -> sel = this.curseImage1;
            case 2  -> sel = this.curseImage2;
            case 3  -> sel = this.curseImage2;
            case 4  -> sel = this.curseImage3;
            case 5  -> sel = this.curseImage3;
            case 6  -> sel = this.curseImage4;
            case 7  -> sel = this.curseImage4;
            case 8  -> sel = this.curseImage5;
            case 9  -> sel = this.curseImage5;
            case 10 -> sel = this.curseImage6;
            case 11 -> sel = this.curseImage6;
            case 12 -> sel = this.curseImage7;
            case 13 -> sel = this.curseImage7;
            case 14 -> sel = this.curseImage8;
            case 15 -> sel = this.curseImage8;
            case 16 -> sel = this.curseImage8;
            case 17 -> sel = this.curseImage8;
            case 18 -> sel = this.curseImage8;
            case 19 -> sel = this.curseImage8;
            case 20 -> sel = this.curseImage8;
            case 21 -> sel = this.curseImage8;
            case 22 -> sel = this.curseImage8;
            case 23 -> sel = this.curseImage8;
            
            default -> {}
        }
    
        return sel;
    }
    
    public JLabel getLabel(int frame){
        
        JLabel sel = null;
    
        switch (frame) {
            case 0  -> sel = this.curseLabel1;
            case 1  -> sel = this.curseLabel1;
            case 2  -> sel = this.curseLabel2;
            case 3  -> sel = this.curseLabel2;
            case 4  -> sel = this.curseLabel3;
            case 5  -> sel = this.curseLabel3;
            case 6  -> sel = this.curseLabel4;
            case 7  -> sel = this.curseLabel4;
            case 8  -> sel = this.curseLabel5;
            case 9  -> sel = this.curseLabel5;
            case 10 -> sel = this.curseLabel6;
            case 11 -> sel = this.curseLabel6;
            case 12 -> sel = this.curseLabel7;
            case 13 -> sel = this.curseLabel7;
            case 14 -> sel = this.curseLabel8;
            case 15 -> sel = this.curseLabel8;
            case 16 -> sel = this.curseLabel8;
            case 17 -> sel = this.curseLabel8;
            case 18 -> sel = this.curseLabel8;
            case 19 -> sel = this.curseLabel8;
            case 20 -> sel = this.curseLabel8;
            case 21 -> sel = this.curseLabel8;
            case 22 -> sel = this.curseLabel8;
            case 23 -> sel = this.curseLabel8;
            
            default -> {}
        }
        
        return sel;
    } 
}
