import greenfoot.*;
/**
 * Write a description of class obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class obstacle extends Actor
{
    private GreenfootImage image;
    private int height;
    private int width;
    /**
     * Constructor for objects of class bird
     */
    public obstacle(int height, int width)
    {   
        this.width = width;
        this.height = height;
        
        image = new GreenfootImage(this.width, this.height);
        image.setColor(Color.BLUE);
        image.fill();
        setImage(image);
    }
    public void act() {
        MyWorld game = (MyWorld) getWorld();
        setLocation(getX() - game.speed, getY());
        if (getX() == 0) {
            getWorld().removeObject(this);
            game.addObstacles(1, 500);
        }
    }
}
