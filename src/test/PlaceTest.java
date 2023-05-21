package test.AsteroidMining;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.AsteroidMining.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaceTest {
    Place asteroid1;
    Place asteroid2;
    Place gate;
    Visitor settler;
    Visitor robot;

    @BeforeEach
    void setUp()
    {
        asteroid1 = new Asteroid(0, 0, null, 10);
        asteroid2 = new Asteroid(0, 0, null, 10);
        gate = new TeleportationGate(0, 0 );
        settler = new Settler(0, 0, new Handler());
        robot = new Robot (0,0);
}

    @Test
    void testAddVisitorToAsteroid ()
    {
        asteroid1.addVisitor(settler);
        List<Visitor> visitors = asteroid1.getVisitors();

        assertTrue(visitors.contains(settler));
        assertEquals(asteroid1, settler.getPlace());
    }

    @Test
    void testAddVisitorToGate()
    {
        gate.addVisitor(settler);
        List<Visitor> visitors = gate.getVisitors();

        assertTrue(visitors.contains(settler));
        assertEquals(gate, settler.getPlace());
    }

    @Test
    void testRemoveSettler()
    {
        asteroid1.addVisitor(settler);
        asteroid1.removeVisitor(settler);
        List<Visitor> visitors = asteroid1.getVisitors();

        assertFalse(visitors.contains(settler));
        //settler is not informed he has been removed from asteroid
        assertNull(settler.getPlace());
    }

    @Test
    void testRemoveRobot()
    {
        gate.addVisitor(robot);
        gate.removeVisitor(robot);
        List<Visitor> visitors = gate.getVisitors();

        assertFalse(visitors.contains(robot));
        //robot is not informed he has been removed from asteroid
        assertNull(robot.getPlace());
    }

    @Test
    public void testGetNeighbour() {
        asteroid1.addNeighbour(asteroid2);

        //adding neighbours is one-way
        assertEquals(asteroid2, asteroid1.getNeighbour());
        assertEquals(asteroid1, asteroid2.getNeighbour());
    }

    @Test
    void testAddNeighbour(){
        asteroid1.addNeighbour(asteroid2);
        List<Place> neighbours = asteroid1.getNeighbours();

        assertTrue(neighbours.contains(asteroid2));
    }
}
