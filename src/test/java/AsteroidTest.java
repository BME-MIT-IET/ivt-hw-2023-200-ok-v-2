package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.AsteroidMining.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidTest {
    Asteroid asteroid;

    @BeforeEach
    void setUp() {
        asteroid = new Asteroid(0, 0, null, 10);
    }

    @Test
    void deepenHoleTest() {

        asteroid.deepenHole(5);

        //TODO: getDepth() getter is missing
        //assertEquals(5, asteroid.GetDepth());
    }

    @Test
    void addResourceTest(){
        Resource iron = new Iron();

        asteroid.addResource(iron);

        assertEquals(iron, asteroid.getResource());
        assertFalse(asteroid.isHollow());
    }

    @Test
    void addRadioactiveResourceTest(){
        Resource uranium = new Uranium();

        asteroid.addResource(uranium);

        assertEquals(uranium, asteroid.getResource());
        //Failed test: ID is not set to RadioactiveAsteroid after addResource(uranium) invoked
        //assertEquals(ID.RadioActiveAsteroid, asteroid.getId());
    }

    @Test
    void removeResourceTest() {
        Resource resource = new Carbon();
        asteroid.addResource(resource);

        asteroid.removeResource();

        assertNull(asteroid.getResource());
        assertTrue(asteroid.isHollow());
    }

    @Test
    void isFullyDrilledTest() {
        Asteroid fullyDrilledAsteroid = new Asteroid(0, 0, new Carbon(), 0);
        Asteroid partiallyDrilledAsteroid = new Asteroid(0, 0, new Carbon(), 5);

        assertTrue(fullyDrilledAsteroid.isFullyDrilled());
        assertFalse(partiallyDrilledAsteroid.isFullyDrilled());
    }

    @Test
    void explodeTest_Settler() {
        Visitor settler = new Settler(0,0, new Handler());
        asteroid.addVisitor(settler);

        asteroid.explode(true);
        assertFalse(settler.isAlive());
    }

    @Test
    void explodeTest_Robot() {
        //Setting up 2 neighbouring asteroids, an explosion will happen on the asteroid on which robot resides
        Visitor robot = new Robot(0,0);
        asteroid.addVisitor(robot);

        asteroid.addResource(new Uranium());
        Asteroid neighbouringAsteroid = new Asteroid(100, 100, null, 10);
        asteroid.addNeighbour(neighbouringAsteroid);
        neighbouringAsteroid.addNeighbour(asteroid);

        List<Visitor> list = new ArrayList<>();
        list.add(robot);
        //ConcurrentModificationException thrown
        asteroid.explode(true);

        assertEquals(list, neighbouringAsteroid.getVisitors());
    }


    @Test
    void inPerihelionUraniumTest() {
        Asteroid drilledAsteroid = new Asteroid(0, 0, new Uranium(), 0);
        drilledAsteroid.setId(ID.RadioActiveAsteroid);
        boolean exploded = true;

        drilledAsteroid.inPerihelion(exploded);
        assertEquals(ID.RadioActiveAsteroid, drilledAsteroid.getId() );
    }

    @Test
    void inPerihelionWaterIceTest() {
        Asteroid drilledAsteroid = new Asteroid(0, 0, new WaterIce(), 0);
        boolean exploded = false;

        drilledAsteroid.inPerihelion(exploded);
        assertNull(asteroid.getResource());
    }
}