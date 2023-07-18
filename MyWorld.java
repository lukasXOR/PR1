import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private static int screenHeight = 400;
    private static int screenWidth = 600;

    private static int ballHeight = 25;
    private static int ballWidth = 25;

    private static int obstacleHeight = 100;
    private static int obstacleWidth = 10;
    
    public static int speed = 1;
    
    public Counter score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(screenWidth, screenHeight, 1); 
        this.speed = 1;
        addObject(new bird(ballHeight, ballWidth), screenWidth / 10, screenHeight / 2);
        score = new Counter("Score : ");
        addObject(score, 60, 20);
        addObstacles(10, 150);
    }
    
    public void addObstacles(int numOfObs, int startP) {
        for (int i = 0, startPos = startP; i < numOfObs; i++, startPos += 100) {
            int topOffset = ran(50, 70);
            addObject(new obstacle(obstacleHeight + topOffset, obstacleWidth), startPos, (obstacleHeight + topOffset) / 2);
            
            int bottomOffset = ran(50, 100); 
            addObject(new obstacle(obstacleHeight + bottomOffset, obstacleWidth), startPos, screenHeight - ((obstacleHeight + bottomOffset) / 2));
        }
    }
    public void add() {
        score.add(this.speed);
        if (score.target % 1000 == 0) {
            this.speed += 1;
        }
    }
    public int ran(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
}
