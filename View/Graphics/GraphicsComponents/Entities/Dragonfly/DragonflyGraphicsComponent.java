/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics.GraphicsComponents.Entities.Dragonfly;

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

public class DragonflyGraphicsComponent implements GraphicsComponent {
                                                                                                                                                                                              
    private int time;
    
    private final  ImageIcon dragonfly1;
    private final  Image  dragonflyImage1;
    private final  JLabel dragonflyLabel1;

    private final  ImageIcon dragonfly2;
    private final  Image  dragonflyImage2;
    private final  JLabel dragonflyLabel2;
       
    public DragonflyGraphicsComponent(){
    
        this.time = 0;
    
        this.dragonfly1 = new ImageIcon(getClass().getResource("dragonflyFrame1.png"));
        this.dragonflyLabel1 = new JLabel(this.dragonfly1);
        this.dragonflyImage1 = this.dragonfly1.getImage();

        this.dragonfly2 = new ImageIcon(getClass().getResource("dragonflyFrame2.png"));
        this.dragonflyLabel2 = new JLabel(this.dragonfly2);
        this.dragonflyImage2 = this.dragonfly2.getImage();       
    }

    @Override
    public void update(GameObject obj, SwingGraphics g) {
            
        g.drawDragonfly(obj, time);

        if(this.time < 1 ){

            this.time++;
        } else {

            this.time = 0;
        }
    }
    
    public Image getImage(int frame){
        
        Image sel = null;
    
        switch (frame) {
            case 0 -> sel = this.dragonflyImage1;
            case 1 -> sel = this.dragonflyImage2;
            default -> {}
        }
    
        return sel;
    }
    
    public JLabel getLabel(int frame){
        
        JLabel sel = null;
    
        switch (frame) {
            case 0 -> sel = this.dragonflyLabel1;
            case 1 -> sel = this.dragonflyLabel2;
            default -> {}
        }
    
        return sel;
    }
}

