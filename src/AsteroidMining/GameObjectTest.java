package src.AsteroidMining;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {

    @Test
    void getBounds() {
        SunStorm testObject = new SunStorm(1,2,3);
        Random rand = new Random();

        int x = rand.nextInt(100);
        int y = rand.nextInt(100);

        testObject.width = x;
        testObject.height = y;

        Rectangle r = new Rectangle(1,2,x,y);

        assertEquals(testObject.getBounds(), r);
    }

    @Test
    void getX() {
        Random rand = new Random();
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);

        SunStorm testObject = new SunStorm(x,y,3);

        assertEquals(testObject.x, x);
    }

    @Test
    void getY() {
        Random rand = new Random();
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);

        SunStorm testObject = new SunStorm(x,y,3);

        assertEquals(testObject.y, y);
    }

    @Test
    void getId() {
        SunStorm testObject = new SunStorm(1,2,3);
        ID Id = ID.Inventory;
        testObject.setId(Id);

        assertEquals(testObject.getId(), Id);
    }

    @Test
    void NOTgetBounds() {
        SunStorm testObject = new SunStorm(1,2,3);
        Random rand = new Random();

        int x = rand.nextInt(100);
        int y = rand.nextInt(100);

        testObject.width = x;
        testObject.height = y;

        Rectangle r = new Rectangle(1,2,x+1,y);

        assertNotEquals(testObject.getBounds(), r);
    }

    @Test
    void NOTgetX() {
        Random rand = new Random();
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);

        SunStorm testObject = new SunStorm(x,y,3);

        assertNotEquals(testObject.x, x+1);
    }

    @Test
    void NOTgetY() {
        Random rand = new Random();
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);

        SunStorm testObject = new SunStorm(x,y,3);

        assertNotEquals(testObject.y, y+1);
    }

    @Test
    void NOTgetId() {
        SunStorm testObject = new SunStorm(1,2,3);
        ID Id = ID.Inventory;

        assertNotEquals(testObject.getId(), Id);
    }
}