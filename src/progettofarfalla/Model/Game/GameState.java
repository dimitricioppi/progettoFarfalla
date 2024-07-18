/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Controllers.ImputControllers.InputControllerNotFoundException;
import progettofarfalla.Model.Imputs.InputComponent;
import progettofarfalla.Model.Imputs.AbstractPlayerInputComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import progettofarfalla.Commons.*;
import static progettofarfalla.Model.Game.GameObjects.PickUp.Type.*;
import progettofarfalla.Model.World.World;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.PickUps.PickUpObjGraphicsComponent;

public class GameState {
	
    private World world;
    private Player player;
    private final GameFactory f;
    private final GameEngine gameEngine;
    private boolean menu, help, play, gameOver, exit;

    public GameState(GameEngine engine){

        this.gameEngine = engine;
        world = new World(new RectBoundingBox(new P2d(-20,15), new P2d(20,-15)));
        f = GameFactory.getInstance();		
        this.menu = true;
        this.help = false;
        this.play = false;
        this.gameOver = false;
        this.exit = false;
    }

    public void setGame(){

        world = new World(new RectBoundingBox(new P2d(-20,15), new P2d(20,-15)));

        try {
            player = new Player(gameEngine.getController("KeyPadA"));
        } catch (InputControllerNotFoundException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        world.addButterfly(f.createButterfly(new P2d(0,0), 1.2, new V2d(0,0), player));
        world.addPickUp(f.createPickUpObject(PICKABLE_OBJ, new P2d(this.world), 1,  new PickUpObjGraphicsComponent(false)));
        world.addPickUp(f.createPickUpObject(PICKABLE_OBJ, new P2d(this.world), 1,  new PickUpObjGraphicsComponent(false)));
        world.addPickUp(f.createPickUpObject(PICKABLE_OBJ, new P2d(this.world), 1,  new PickUpObjGraphicsComponent(false)));
        world.addPickUp(f.createPickUpObject(PICKABLE_OBJ, new P2d(this.world), 1, new PickUpObjGraphicsComponent(false)));
        world.setEventListener(gameEngine);
    }

    public World getWorld(){
        
        return world;
    }

    public Player getPlayer(){

        return player;
    }

    public boolean controlGameOver(){

        InputComponent control;
        int lives;
        control = this.world.getButterfly().getInputComponent();

        lives = ((AbstractPlayerInputComponent) control).getPlayer().getLives();

        if ( lives == 0){

            this.gameOver = true;  
            this.play = false;
        }

        return this.gameOver;
    }

    public GameFactory getFactory(){

        return f;
    }

    public boolean isMenu(){           

        return menu;
    }

    public void setMenu(boolean b){

        this.menu = b;
    }

    public boolean isHelp(){

        return this.help;
    }

    public void setHelp(boolean b){

        this.help = b;
    }

    public boolean isPlay(){

        return this.play;
    }

    public void setPlay(boolean b){

        this.play = b;
    }

    public void setGameOver(boolean b){

        this.gameOver = b;
    }

    public boolean isGameOver(){

        return this.gameOver;
    }
    
    public boolean isExit(){
    
        return this.exit;
    }
    
    public void exiting(){
    
        this.exit = true;
    }
}
