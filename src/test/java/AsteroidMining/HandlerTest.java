package src.AsteroidMining;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {
    SunStorm obj1 = new SunStorm(1,1,1);
    SunStorm obj2 = new SunStorm(1,1,1);

    @Test
    void testAddObject() {
        Handler h = new Handler();

        h.addObject(obj1);
        assertEquals(h.objects.contains(obj1),true);
        assertEquals(h.objects.getFirst().getId(),obj1.getId());
    }

    @Test
    void testRemoveObject() {
        Handler h = new Handler();

        h.addObject(obj1);
        h.addObject(obj2);

        assertEquals(h.objects.contains(obj1),true);
        h.removeObject(obj1);

        assertEquals(h.objects.contains(obj1),false);
    }

    @Test
    void testCheckAsteroids() {
        ID resourceId = ID.Inventory;
        Resource resource = new Resource(resourceId);
        RadioActiveAsteroid obj3 = new RadioActiveAsteroid(1,1,resource,0);
        // depth = 0, Radio active Asteroid should explode upon checking

        Handler h = new Handler();

        h.addObject(obj1);
        h.addObject(obj3);
        h.checkAsteroids();

        assertEquals(h.objects.contains(obj3),false);
    }
}