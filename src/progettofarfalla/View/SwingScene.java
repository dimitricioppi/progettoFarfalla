/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.View;

/**
 *
 * @author Daniela
 */
import progettofarfalla.View.Graphics.SwingGraphics;
import progettofarfalla.Controllers.ImputControllers.KeyboardInputController;
import progettofarfalla.Model.Game.GameState;
import progettofarfalla.Model.Game.GameEngine;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;
import progettofarfalla.Commons.*;
import progettofarfalla.Model.Game.*;
import progettofarfalla.Model.Game.GameObjects.*;
import progettofarfalla.Model.World.World;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.View.Listeners.ButtonListenerPanel;

public class SwingScene {
    
    private GameState gameState;
    private final JFrame frame;
    private final ScenePanel panel;
    private final GameEngine engine;    
    private final Color BackgroundColor;
    private final LinkedList<ButtonListenerPanel> buttonPanels;
    
    private final int centerX;
    private final int centerY;
    private final double ratioX;
    private final double ratioY;


    public SwingScene(GameState gameState, GameEngine engine, int w, int h, double width, double height){

        BackgroundColor = new Color(153,217,234);           
        frame = new JFrame("Butterfly Game");
        frame.setSize(w,h);
        frame.setMinimumSize(new Dimension(w,h));
        frame.setResizable(false);
        // frame.setUndecorated(true); // Remove title bar
        this.gameState = gameState;
        this.engine = engine;
        panel = new ScenePanel(w,h, width, height);
        this.buttonPanels = new LinkedList<>();

        centerX = w/2;
        centerY = h/2;
        ratioX = w/width;
        ratioY = h/height;

        frame.getContentPane().add(panel);

        frame.addWindowListener(new WindowAdapter(){
            
            @Override
            public void windowClosing(WindowEvent ev){

                System.exit(-1);
            }
            @Override
            public void windowClosed(WindowEvent ev){

                System.exit(-1);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public void renderGame(){
        
        try {
            panel.setBackground(BackgroundColor);
            frame.repaint();                   
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void renderView(){
        
        try {
            
            frame.repaint();

            gameState.getWorld().getButtons().forEach((Button e) -> {

                this.buttonPanels.add(e.getPanel());

            });

            for(int i = 0; i < this.buttonPanels.size(); i++){

                ButtonListenerPanel button = this.buttonPanels.get(i);

                this.panel.add(button);
                button.setLocation(getXinPixel(button.getPos())-this.buttonPanels.get(i).getBase()/2,
                                               getYinPixel(button.getPos()));
                //button.repaint();
                button.setSize(button.getBase(), button.getHeigth());
            }
            
        } catch (Exception ex){
        }
    
    }

    private int getXinPixel(P2d p){
            
        return (int) Math.round(centerX + p.getX() * ratioX);
    }

    private int getYinPixel(P2d p){

        return (int)  Math.round(centerY - p.getY() * ratioY);
        
    }
  
    public void setGameState(GameState g){
    
        this.gameState = g;
    
    }
    
    public void removeButtons(){
            
        this.panel.removeAll();

        this.buttonPanels.removeAll(buttonPanels);

        this.gameState.getWorld().getButtons().removeAll(gameState.getWorld().getButtons());
    
    }
    public class ScenePanel extends JPanel implements KeyListener{

        private final int centerX;
        private final int centerY;
        private final double ratioX;
        private final double ratioY;
        private final Font scoreFont;                
        private final Font titleFont;
        private final Font helpFont;
        private final Stroke strokeBorder = new BasicStroke(2f);

        public ScenePanel(int w, int h, double width, double height){
            
            setSize(w,h);
            centerX = w/2;
            centerY = h/2;
            ratioX = w/width;
            ratioY = h/height;

            scoreFont = new Font("Verdana", Font.PLAIN, 30);
            titleFont = new Font("Verdana", Font.PLAIN, 70);
            helpFont = new Font("Verdana", Font.PLAIN, 13);

            this.addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            requestFocusInWindow(); 
        }

        @Override
        public void paint(Graphics g){
            
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
            g2.clearRect(0,0,this.getWidth(),this.getHeight());           
            
            SwingGraphics gr = new SwingGraphics(g2, centerX, centerY, ratioX, ratioY);
           
            if (gameState.isGameOver()){
                              
                /* drawing the score */
                
                g2.setFont(titleFont);
                g2.setColor(Color.BLACK);
                g2.drawString("GAME OVER ", centerX - 230, centerY - 50);
                g2.setFont(scoreFont);
                g2.setColor(Color.BLACK);
                            
                g2.drawString("Final score: "+gameState.getPlayer().getScore(), 150, centerY + 50);

                
                gameState.getWorld().getButtons().forEach((Button e) -> {
                    e.updateGraphics(gr);
                    
                });
                
            } else if(gameState.isMenu() == true){
                      
                g2.setFont(titleFont);
                g2.setColor(Color.BLACK);
                g2.drawString("BUTTERFLY GAME", centerX - 325, centerY - 50);
                g2.setColor(Color.BLACK);
                
      
                gameState.getWorld().getButtons().forEach((Button e) -> {
                    e.updateGraphics(gr);
                    
                });
            
            } else if(gameState.isHelp() == true){
            
            
                g2.setFont(helpFont);
                g2.setColor(Color.BLACK);
                
                String text = """
                            Welcome to the butterfly game!\n
                            You are the butterfly and your objective is to make as mouch points as possible before dying.\n
                            Use the four arrow key to move the butterfly in the game world.\n
                            Be carefull as the butterfly needs time to both move and stop as well as turning.\n
                            You start with 3 lifes and 0 point: if you touch an enemy you will lose 1 life an that enemy will disappear.\n
                            Be carefull in this game getting hurt doesn't give invicibility frames an if you reach 0 lives the game ends.\n
                            In the game you will find varius pick-ups to make points an help you in the game, they are:\n
                              
                            1- Blue Flower   : gives 10 points.\n
                            2- Red Flower    : gives 30 points.\n
                            3- Bomb          : it will send an homing projectile to the nearest (if present) enemy to kill it.\n
                            4- Life Heart    : gives 1 extra life.\n
                            5- Super Star    : gives 150 points.\n
                            6- Curse Star    : gives 100 points and spawns an enemy.\n

                            You will face aganist 3 types of enemy in the game:\n
                            1- Black Bat     : the most basic one it moves in 1 direction bouncing in the edges of the game world.\n
                            2- Dragonfly     : spawned by the Course Star will randomly change direction 2 times per second.\n
                            3- Red Bat       : the rarest one an most dangerous, it will slowily follow the butterfly.\n

                            Take note that the number of pick-ups and enemies will grow based on the number of pick-ups taken.\n
                            The more points you have, the more difficult the game an the more points you will make.""";
                
                String [] lines = text.split("\n");
                
                for(int lineCount = 0; lineCount < lines.length; lineCount ++){ //lines from above
                    
                    String line = lines[lineCount];
                    g2.drawString(line, centerX - 360, centerY - 320 + (lineCount*10));
                }
                              
                g2.setColor(Color.BLACK);
                     
                gameState.getWorld().getButtons().forEach((Button e) -> {
                    e.updateGraphics(gr);
                    
                });
             
            } else {
                
                /* drawing the borders */
                
                g2.setBackground(BackgroundColor);

                World scene = gameState.getWorld();
                RectBoundingBox bbox = scene.getBBox();
                int x0 = getXinPixel(bbox.getULCorner());
                int y0 = getYinPixel(bbox.getULCorner());
                int x1 = getXinPixel(bbox.getBRCorner());
                int y1 = getYinPixel(bbox.getBRCorner());

                g2.setColor(Color.BLACK);
                g2.setStroke(strokeBorder);			
                g2.drawRect(x0, y0, x1-x0, y1-y0);
                g2.clearRect(x0, y0, x1-x0, y1-y0);

                /* drawing the game objects */
               
                gameState.getWorld().getSceneEntities().forEach( e -> {
                    e.updateGraphics(gr);
                });

                /* drawing the score */
                g2.setFont(scoreFont);
                g2.setColor(Color.BLACK);
                
                if(gameState.getPlayer() != null){
                
                    g2.drawString("SCORE "+gameState.getPlayer().getScore()+" : LIVES "+gameState.getPlayer().getLives(), 30, 75);

                }
            }
        }

        private int getXinPixel(P2d p){
            
            return (int) Math.round(centerX + p.getX() * ratioX);
        }

        private int getYinPixel(P2d p){
            
            return (int)  Math.round(centerY - p.getY() * ratioY);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            for (KeyboardInputController ctrl: engine.getKeyboardInputControllers()) {
                
                ctrl.notifyKeyPressed(e.getKeyCode());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            for (KeyboardInputController ctrl: engine.getKeyboardInputControllers()) {
                
                ctrl.notifyKeyReleased(e.getKeyCode());
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

    }
    
    
}
