/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Model.Game.GameObjects;

/**
 *
 * @author Daniela
 */
import progettofarfalla.View.Graphics.GraphicsComponents.GraphicsComponent;
import progettofarfalla.View.Graphics.SwingGraphics;
import progettofarfalla.Model.Inputs.InputComponent;
import progettofarfalla.Commons.*;
import progettofarfalla.Model.World.Bounds.*;
import progettofarfalla.Model.World.Physics.*;
import progettofarfalla.Model.World.World;

public interface GameObject {
  			
    public void setPos(P2d pos);

    public void setVel(V2d vel);

    public void flipVelOnY();

    public void flipVelOnX();

    public void setBBox(P2d pos);

    public BoundingBox getBBox();

    public P2d getCurrentPos();

    public V2d getCurrentVel();

    public void updateInput();

    public void updatePhysics(long dt, World w);

    public void updateGraphics(SwingGraphics g);

    public InputComponent getInputComponent();

    public PhysicsComponent getPhysics();

    public GraphicsComponent getGraphicsComponent();

    public double getDirectionAngle();
           
}
