/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettofarfalla.Commons;
/**
 *
 * 2-dimensional vector
 * objects are completely state-less
 *
 */
public class V2d implements java.io.Serializable {

    private double x,y;
    private final int STANDARD_VEL = 8;
    private final double DECELERATION_FACTOR = 0.8;

    
    public V2d(double x,double y){
        this.x=x;
        this.y=y;
    }
    
    public V2d(){
    
        RandomGenerator rand = new RandomGenerator();
        int x2;
        int y2;
    
        x2 = rand.RandomBoundedN(0, (int) (Math.pow(STANDARD_VEL, 2)-1));
        y2 = (int) Math.pow(STANDARD_VEL, 2)-x2;
        
        this.x = rand.RandomBoolean()?Math.sqrt(x2):-(Math.sqrt(x2));
        this.y = rand.RandomBoolean()?Math.sqrt(y2):-(Math.sqrt(y2));
    
    }

    public V2d(P2d to, P2d from){
        this.x=to.getX()-from.getX();
        this.y=to.getY()-from.getY();
    }

    public V2d sum(V2d v){
        return new V2d(x+v.x,y+v.y);
    }

    public double module(){
        return (double)Math.sqrt(x*x+y*y);
    }
    
    public void killVel(){
        this.x = 0;
        this.y = 0;
    }

    public V2d getNormalized(){
        double module=(double)Math.sqrt(x*x+y*y);
        return new V2d(x/module,y/module);
    }

    public V2d mul(double fact){
        return new V2d(x*fact,y*fact);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "V2d("+x+","+y+")";
    }
    
    
    public void randomDirection(){
        
        RandomGenerator rand = new RandomGenerator();
        int x2;
        int y2;
    
        x2 = rand.RandomBoundedN(0, (int) (Math.pow(STANDARD_VEL, 2)-1));
        y2 = (int) Math.pow(STANDARD_VEL, 2)-x2;
        
        this.x = rand.RandomBoolean()?Math.sqrt(x2):-(Math.sqrt(x2));
        this.y = rand.RandomBoolean()?Math.sqrt(y2):-(Math.sqrt(y2));
    
    }
    
    public void targetDirection(P2d obj,P2d target){
        
        double x1, x2, x3;
        double y1, y2, y3;
        double distance;
        
        double ratioX, ratioY;
        
        
        x1 = obj.getX();
        y1 = obj.getY();
        
        x2 = target.getX();
        y2 = target.getY();
    
        x3 = x2-x1;
        y3 = y2-y1;
        
        distance = Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2));
        
        ratioX = x3 / distance;
        ratioY = y3 / distance;
        
        this.x = this.STANDARD_VEL*ratioX/4;
        this.y = this.STANDARD_VEL*ratioY/4;
    
    }

    public V2d slowDown(V2d v){
    
        V2d vel = v;
        
        vel = new V2d(vel.x*this.DECELERATION_FACTOR, vel.y*this.DECELERATION_FACTOR);
        
        if( vel.module() < 0.1 ){
        
            vel.killVel();
        }
    
        return vel;
    }
    
    public double getX(){
      
        return this.x;
    }
    
    public double getY(){
      
        return this.y;
    }
}
