/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.Entities.Bats;


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

public class BatGraphicsComponent implements GraphicsComponent {
      
    private int time;
    private final boolean isRed;
    
    private  ImageIcon bat1;
    private  Image  batImage1;
    private  JLabel batLabel1;

    private  ImageIcon bat2;
    private  Image  batImage2;
    private  JLabel batLabel2;

    private  ImageIcon bat3;
    private  Image  batImage3;
    private  JLabel batLabel3;

    private  ImageIcon bat4;
    private  Image  batImage4;
    private  JLabel batLabel4;
  
    private  ImageIcon redBat1;
    private  Image  redBatImage1;
    private  JLabel redBatLabel1;

    private  ImageIcon redBat2;
    private  Image  redBatImage2;
    private  JLabel redBatLabel2;

    private  ImageIcon redBat3;
    private  Image  redBatImage3;
    private  JLabel redBatLabel3;

    private  ImageIcon redBat4;
    private  Image  redBatImage4;
    private  JLabel redBatLabel4;
    
    
    public BatGraphicsComponent(boolean red){
            
        this.time = 0;
        this.isRed = red;
        
        if(isRed == false){
        
            this.bat1 = new ImageIcon(getClass().getResource("batFrame1.png"));
            this.batLabel1 = new JLabel(this.bat1);
            this.batImage1 = this.bat1.getImage();

            this.bat2 = new ImageIcon(getClass().getResource("batFrame2.png"));
            this.batLabel2 = new JLabel(this.bat2);
            this.batImage2 = this.bat2.getImage();

            this.bat3 = new ImageIcon(getClass().getResource("batFrame3.png"));
            this.batLabel3 = new JLabel(this.bat3);
            this.batImage3 = this.bat3.getImage();

            this.bat4 = new ImageIcon(getClass().getResource("batFrame4.png"));
            this.batLabel4 = new JLabel(this.bat4);
            this.batImage4 = this.bat4.getImage();
        
        } else{
    
            this.redBat1 = new ImageIcon(getClass().getResource("redBatFrame1.png"));
            this.redBatLabel1 = new JLabel(this.redBat1);
            this.redBatImage1 = this.redBat1.getImage();

            this.redBat2 = new ImageIcon(getClass().getResource("redBatFrame2.png"));
            this.redBatLabel2 = new JLabel(this.redBat2);
            this.redBatImage2 = this.redBat2.getImage();

            this.redBat3 = new ImageIcon(getClass().getResource("redBatFrame3.png"));
            this.redBatLabel3 = new JLabel(this.redBat3);
            this.redBatImage3 = this.redBat3.getImage();

            this.redBat4 = new ImageIcon(getClass().getResource("redBatFrame4.png"));
            this.redBatLabel4 = new JLabel(this.redBat4);
            this.redBatImage4 = this.redBat4.getImage();           
        }  
    }
    
    @Override
    public void update(GameObject obj, SwingGraphics g) {
        
        g.drawBat(obj, time);

        if(this.time < 5 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
    
    public Image getImage(int frame){
        
        Image sel = null;
        
        if (this.isRed == false){
        
            switch (frame) {
                case 0 -> sel = this.batImage1;
                case 1 -> sel = this.batImage2;
                case 2 -> sel = this.batImage3;
                case 3 -> sel = this.batImage4;
                default -> {}
            }
           
        } else{
    
            switch (frame) {
                case 0 -> sel = this.redBatImage1;
                case 1 -> sel = this.redBatImage2;
                case 2 -> sel = this.redBatImage3;
                case 3 -> sel = this.redBatImage4;
                default -> {}
            }
            
        }
    
        return sel;
    }
    
    public JLabel getLabel(int frame){
        
        JLabel sel = null;
    
        if (this.isRed == false){
        
            switch (frame) {
                case 0 -> sel = this.batLabel1;
                case 1 -> sel = this.batLabel2;
                case 2 -> sel = this.batLabel3;
                case 3 -> sel = this.batLabel4;
                default -> {}
            }
           
        } else{
    
            switch (frame) {
                case 0 -> sel = this.redBatLabel1;
                case 1 -> sel = this.redBatLabel2;
                case 2 -> sel = this.redBatLabel3;
                case 3 -> sel = this.redBatLabel4;
                default -> {}
            }     
        }
    
        return sel;
    }
}
