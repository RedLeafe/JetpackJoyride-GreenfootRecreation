import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.*;

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketWarning extends Actor
{
    MyWorld w;
    int rocketY = (int)(Math.random() * 200) + 50;
    int delay;
    int increase;
    boolean first;
    int distance = 0;
    Barry b1 = new Barry();
    static GreenfootSound Missile = new GreenfootSound("Missile.mp3");
    static GreenfootSound MissileLaunch = new GreenfootSound("Missile_Launch.mp3");
    public RocketWarning(Barry b){
        b1 = b;
        delay = 150;
        increase = 0;
        first = true;
    } 

    public void delete()
    {
        getWorld().removeObject(this);
    }

    public void addedToWorld(World world) {
        w = (MyWorld) world;
    }

    public void act() 
    {
        if (!w.getObjects(Barry.class).isEmpty()){
            if (isTouching(RocketWarning.class)){
                Actor rocket = getOneIntersectingObject(RocketWarning.class);
                distance = rocket.getY() - getY();
                if ((rocket.getY() <= 200 || rocket.getY() >= 100) || (getY() <= 200 || getY() >= 100)){
                    if (distance >= 0 && distance <= 40){
                        setLocation(getX(), getY() - ((50 - distance) / 2));   
                        rocket.setLocation(rocket.getX(), rocket.getY() + ((50 - distance) / 2));   
                    } else if (distance < 0 && distance >= -40){
                        setLocation(getX(), getY() + ((50 - distance) / 2));   
                        rocket.setLocation(rocket.getX(), rocket.getY() - ((50 - distance) / 2));   
                    }
                }
                else if (rocket.getY() < 100 || getY() < 100){ 
                    if (distance >= 0 && distance <= 50){
                        setLocation(getX(), getY() + 25);   
                        rocket.setLocation(rocket.getX(), rocket.getY() + 35);   
                    } else if (distance < 0 && distance >= -50){
                        setLocation(getX(), getY() + 35);   
                        rocket.setLocation(rocket.getX(), rocket.getY() + 25);   
                    }
                }
                else if (rocket.getY() > 200 || getY() > 200){ 
                    if (distance >= 0 && distance <= 50){
                        setLocation(getX(), getY() - 35);   
                        rocket.setLocation(rocket.getX(), rocket.getY() - 25);   
                    } else if (distance < 0 && distance >= -50){
                        setLocation(getX(), getY() - 25);   
                        rocket.setLocation(rocket.getX(), rocket.getY() - 35);   
                    }             
                }
            }
            if (b1 != null && delay >= increase){
                if (getObjectsInRange(70, RocketWarning.class).size() > 0){
                    distance = getObjectsInRange(70, RocketWarning.class).get(0).getY() - getY();
                    if (getY() < b1.getY() && distance < 0){
                        setLocation(getX(), getY() + 1);
                    }
                    else if (getY() > b1.getY() && distance > 0){
                        setLocation(getX(), getY() - 1);
                    }
                }
                else{
                    if (getY() < b1.getY()){
                        setLocation(getX(), getY() + 1);
                    }
                    else if (getY() > b1.getY()){
                        setLocation(getX(), getY() - 1);
                    }
                }
            }            
            else{
                Greenfoot.playSound("Missile_Launch.mp3");
                Rocket r1 = new Rocket();
                w.addObject(r1, 800, getY());
                delete();
            }
            if (increase == 120){
                Greenfoot.playSound("Missile.mp3");
            }
            increase++;
        }    
        else{
            delete();
            first = false;
        }
    }
}
