import greenfoot.*;
/**
 * Write a description of class bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bird extends Actor
{  
    private GreenfootImage image;
    private int height;
    private int width;
    private int speed = 1;
    /**
     * Constructor for objects of class bird
     */
    public bird(int height, int width)
    {   
        this.width = width;
        this.height = height;
        
        image = new GreenfootImage(this.width, this.height);
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
    }
    public void act() {
        if (Greenfoot.isKeyDown("down") && !isAtEdge()) {
            setLocation(getX(), getY() + 1);
        }
        if (Greenfoot.isKeyDown("up") && !isAtEdge()) {
            setLocation(getX(), getY() - 1);
        }
        collisionDectection();
    }
    public void collisionDectection() {
        if (isTouching(obstacle.class)) {
            MyWorld game = (MyWorld) getWorld();
            game.score.setPrefix("Game Over. Your score: ");
            Greenfoot.stop();
        } else {
            MyWorld game = (MyWorld) getWorld();
            game.add();
        }
    }
}
