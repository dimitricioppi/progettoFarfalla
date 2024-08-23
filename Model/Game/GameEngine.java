/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Inputs.AbstractPlayerInputComponent;
import progettofarfalla.Model.Inputs.InputComponent;
import progettofarfalla.Model.Inputs.KillerInputComponent;
import progettofarfalla.Controllers.KeyboardImputControllers.KeyboardInputController;
import progettofarfalla.Controllers.KeyboardImputControllers.InputController;
import progettofarfalla.Controllers.InputControllerNotFoundException;
import java.util.*;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import progettofarfalla.Model.World.Events.*;
import progettofarfalla.Model.World.World;
import progettofarfalla.View.SwingScene;
import static java.awt.event.KeyEvent.*;
import progettofarfalla.Commons.P2d;
import progettofarfalla.Commons.V2d;
import progettofarfalla.Controllers.MouseImputController;
import progettofarfalla.Model.Game.GameObjects.Button;
import progettofarfalla.Model.Game.GameObjects.Entity;
import progettofarfalla.Model.Game.GameObjects.PickUp;
import static progettofarfalla.Model.Game.GameObjects.PickUp.Type.*;
import static progettofarfalla.Model.Game.GameObjects.Entity.Type.*;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Bomb.BombGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Curse.CurseGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Life.LifeGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.PickUps.PickUpObjGraphicsComponent;
import progettofarfalla.View.Graphics.GraphicsComponents.PickUps.Super.SuperGraphicsComponent;

public class GameEngine implements WorldEventListener {

    
    
    private final long PERIOD = 20; 

    private SwingScene view;
    private final LinkedList<WorldEvent> eventQueue;
    private GameState gameState;
    private HashMap<String,InputController> controllers;
    private final Random rand;
    private final MouseImputController contrM;


    public GameEngine(){
        eventQueue = new LinkedList<>();       
        rand = new Random();
        contrM = new MouseImputController(this);
    }

    public void initGame(){

        controllers = new HashMap<>();

        KeyboardInputController contrA = new KeyboardInputController(VK_UP,VK_DOWN,VK_LEFT,VK_RIGHT);
        
        controllers.put("KeyPadA", contrA);


        gameState = new GameState(this);
        this.view = new SwingScene(gameState, 750, 700, 45, 45);
    }

    public void setGame(){

        controllers = new HashMap<>();

        KeyboardInputController contrA = new KeyboardInputController(VK_UP,VK_DOWN,VK_LEFT,VK_RIGHT);        
        controllers.put("KeyPadA", contrA);
        
        gameState = new GameState(this);
        this.view.setGameState(gameState);
    }

    public void mainLoop(){

        while(this.gameState.isExit() == false){

            if(gameState.isPlay() == true){

                this.gameState.setGame();
            }

            this.view.removeButtons();

            long previousCycleStartTime = System.currentTimeMillis();
            while (gameState.isPlay() == true) {

                this.gameState.controlGameOver();
                long currentCycleStartTime = System.currentTimeMillis();
                long elapsed = currentCycleStartTime - previousCycleStartTime;                       
                processInput();
                updateGame(elapsed);                       
                this.summonEntityes();                          
                renderGame();
                waitForNextFrame(currentCycleStartTime);
                previousCycleStartTime = currentCycleStartTime;


            }

            this.view.removeButtons();

            while (gameState.isGameOver() == true){

                if(this.gameState.getWorld().getButtons().isEmpty()){

                    this.createButtons(new P2d(0,-5), Button.Type.MENU);
                    this.createButtons(new P2d(0,-10), Button.Type.EXIT);
                }

                long currentCycleStartTime = System.currentTimeMillis();
                long elapsed = currentCycleStartTime - previousCycleStartTime;                       
                processInput();
                updateButtons(elapsed);
                renderView();
                waitForNextFrame(currentCycleStartTime);
                previousCycleStartTime = currentCycleStartTime;

            }

            this.view.removeButtons();

            while (gameState.isMenu()){

                if(this.gameState.getWorld().getButtons().isEmpty()){

                    this.createButtons(new P2d(0,-5), Button.Type.START);
                    this.createButtons(new P2d(0,-10), Button.Type.HELP);
                    this.createButtons(new P2d(0,-15), Button.Type.EXIT);
                }

                long currentCycleStartTime = System.currentTimeMillis();
                long elapsed = currentCycleStartTime - previousCycleStartTime;                       
                processInput();
                updateButtons(elapsed);
                renderView();
                waitForNextFrame(currentCycleStartTime);
                previousCycleStartTime = currentCycleStartTime;

            }

            this.view.removeButtons();

            while (gameState.isHelp()){

                if(this.gameState.getWorld().getButtons().isEmpty()){

                    this.createButtons(new P2d(-10,-15), Button.Type.MENU);
                    this.createButtons(new P2d(10,-15), Button.Type.EXIT);
                }

                long currentCycleStartTime = System.currentTimeMillis();
                long elapsed = currentCycleStartTime - previousCycleStartTime;                       
                processInput();
                updateButtons(elapsed);
                renderView();
                waitForNextFrame(currentCycleStartTime);
                previousCycleStartTime = currentCycleStartTime;

            }
        }

        if(this.gameState.isExit() == true){    
                System.exit(0);
        }else{

            System.exit(1);
        }

    }

    private void waitForNextFrame(long cycleStartTime){
        
        long dt = System.currentTimeMillis() - cycleStartTime;
        if (dt < PERIOD){

            try {
                Thread.sleep(PERIOD - dt);
            } catch (InterruptedException ex){}
        }
    }

    private void processInput(){

        for (GameObject butterfly: gameState.getWorld().getButterflys()) {
            
            butterfly.updateInput();
        }
        
        for (GameObject bat: gameState.getWorld().getEnemies()) {
            
            bat.updateInput();
        }

        for (GameObject killer: gameState.getWorld().getKillers()) {
            
            killer.updateInput();
        }

    }

    private void updateGame(long elapsed){
        gameState.getWorld().updateState(elapsed);
        gameState.getWorld().updateEnemyState(elapsed);
        gameState.getWorld().updateKillerState(elapsed);
        gameState.getWorld().updateSummonState(elapsed);
        checkEvents();
    }

    private void updateButtons(long elapsed){

        gameState.getWorld().updateButtonState(elapsed);        
    }

    private void checkEvents(){
        World scene = gameState.getWorld();
        eventQueue.stream().forEach((WorldEvent ev) -> {

            if (ev instanceof HitPickUpEvent cev){

                InputComponent input = cev.getSelf().getInputComponent();
                if (input instanceof AbstractPlayerInputComponent) {
                    this.eventReaction((PickUp) cev.getCollisionObj(), input);

                }
                scene.removePickUp(cev.getCollisionObj());
                createGameObjects(getPlayer().getPickUpsTaken());

            } else if (ev instanceof HitEnemyEvent eev){

                InputComponent input = eev.getSelf().getInputComponent();
                Entity collidingEnemy = (Entity) eev.getCollisionObj();
                if (input instanceof AbstractPlayerInputComponent && collidingEnemy.getType() != Entity.Type.BAT_KILLER) {

                    ((AbstractPlayerInputComponent) input).getPlayer().updateLives(-1);                 				
                }

                if (scene.getEnemies().contains(collidingEnemy)){

                    scene.removeEnemy(collidingEnemy);
                    collidingEnemy.getCurrentVel().killVel();
                }

            } else if (ev instanceof KillEnemyEvent kev){

                scene.removeEnemy(kev.getCollisionObj());
                kev.getCollisionObj().getCurrentVel().killVel();
                scene.removeKiller(kev.getSelf());

            } else if (ev instanceof HitBorderEvent bev){	

                InputComponent input = bev.getSelf().getInputComponent();
                if (input instanceof AbstractPlayerInputComponent abstractPlayerInputComponent) {

                    abstractPlayerInputComponent.getPlayer().updateScore(0);
                }


            }
        });
        eventQueue.clear();
    }

    private void renderGame(){
        
        view.renderGame();
    }

    private void renderView(){

        view.renderView();
    }

    @Override
    public void notifyEvent(WorldEvent ev) {
        
        eventQueue.add(ev);
    }

    public InputController getController(String name) throws InputControllerNotFoundException {
        InputController ctrl = controllers.get(name);
        if (ctrl == null) {
            
            throw new InputControllerNotFoundException();
        } else {
            
            return ctrl;
        }
    }

    public Collection<KeyboardInputController> getKeyboardInputControllers() {
        Collection<KeyboardInputController> contr = new ArrayList<>();
        for (InputController c: controllers.values()) {
            
            if (c instanceof KeyboardInputController keyboardInputController) {
                
                contr.add(keyboardInputController);
            }
        }
        return contr;
    }

    public void eventReaction(PickUp p, InputComponent input){

        if(null != p.getType())switch (p.getType()) {

            case PICKABLE_OBJ -> {
                ((AbstractPlayerInputComponent) input).getPlayer().updateScore(10*(this.gameState.getWorld().getEnemies().size()+1));
                ((AbstractPlayerInputComponent) input).getPlayer().updatePickUpsTaken(1);
                this.gameState.getWorld().addPickUp(GameFactory.createPickUpObject(PICKABLE_OBJ, new P2d(this.gameState.getWorld()), 1, new PickUpObjGraphicsComponent(false)));
            }

            case EXTRA_POINTS -> {
                ((AbstractPlayerInputComponent) input).getPlayer().updateScore(30*(this.gameState.getWorld().getEnemies().size()+1));
                ((AbstractPlayerInputComponent) input).getPlayer().updatePickUpsTaken(1);
            }

            case CURSE ->             {
                ((AbstractPlayerInputComponent) input).getPlayer().updateScore(100*(this.gameState.getWorld().getEnemies().size()+1));
                ((AbstractPlayerInputComponent) input).getPlayer().updatePickUpsTaken(1);
                {
                    gameState.getWorld().addSummoning(GameFactory.createSummoning(p.getCurrentPos(), 1, DRAGONFLY, gameState.getWorld()));
                }
            }

            case SUPER -> {
                ((AbstractPlayerInputComponent) input).getPlayer().updateScore(150*(this.gameState.getWorld().getEnemies().size()+1));
                ((AbstractPlayerInputComponent) input).getPlayer().updatePickUpsTaken(1);
            }
            
            case LIFE -> {
                ((AbstractPlayerInputComponent) input).getPlayer().updateScore(50*(this.gameState.getWorld().getEnemies().size()+1));
                ((AbstractPlayerInputComponent) input).getPlayer().updateLives(1);
                ((AbstractPlayerInputComponent) input).getPlayer().updatePickUpsTaken(1);
            }

            case BOMB -> {
                ((AbstractPlayerInputComponent) input).getPlayer().updateScore(10);
                ((AbstractPlayerInputComponent) input).getPlayer().updatePickUpsTaken(1);
                if(!gameState.getWorld().getEnemies().isEmpty()){

                    gameState.getWorld().addKiller(GameFactory.createKiller( p.getCurrentPos(), 0.5, new V2d(0,0), new KillerInputComponent(gameState.getWorld().getClosestEnemy())));
                    
                }
            }
            default -> {
            }
        }

    }

    public void createGameObjects(int picksTaken){

        picksTaken = this.getPlayer().getPickUpsTaken();
        V2d vel = new V2d(0,0);
        vel.randomDirection();

        if(picksTaken%this.rand.nextInt(15, 25) == 0 && picksTaken != 0){           

            this.gameState.getWorld().addPickUp(GameFactory.createPickUpObject(PICKABLE_OBJ, new P2d(this.gameState.getWorld()), 1, new PickUpObjGraphicsComponent(false)));            
        }

        if(picksTaken%this.rand.nextInt(2, 5) == 0 && picksTaken != 0){           

            this.gameState.getWorld().addPickUp(GameFactory.createPickUpObject(EXTRA_POINTS, new P2d(this.gameState.getWorld()), 1, new PickUpObjGraphicsComponent(true)));            
        }

        if(picksTaken%this.rand.nextInt(13, 20) == 0 && picksTaken != 0){           

            this.gameState.getWorld().addPickUp(GameFactory.createPickUpObject(CURSE, new P2d(this.gameState.getWorld()), 1, new CurseGraphicsComponent()));            
        }

        if(picksTaken%this.rand.nextInt(10, 25) == 0 && picksTaken != 0){           

            this.gameState.getWorld().addPickUp(GameFactory.createPickUpObject(SUPER, new P2d(this.gameState.getWorld()), 1, new SuperGraphicsComponent()));            
        }

        if(picksTaken%this.rand.nextInt(15, 25) == 0 && picksTaken != 0){           

            this.gameState.getWorld().addPickUp(GameFactory.createPickUpObject(LIFE, new P2d(this.gameState.getWorld()), 1, new LifeGraphicsComponent()));            
        }

        if(picksTaken%this.rand.nextInt(2, 5) == 0 && picksTaken != 0){           

            this.gameState.getWorld().addPickUp(GameFactory.createPickUpObject(BOMB, new P2d(this.gameState.getWorld()), 1, new BombGraphicsComponent()));            
        }

        if(picksTaken%this.rand.nextInt(2, 5) == 0 && picksTaken != 0){           

            gameState.getWorld().addSummoning(GameFactory.createSummoning(new P2d(gameState.getWorld()), 1, BLACK_BAT, gameState.getWorld()));            
        }

        if(picksTaken%this.rand.nextInt(6, 15) == 0 && picksTaken != 0){           

            gameState.getWorld().addSummoning(GameFactory.createSummoning(new P2d(gameState.getWorld()), 1, RED_BAT, gameState.getWorld()));            
        }

    }

    public void summonEntityes(){

        if(gameState.getWorld().getSummons() != null){

            for (int i = 0; i< gameState.getWorld().getSummons().size(); i++) {

                if(gameState.getWorld().getSummon(i).getTimeToSummon() == true){

                    gameState.getWorld().getSummon(i).summonEntity();
                    gameState.getWorld().getSummons().remove(gameState.getWorld().getSummon(i));
                }
            }
        }
    }


    public Player getPlayer(){

        InputComponent control;
        control = this.gameState.getWorld().getButterfly().getInputComponent();

        return ((AbstractPlayerInputComponent) control).getPlayer();
    }

    public void createButtons(P2d pos, Button.Type type){

        if(null != type)switch (type) {
            
            case EXIT -> this.gameState.getWorld().addButton(GameFactory.createButton(pos, 40, 120, type, this));
                
            case HELP -> this.gameState.getWorld().addButton(GameFactory.createButton(pos, 40, 130, type, this));
                
            case MENU -> this.gameState.getWorld().addButton(GameFactory.createButton(pos, 40, 145, type, this));
                
            case START -> this.gameState.getWorld().addButton(GameFactory.createButton(pos, 40, 167, type, this));
                
            default -> {
            }
        }

    }
    
    public GameState getGameState(){

        return this.gameState;
    }
    
    public MouseImputController getMouseController(){
    
        return this.contrM;
    }
}
