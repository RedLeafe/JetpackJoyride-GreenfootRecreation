import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int delay = 5;
    int increase = 0;
    int zapperStartY = (int)(Math.random() * 200) + 50;
    int zapper1StartY = (int)(Math.random() * 200) + 50;
    static int points;
    static int count;
    static int coinCount;
    public static int highScore = 0;
    String score;
    String coins;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.        
        super(800, 300, 1, false);
        setUp();         
    }

    public void act() {
        if (increase >= delay && !getObjects(Barry.class).isEmpty()){
            points++;
            increase = 0;
        }
        increase++;
        updateScore();
        if (ReplayButton.getClicked() == true){
            setUp();
            ReplayButton.setClicked(false);
        }
        if (getObjects(Barry.class).isEmpty()){        
            Barry.Steps.stop();
            Barry.MachineGun.stop();
        }
    }

    public void placeBackground(int scaleX, int scaleY, int X, int Y){
        Background bk = new Background();
        GreenfootImage back = bk.getImage();  
        back.scale(scaleX, scaleY);
        bk.setImage(back);
        addObject(bk, X, Y);
    }

    public void updateScore() {
        if (!getObjects(Barry.class).isEmpty()){
            showText("Score: " + points,60,15);
            showText("Coins: " + coinCount,60,35);
            showText("",400,115);
            showText("",400,145);
            showText("",400,85);
        } else{
            showText("",60,15);
            showText("",60,35);
            showText("Score: " + points,400,115);
            showText("Coins: " + coinCount,400,145);
            if (points > highScore)
                highScore = points;
            showText("High Score: " + highScore, 400, 85);
        }
    }
    
    public static int getScore(){
        return points;
    }

    public static int getCount(){
        return count;
    }

    public static void setCount(int c){
        count = c;
    }

    public static int getCoinCount(){
        return coinCount;
    }

    public static void setCoinCount(int c){
        coinCount = c;
    }

    public void setUp(){     
        removeObjects(getObjects(Zapper.class));
        removeObjects(getObjects(Background.class));   
        removeObjects(getObjects(EndScreen.class));
        placeBackground(800, 380, 400, 150);
        placeBackground(800, 380, 1180, 150);        
        points = 0;
        coinCount = 0;
        count = 0;
        Barry b = new Barry();
        addObject(b,300,275);
        Zapper z = new Zapper();
        addObject(z,870,zapperStartY);           
        EndScreen e = new EndScreen();
        GreenfootImage endScreen = e.getImage();  
        endScreen.scale(280, 200);
        e.setImage(endScreen);
        addObject(e, 1000, 1000);    
        ReplayButton r = new ReplayButton();
        addObject(r, 1000, 1000);    
        MainScreenButton m = new MainScreenButton();
        GreenfootImage mainScreen = m.getImage();  
        mainScreen.scale(80, 50);
        m.setImage(mainScreen);
        addObject(m, 1200, 1000); 
        updateScore();
    }
}
