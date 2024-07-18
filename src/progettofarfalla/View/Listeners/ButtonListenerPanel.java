/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import progettofarfalla.Commons.P2d;
import progettofarfalla.Model.Game.GameEngine;
import progettofarfalla.Model.Game.GameObjects.Button;

/**
 *
 * @author Daniela
 */
public class ButtonListenerPanel extends JPanel implements MouseListener{
    
    
    private final int base;
    private final int heigth;
    private final P2d pos;
    private final Button button;
    private final GameEngine engine;
    
    public ButtonListenerPanel(P2d p, int b, int h, Button bt, GameEngine e){
    
        setSize(b,h);
    
        this.pos = p;
        this.base = b;
        this.heigth = h;
        this.button = bt;
        this.engine = e;
              
        this.addMouseListener(this);        

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(null != this.button.getType())switch (this.button.getType()) {
            
            case EXIT:
                
                /*this.engine.getGameState().setPlay(false);
                this.engine.getGameState().setHelp(false);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(false);
                this.engine.setExit(true);*/
                
                this.engine.getMouseController().notifyMouseKlicked(0);
                
                break;
                
            case MENU:
                
                /*this.engine.getGameState().setPlay(false);
                this.engine.getGameState().setHelp(false);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(true);*/
                
                this.engine.getMouseController().notifyMouseKlicked(1);
                
                break;
                
            case START:
                
                /*this.engine.getGameState().setPlay(true);
                this.engine.getGameState().setHelp(false);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(false);*/
                
                this.engine.getMouseController().notifyMouseKlicked(2);
                
                break;
        
            case HELP:
                
                /*this.engine.getGameState().setPlay(false);
                this.engine.getGameState().setHelp(true);
                this.engine.getGameState().setGameOver(false);
                this.engine.getGameState().setMenu(false);*/
                
                this.engine.getMouseController().notifyMouseKlicked(3);
                
                break;
                
            default:
                
                break;
        } 
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        
        this.button.setSelected(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        this.button.setSelected(false);
    }
    
    public P2d getPos(){
    
        return this.pos; 
    }
    
    public int getBase(){
    
        return this.base;
    }
    
    public int getHeigth(){
    
        return this.heigth;
    }
}
