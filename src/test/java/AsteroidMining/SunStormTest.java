package AsteroidMining;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SunStormTest {
    Random rand = new Random();
    Handler h = new Handler();

    @Test
    void SettlerCollidesDies() {
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);
        int d = rand.nextInt(100);

        ID resourceId = ID.Inventory;
        Resource r = new Resource(resourceId);

        Asteroid a1 = new Asteroid(x,y,r,d);
        Settler s1 = new Settler(x,y,h);

        SunStorm testObject = new SunStorm(1,1,2);
        a1.addVisitor(s1);

        testObject.collisionWith(a1);

        boolean testStatus = a1.visitors.get(0).isAlive();

        assertEquals(testStatus, false);
    }

    @Test
    void RobotCollidesDies() {
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);
        int d = rand.nextInt(100);

        ID resourceId = ID.Inventory;
        Resource r = new Resource(resourceId);

        Asteroid a1 = new Asteroid(x, y, r, d);
        Robot r1 = new Robot(x, y);

        SunStorm testObject = new SunStorm(1, 1, 2);
        a1.addVisitor(r1);

        testObject.collisionWith(a1);

        boolean testStatus = a1.visitors.get(0).isAlive();

        assertEquals(testStatus, false);
    }

    @Test
    void RobotCollidesStaysAlive() {
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);
        int d = rand.nextInt(100);

        ID resourceId = ID.Inventory;
        Resource r = new Resource(resourceId);

        Asteroid a1 = new Asteroid(x,y,r,d);
        Robot r1 = new Robot(x,y);
        r1.getDamage(-100); //add health to the robot

        SunStorm testObject = new SunStorm(1,1,2);
        a1.addVisitor(r1);

        testObject.collisionWith(a1);

        boolean testStatus = a1.visitors.get(0).isAlive();

        assertEquals(testStatus, true);
    }
}