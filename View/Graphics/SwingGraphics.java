/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Graphics;

/**
 *
 * @author Daniela
 */
import progettofarfalla.View.Graphics.GraphicsComponents.Entities.Butterfly.ButterflyGraphicsComponent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.*;
import java.awt.geom.AffineTransform;
import progettofarfalla.Commons.*;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.Model.Game.GameObjects.GameObject;

import progettofarfalla.Model.Game.GameObjects.Button;
import progettofarfalla.View.Graphics.GraphicsComponents.Entities.Bats.BatGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.Entities.Dragonfly.DragonflyGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Bomb.BombGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Curse.CurseGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Life.LifeGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.PickUps.PickUpObjGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Super.SuperGraphicsComponent;

public class SwingGraphics {
   
    private final  Graphics2D g2;
    private  static final Stroke strokeBall = new BasicStroke(4f);
    private  static final Stroke strokeButton = new BasicStroke(8f);
    private final int centerX;
    private final int centerY;
    private final double ratioX;
    private final double ratioY;   
    private Font buttonFont;

    public SwingGraphics(Graphics2D g2, int centerX, int centerY, double ratioX, double ratioY){
        
        this.g2 = g2;
        this.centerX = centerX;
        this.centerY = centerY;
        this.ratioX = ratioX;
        this.ratioY = ratioY;                   
    }
	
    public void drawBat(GameObject obj, int time) {
               
        P2d pos = obj.getCurrentPos();
        
        BatGraphicsComponent component = (BatGraphicsComponent) obj.getGraphicsComponent();
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        int rad = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius());
            
        switch (time) {
            case 0 -> g2.drawImage(component.getImage(0), x-rad*4/3   , y-rad        , rad*8/3   , rad*2,    component.getLabel(0));
            case 1 -> g2.drawImage(component.getImage(1), x-rad*7/5   , y-rad        , rad*14/5  , rad*2,    component.getLabel(1));
            case 2 -> g2.drawImage(component.getImage(2), x-rad*11/10 , y-rad*11/10  , rad*11/5  , rad*11/5, component.getLabel(2));
            case 3 -> g2.drawImage(component.getImage(3), x-rad*3/5   , y-rad*6/5    , rad*6/5   , rad*12/5, component.getLabel(3));
            case 4 -> g2.drawImage(component.getImage(2), x-rad*11/10 , y-rad*11/10  , rad*11/5  , rad*11/5, component.getLabel(2));
            case 5 -> g2.drawImage(component.getImage(1), x-rad*7/5   , y-rad        , rad*14/5  , rad*2,    component.getLabel(1));
            default -> {
            }
        }      
    }
        
    public void drawButterfly(GameObject obj , int time) {

        P2d pos = obj.getCurrentPos();

        ButterflyGraphicsComponent component = (ButterflyGraphicsComponent) obj.getGraphicsComponent();
        Image im = component.getImage(0);
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        int rad = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius());
        double Ytransform = im.getHeight(component.getLabel(0))/rad;
        double Xtransform = im.getWidth(component.getLabel(0))/rad;
        double YImTransform = 1/Ytransform;
        double XImTransform = 1/Xtransform;
        
        AffineTransform tx = AffineTransform.getRotateInstance(obj.getCurrentVel().getY(), obj.getCurrentVel().getX(), x, y);
        tx.concatenate(AffineTransform.getTranslateInstance(x-rad*9/8, y-rad));
        tx.concatenate(AffineTransform.getScaleInstance(XImTransform*9/4, YImTransform*2));
               
        switch (time) {
            case 0 -> g2.drawImage(component.getImage(0), tx, component.getLabel(0));
            case 1 -> g2.drawImage(component.getImage(1), tx, component.getLabel(1));
            case 2 -> g2.drawImage(component.getImage(2), tx, component.getLabel(2));
            case 3 -> g2.drawImage(component.getImage(3), tx, component.getLabel(3));
            case 4 -> g2.drawImage(component.getImage(2), tx, component.getLabel(2));
            case 5 -> g2.drawImage(component.getImage(1), tx, component.getLabel(1));
            default -> {
            }
        }
    }
    
    public void drawDragonfly(GameObject obj , int time) {

        P2d pos = obj.getCurrentPos();

        DragonflyGraphicsComponent component = (DragonflyGraphicsComponent) obj.getGraphicsComponent();
        Image im = component.getImage(0);
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        int rad = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius());
        double Ytransform = im.getHeight(component.getLabel(0))/rad;
        double Xtransform = im.getWidth(component.getLabel(0))/rad;
        double YImTransform = 1/Ytransform;
        double XImTransform = 1/Xtransform;
        
        AffineTransform tx = AffineTransform.getRotateInstance(obj.getCurrentVel().getY(), obj.getCurrentVel().getX(), x, y);
        tx.concatenate(AffineTransform.getTranslateInstance(x-rad*9/8, y-rad));
        tx.concatenate(AffineTransform.getScaleInstance(XImTransform*9/4, YImTransform*2));
        
        g2.drawImage(component.getImage(time), tx, component.getLabel(time));
    }
                                                                                                                                                                      
    public void drawSummoningBall(GameObject obj, int time) {
        
        P2d pos = obj.getCurrentPos();
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        g2.setColor(Color.ORANGE);
        g2.setStroke(strokeBall);
        int rad = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius());

        switch (time) {
            case 0 -> g2.drawOval(x-rad/7, y-rad/7, rad*2/7, rad*2/7);
            case 1 -> g2.drawOval(x-rad*2/7, y-rad*2/7, rad*4/7, rad*4/7);
            case 2 -> g2.drawOval(x-rad*3/7, y-rad*3/7, rad*6/7, rad*6/7);
            case 3 -> g2.drawOval(x-rad*4/7, y-rad*4/7, rad*8/7, rad*8/7);
            case 4 -> g2.drawOval(x-rad*5/7, y-rad*5/7, rad*10/7, rad*10/7);
            case 5 -> g2.drawOval(x-rad*6/7, y-rad*6/7, rad*12/7, rad*12/7);
            case 6 -> g2.drawOval(x-rad, y-rad, rad*2, rad*2);
            default -> {
            }
        }
    }
        
    public void drawKiller(GameObject obj, boolean pulse) {

        P2d pos = obj.getCurrentPos();

        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        g2.setColor(Color.YELLOW);
        g2.setStroke(strokeBall);               
        int rad = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius());

        if(pulse == false){
            
            g2.drawOval(x-rad, y-rad, rad*2, rad*2);
            
        } else{

            g2.drawOval(x-rad/2, y-rad/2, rad, rad);
        }
    }
        
    public void drawPickableObj(GameObject obj, int frame) {
  
        P2d pos = obj.getCurrentPos();
        int mul = frame;
        double rotationRequired = mul*Math.toRadians(1.6);
        PickUpObjGraphicsComponent component = (PickUpObjGraphicsComponent) obj.getGraphicsComponent();
        Image im = component.getImage();
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        int edge = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius()*2);
        double Ytransform = im.getHeight(component.getLabel())/edge;
        double Xtransform = im.getWidth(component.getLabel())/edge;
        double YImTransform = 1/Ytransform;
        double XImTransform = 1/Xtransform;

        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, x, y);
        tx.concatenate(AffineTransform.getTranslateInstance(x-edge/2, y-edge/2));
        tx.concatenate(AffineTransform.getScaleInstance(XImTransform, YImTransform));
        
        g2.drawImage(component.getImage(), tx, component.getLabel());       
    }

    public void drawSuper(GameObject obj, int time) {
        P2d pos = obj.getCurrentPos();
        SuperGraphicsComponent component = (SuperGraphicsComponent) obj.getGraphicsComponent();
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);        
        int edge = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius()*2);
     
        g2.drawImage(component.getImage(time), x-edge, y-edge, edge*2, edge*2, component.getLabel(time));                  
    }

    public void drawBomb(GameObject obj, int time) {
        
        P2d pos = obj.getCurrentPos();
        BombGraphicsComponent component = (BombGraphicsComponent) obj.getGraphicsComponent();
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);      
        int edge = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius()*2);

        switch (time) {
            case 0 -> g2.drawImage(component.getImage(0), x-edge, y-edge*3/2, edge*2, edge*6/2, component.getLabel(0));
            case 1 -> g2.drawImage(component.getImage(1), x-edge, y-edge*3/2, edge*2, edge*6/2, component.getLabel(1));
            default -> {
            }
        }  
    }
    
    public void drawLife(GameObject obj, int time) {
        
        P2d pos = obj.getCurrentPos();
        LifeGraphicsComponent component = (LifeGraphicsComponent) obj.getGraphicsComponent();
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);       
        int edge = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius()*2);
        
        g2.drawImage(component.getImage(time), x-edge*13/11, y-edge, edge*26/11, edge*2, component.getLabel(time));           
    }
       
    public void drawCurse(GameObject obj, int time) {
        
        P2d pos = obj.getCurrentPos();
        CurseGraphicsComponent component = (CurseGraphicsComponent) obj.getGraphicsComponent();
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        int edge = getDeltaXinPixel(((CircleBoundingBox)(obj.getBBox())).getRadius()*2);

        g2.drawImage(component.getImage(time), x-edge*13/11, y-edge, edge*26/11, edge*2, component.getLabel(time));           
    }
    
    public void drawButton(Button obj){
            
        P2d pos = obj.getCurrentPos();     
        
        buttonFont = new Font("Verdana", Font.PLAIN, (int) obj.getHeight()*5/4);
        
        int x = getXinPixel(pos);
        int y = getYinPixel(pos);
        int b = (int) obj.getBase();
        int h = (int) obj.getHeight();
        g2.setColor(Color.ORANGE);
        g2.setStroke(strokeButton);
        
        g2.drawRect(x-b/2, y, b, h);
               
        g2.setFont(buttonFont);
        
        if(obj.getSelected() == true){
        
            g2.setColor(Color.RED);
            
        }else{
            
            g2.setColor(Color.BLACK);     
        }
        
        if(null != obj.getType())switch (obj.getType()) {
            case EXIT -> g2.drawString("EXIT", x-b/2, y+h);
            case HELP -> g2.drawString("HELP", x-b/2, y+h);
            case MENU -> g2.drawString("MENU", x-b/2, y+h);
            case START -> g2.drawString("START", x-b/2, y+h);
            default -> {
            }
        }
    }
    
    private int getXinPixel(P2d p){
        return (int) Math.round(centerX + p.getX() * ratioX);
    }

    private int getYinPixel(P2d p){
        return (int)  Math.round(centerY - p.getY() * ratioY);
    }

    private int getDeltaXinPixel(double dx){
        return (int)  Math.round(dx * ratioX);
    }
}
