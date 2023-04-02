import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barry extends Collision
{
    int velY, delayI, delayD, delay, increase, timer, coinCount, barryY, zapperY, summonRocket, summonSpin, gifDelay, gifTimer, currentImage, gifDelay1;
    boolean first, nextZap;
    int originalX = 870;
    String[] images = {"Barry1.png", "Barry2.png"};
    String[] images1 = {"FlyingBarry1.png", "FlyingBarry2.png"};
    static GreenfootSound Steps = new GreenfootSound("Steps.mp3");
    static GreenfootSound MachineGun = new GreenfootSound("MachineGun.mp3");
    public Barry() {
        velY = 1;
        delayI = 5;
        delayD = 3;
        delay = 750;
        increase = 0;
        timer = 0;
        coinCount = 0;        
        gifDelay = 20;
        gifDelay1 = 5;
        gifTimer = 0;
        currentImage = 0;
        first = true;
        nextZap = false;
    }

    public void act() 
    {
        zapperY = (int)(Math.random() * 150) + 55;
        summonRocket = (int)(Math.random() * 600);
        summonSpin = (int)(Math.random() * 40);
        increase++;
        timer++;
        checkKeyPress();   
        if (summonRocket == 1 || timer >= delay){
            RocketWarning r = new RocketWarning(this);
            getWorld().addObject(r, 750, getY());
            timer = 0;
        }
        spawnZapper();
    }    

    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("space")){     
            if (velY < 0)
                velY = 0;
            if (velY < 6 && (increase > delayI)){
                velY = velY + 1;
                increase = 0;
            }
            if (getY() > 19)
                setLocation(getX(), getY() - velY);
            else
                setLocation(getX(), 19);
            animationFlying();
            Steps.stop();
            MachineGun.playLoop();
        }    
        else if (getY() < 275){
            if (getY() <= 19)
                velY = 0;
            if (velY > -6 && (increase > delayD)){
                if (velY == 0)
                    delayD = 5;
                else
                    delayD = 3;
                velY = velY - 1;
                increase = 0;
            }
            setLocation(getX(), getY() - velY);
            Steps.stop();
            MachineGun.stop();
        }
        else if (getY() >= 275){
            setLocation(getX(), 275);   
            animationRunning();
            Steps.playLoop();
            MachineGun.stop();
        }
        barryY = getY();
    }

    public boolean check(){
        if (getWorld().getObjects(Zapper.class) == null || getWorld().getObjects(Zapper.class).size() == 0)
            return true;
        if ((originalX - getWorld().getObjects(Zapper.class).get(getWorld().getObjects(Zapper.class).size() - 1).getX()) >= 300){
            return true;
        }
        return false;
    }

    public boolean coinCheck(){
        if (getWorld().getObjects(Coin.class) == null || getWorld().getObjects(Coin.class).size() == 0)
            return true;
        if ((originalX - getWorld().getObjects(Coin.class).get(getWorld().getObjects(Coin.class).size() - 1).getX()) >= 35){
            return true;
        }
        return false;
    }

    public void spawnZapper(){        
        if (check() == true){
            if (MyWorld.getCount() < 15){
                if (getWorld().getObjects(Coin.class).isEmpty()){
                    MyWorld.setCount(MyWorld.getCount() + 1);
                    if (summonSpin == 1 && nextZap == false){
                        SpinZapper s = new SpinZapper();                       
                        getWorld().addObject(s,870,zapperY);
                        nextZap = true;
                    }
                    else{
                        Zapper z = new Zapper();
                        getWorld().addObject(z,870,zapperY);
                        nextZap = false;
                    }
                }
            }
            else{
                coinSetupBox();
                MyWorld.setCount(0);
            }
        }
    }

    public void coinSetupBox(){
        for (int row = 0; row < 5; row++){
            for (int col = 0; col < 5; col++){
                Coin c = new Coin();
                getWorld().addObject(c,1000 - (row * 45),200 - (col * 35));                
            }
        }
    }

    public void animationRunning(){
        timer++;
        if (timer >= gifDelay){
            timer = 0;
            currentImage++;
            if (currentImage >= images.length){
                currentImage = 0;
            }
            setImage(images[currentImage]);
        }
    }

    public void animationFlying(){
        timer++;
        if (timer >= gifDelay1){
            timer = 0;
            currentImage++;
            if (currentImage >= images1.length){
                currentImage = 0;
            }
            setImage(images1[currentImage]);
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX() - 3,getY() + 23);
        }
    }
}
