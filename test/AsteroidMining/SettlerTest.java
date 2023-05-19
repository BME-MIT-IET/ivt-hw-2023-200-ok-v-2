package test.AsteroidMining;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.AsteroidMining.*;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class SettlerTest {

    private Settler s;
    private Asteroid a1, a2, a3, a4;

    @BeforeEach
    void init() {
        s = new Settler(1, 1, new Handler());
        a1 = new Asteroid(1, 1, new Uranium(), 2);
        a2 = new Asteroid(2, 2, new Iron(), 0);
        a3 = new Asteroid(2, 2, new WaterIce(), 0);
        a4 = new Asteroid(2, 2, new Carbon(), 0);
        a2.addNeighbour(a1);
        a1.addNeighbour(a2);
        a4.addNeighbour(a1);
    }

    @Test
    public void testHideSuccess(){
        s.setPlace(a2);
        a2.removeResource();
        assertTrue(a2.isHollow());
        s.hide();
        assertTrue(s.isHidden());
    }

    @Test
    public void testHideFail(){
        s.setPlace(a1);
        assertFalse(a1.isHollow());
        s.hide();
        assertFalse(s.isHidden());
    }

    @Test
    public void testFillSuccess(){
        s.setPlace(a2);
        s.drill();
        s.mine();
        assertTrue(s.fillAsteroid());
    }

    @Test
    public void testFillFail(){
        s.setPlace(a1);
        s.drill();
        s.mine();
        assertFalse(s.fillAsteroid());
    }

    @Test
    public void testDrill() {
        s.setPlace(a1);
        assertFalse(a1.isFullyDrilled());

        s.drill();
        assertTrue(a1.isFullyDrilled());
    }

    @Test
    public void testFullyDrilled() {
        s.setPlace(a2);
        assertTrue(a2.isFullyDrilled());
        //so it says it is not fully drilled even when depth is 0
        assertFalse(s.drill());
    }

    @Test
    public void testDrillWithNoAsteroid() {
        assertFalse(s.drill());
    }

    @Test
    public void testMineOK() {
        s.setPlace(a1);
        s.drill();
        assertTrue(s.mine());
    }

    @Test
    public void testMineFail() {
        s.setPlace(a1);
        a1.removeResource();
        s.drill();
        assertFalse(s.mine());
    }

    @Test
    public void testTravel() {
        //failing test because of the fact that the neighbour list is empty??
        //why?
        s.setPlace(a1);
        s.travel();
        assertEquals(s.getPlace(), a2);
    }

    @Test
    public void buildRobot() {
        Asker asker = mock(Asker.class);
        when(asker.ask(anyString())).thenReturn("yes");

        s.setPlace(a1);
        s.drill();
        s.mine();

        s.setPlace(a2);
        s.mine();

        s.setPlace(a4);
        s.mine();

        assertTrue(s.buildRobot());
        assertTrue(a3.getNeighbour().getVisitors().contains(Robot.class));
    }

    @Test
    public void buildRobotFail() {
        assertFalse(s.buildRobot());
    }

    @Test
    public void buildGate(){
        Asker asker = mock(Asker.class);
        when(asker.ask(anyString())).thenReturn("yes");

        s.setPlace(a1);
        s.drill();
        s.mine();

        s.setPlace(a2);
        s.mine();

        s.setPlace(a3);
        s.mine();

        assertTrue(s.buildTeleportationGates());
        s.deployGate();

        assertEquals(a3.getNeighbour().getClass(), TeleportationGate.class);
    }

    @Test
    public void buildGateFail() {
        assertFalse(s.buildTeleportationGates());
    }
}
