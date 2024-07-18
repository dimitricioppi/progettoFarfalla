/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.World;

/**
 *
 * @author Daniela
 */
import progettofarfalla.Model.Game.GameObjects.Button;
import progettofarfalla.Model.Game.GameObjects.Summoning;
import progettofarfalla.Model.Game.GameObjects.GameObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import progettofarfalla.Commons.*;
import progettofarfalla.Model.World.Physics.BoundaryCollision;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.Model.World.Events.*;

public class World {
	
    private final List<GameObject> picks;
    private final List<GameObject> enemies;
    private final List<GameObject> killers;
    private final List<GameObject> butterflys;
    private final List<Summoning> summons;
    private final List<Button> buttons;
    private final RectBoundingBox mainBBox;
    private WorldEventListener evListener;

    public World(RectBoundingBox bbox){

        picks = new ArrayList<>();
        butterflys = new ArrayList<>();
        enemies = new ArrayList<>();
        killers = new ArrayList<>();
        summons = new ArrayList<>();
        buttons = new ArrayList<>();
        mainBBox = bbox;
    }

    public void setEventListener(WorldEventListener l){

        evListener = l;
    }

    public void addButterfly(GameObject butterfly){

        butterflys.add(butterfly);
    }

    public void removeButterfly(GameObject butterfly){

        butterflys.remove(butterfly);
    }

    public void addKiller(GameObject killer){
        
        killers.add(killer);
    }

    public void removeKiller(GameObject killer){
        
        killers.remove(killer);
    }

    public void addEnemy(GameObject bat){
        
        enemies.add(bat);
    }

    public void removeEnemy(GameObject bat){
        
        enemies.remove(bat);
    }

    public void addPickUp(GameObject obj){
        
        picks.add(obj);
    }

    public void removePickUp(GameObject obj){
        
        picks.remove(obj);
    }

    public void addSummoning(Summoning summoning){
        
        summons.add(summoning);
    }

    public void removeSummoning(Summoning summoning){
        
        summons.remove(summoning);
    }

    public void removeAllSummonings(){
        
        summons.removeAll(summons);
    }

    public void addButton(Button button){

        buttons.add(button);
    }

    public void removeButton(Button button){

        buttons.remove(button);
    }

    public void removeAllButtons(){

        buttons.removeAll(buttons);
    }

    public void updateState(long dt){
        
        for (GameObject butterfly: butterflys) {

            butterfly.updatePhysics(dt, this);
        }
    }

    public void updateEnemyState(long dt){
        
        for (GameObject bat: enemies ) {

            bat.updatePhysics(dt, this);
        }
    }

    public void updateKillerState(long dt){
        
        for (GameObject killer: killers ) {
            
            killer.updatePhysics(dt, this);
        }
    }

    public void updateSummonState(long dt){
        
        for (GameObject summon: summons ) {

            summon.updatePhysics(dt, this);
        }
    }

    public void updateButtonState(long dt){

        for (GameObject button: buttons ) {
            
            button.updatePhysics(dt, this);
        }

    }

    public Optional<BoundaryCollision> checkCollisionWithBoundaries(P2d pos, CircleBoundingBox box){
        
        P2d ul = mainBBox.getULCorner();
        P2d br = mainBBox.getBRCorner();
        double r = box.getRadius();
        
        if (pos.getY() + r> ul.getY()){
            
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.TOP, new P2d(pos.getX(),ul.getY())));
        
        } else if (pos.getY() - r < br.getY()){
            
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.BOTTOM, new P2d(pos.getX(),br.getY())));
        
        } else if (pos.getX() + r > br.getX()){
            
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.RIGHT, new P2d(br.getX(),pos.getY())));
        
        } else if (pos.getX() - r < ul.getX()){
            
            return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.LEFT, new P2d(ul.getX(),pos.getY())));
        
        } else {
            
            return Optional.empty();
        }
    }

    public Optional<GameObject> checkCollisionWithPickUpObj(P2d pos, CircleBoundingBox box){
        
        double radius = box.getRadius();
        for (GameObject obj: picks){
            
            if (obj.getBBox().isCollidingWith(pos,radius)){
                
                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }

    public Optional<GameObject> checkCollisionWithEnemy(P2d pos, CircleBoundingBox box){
        
        double radius = box.getRadius();

        for (GameObject obj: enemies){


            if (obj.getBBox().isCollidingWith(pos,radius)){     

                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }

    public void notifyWorldEvent(WorldEvent ev){
        
        evListener.notifyEvent(ev);
    }

    public RectBoundingBox getBBox(){
        
        return mainBBox;
    }

    public Collection<GameObject> getButterflys(){
        
        return butterflys;
    }

    public GameObject getButterfly(){

        return butterflys.get(0);
    }

    public Collection<GameObject> getBats(){
            return enemies;
    }

    public Collection<GameObject> getKillers(){
        
        return killers;
    }

    public Collection<Summoning> getSummons(){
        
        return summons;
    }

    public Summoning getSummon(int i){

        return summons.get(i);
    }

    public GameObject getClosestBat(){

        GameObject victim;
        GameObject sel;
        P2d pb;
        P2d pv;


        double difXSel, difXV;
        double difYSel, difYV;
        double distanceV, distanceSel;

        P2d p = this.butterflys.get(0).getCurrentPos();

        victim = this.enemies.get(0);

        for (int i=1; i<this.enemies.size(); i++){

            sel = this.enemies.get(i);
            pb = sel.getCurrentPos();
            pv = victim.getCurrentPos();

            difXSel = pb.getX() - p.getX();
            difXV = pv.getX() - p.getX();

            difYSel = pb.getY() - p.getY();
            difYV = pv.getY() - p.getY();

            distanceSel = Math.sqrt(difXSel*difXSel + difYSel*difYSel);
            distanceV = Math.sqrt(difXV*difXV + difYV*difYV);

            if (distanceSel < distanceV){
                
                victim = this.enemies.get(i);
            }
        }

        return victim;
    }

    public Collection<GameObject> getPicks(){

        return picks;
    }

    public Collection<Button> getButtons(){

        return buttons;
    }

    public List<GameObject> getSceneEntities(){
        
        List<GameObject> entities = new ArrayList<>();
        entities.addAll(picks);
        entities.addAll(butterflys);
        entities.addAll(enemies);
        entities.addAll(killers);
        entities.addAll(summons);
        return entities;
    }
}
