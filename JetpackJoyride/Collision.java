import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * This class contains two methods for pixel-perfect collision-detection
 * 
 * @author (Busch2207 (Moritz L.)) 
 * @version (09.11.2013)
 */
public class Collision extends Actor
{
    /** This method is a pixel perfect collision detection. Returns a List of all Actors, that are touched by this object */
    public List getTouchedObjects(Class clss)
    {
        List<Actor> list =
            getWorld().getObjects(clss),
        list2 = new ArrayList();
        for(Actor A : list)
            if(A!=this && intersects(A) && touch(A))
                list2.add(A);
        return list2;
    }

    /** This method is a pixel perfect collision detection. Return, if it intersects an actor of the given class */
    public boolean touch(Class clss)
    {
        List<Actor> list =
            getWorld().getObjects(clss),
        list2 = new ArrayList();
        for(Actor A : list)
            if(A!=this && intersects(A) && touch(A))
                return true;
        return false;
    }

    /** This method is a pixel perfect collision detection. It returns a touched actor of the given class, if there's one touched. */
    public Actor getOneTouchedObject(Class clss)
    {
        List<Actor> list =
            getWorld().getObjects(clss),
        list2 = new ArrayList();
        for(Actor A : list)
            if(A!=this && intersects(A) && touch(A))
                return A;
        return null;
    }

    /** This method is a pixel perfect collision detection. Returns true, if the object touchs the given Actor */
    public boolean touch(Actor a_big)
    {
        Actor a_small;
        if(getImage().getWidth()*getImage().getHeight()>a_big.getImage().getHeight()*a_big.getImage().getWidth())
        {
            a_small=a_big;
            a_big=this;
        }
        else
            a_small=this;

        int i_hypot=(int)Math.hypot(a_small.getImage().getWidth(),a_small.getImage().getHeight());

        GreenfootImage i=new GreenfootImage(i_hypot,i_hypot);
        i.drawImage(a_small.getImage(),i_hypot/2-a_small.getImage().getWidth()/2,i_hypot/2-a_small.getImage().getHeight()/2);
        i.rotate(a_small.getRotation());
        int w=i_hypot;

        GreenfootImage Ai = a_big.getImage(),
        i2=new GreenfootImage(i_hypot=(int)Math.hypot(Ai.getWidth(),Ai.getHeight()),i_hypot);
        i2.drawImage(Ai,i2.getWidth()/2-Ai.getWidth()/2,i2.getHeight()/2-Ai.getHeight()/2);
        i2.rotate(a_big.getRotation());
        Ai=i2;

        int
        x_Offset=a_big.getX()-a_small.getX()-(Ai.getWidth()/2-w/2),
        y_Offset=a_big.getY()-a_small.getY()-(Ai.getHeight()/2-w/2);

        boolean b = true;
        for(int yi =Math.max(0,y_Offset); yi<w && yi<i_hypot+y_Offset && b; yi++)
            for(int xi =Math.max(0,x_Offset); xi<w && xi<i_hypot+x_Offset && b; xi++)
                if(Ai.getColorAt(xi-x_Offset,yi-y_Offset).getAlpha()>0 && i.getColorAt(xi,yi).getAlpha()>0)
                    b=false;
        return !b;
    }
}
