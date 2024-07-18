/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.Entities.Butterfly;

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

public class ButterflyGraphicsComponent implements GraphicsComponent {
                                                                                                                                                                                              
    private int time;
    
    private final  ImageIcon butterfly1;
    private final  Image  butterflyImage1;
    private final  JLabel butterflyLabel1;

    private final  ImageIcon butterfly2;
    private final  Image  butterflyImage2;
    private final  JLabel butterflyLabel2;

    private final  ImageIcon butterfly3;
    private final  Image  butterflyImage3;
    private final  JLabel butterflyLabel3;

    private final  ImageIcon butterfly4;
    private final  Image  butterflyImage4;
    private final  JLabel butterflyLabel4;
    
    public ButterflyGraphicsComponent(){
    
        this.time = 0;
    
        this.butterfly1 = new ImageIcon(getClass().getResource("butterflyFrame1.png"));
        this.butterflyLabel1 = new JLabel(this.butterfly1);
        this.butterflyImage1 = this.butterfly1.getImage();

        this.butterfly2 = new ImageIcon(getClass().getResource("butterflyFrame2.png"));
        this.butterflyLabel2 = new JLabel(this.butterfly2);
        this.butterflyImage2 = this.butterfly2.getImage();

        this.butterfly3 = new ImageIcon(getClass().getResource("butterflyFrame3.png"));
        this.butterflyLabel3 = new JLabel(this.butterfly3);
        this.butterflyImage3 = this.butterfly3.getImage();

        this.butterfly4 = new ImageIcon(getClass().getResource("butterflyFrame4.png"));
        this.butterflyLabel4 = new JLabel(this.butterfly4);
        this.butterflyImage4 = this.butterfly4.getImage();
        
    }

    @Override
    public void update(GameObject obj, SwingGraphics g) {
        
        g.drawButterfly(obj, time);

        if(this.time < 5 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
    
    public Image getImage(int frame){
        
        Image sel = null;
    
        switch (frame) {
            case 0 -> sel = this.butterflyImage1;
            case 1 -> sel = this.butterflyImage2;
            case 2 -> sel = this.butterflyImage3;
            case 3 -> sel = this.butterflyImage4;
            default -> {}
        }
    
        return sel;
    }
    
    public JLabel getLabel(int frame){
        
        JLabel sel = null;
    
        switch (frame) {
            case 0 -> sel = this.butterflyLabel1;
            case 1 -> sel = this.butterflyLabel2;
            case 2 -> sel = this.butterflyLabel3;
            case 3 -> sel = this.butterflyLabel4;
            default -> {}
        }
        
        return sel;
    }
}
