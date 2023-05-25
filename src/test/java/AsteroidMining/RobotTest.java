package AsteroidMining;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    private Robot r;
    private Asteroid a1, a2;

    @BeforeEach
    void init() {
        r = new Robot();
        a1 = new Asteroid(1, 1, new Carbon(), 2);
        a2 = new Asteroid(1, 1, new Carbon(), 0);
        a2.addNeighbour(a1);
        a1.addNeighbour(a2);
    }

    @Test
    public void testHideSuccess(){
        r.setPlace(a2);
        a2.removeResource();
        assertTrue(a2.isHollow());
        r.hide();
        assertTrue(r.isHidden());
    }

    @Test
    public void testHideNoSuccess(){
        r.setPlace(a1);
        assertFalse(a1.isHollow());
        r.hide();
        assertFalse(r.isHidden());
    }

    @Test
    public void testDrill() {
        r.setPlace(a1);
        assertTrue(r.drill());
    }

    @Test
    public void testDrillOnFullyDrilled() {
        r.setPlace(a2);
        //so it says it is not fully drilled even when depth is 0
        assertFalse(r.drill());
    }

    @Test
    public void testDrillWithNoAsteroid() {
        assertFalse(r.drill());
    }

    @Test
    public void testTravel() {
        //will fail since no constructor for robot with handler available, needed for travel() method
        r.setPlace(a1);
        r.travel();
        assertEquals(r.getPlace(), a2);
    }
}
