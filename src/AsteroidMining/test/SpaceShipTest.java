package src.AsteroidMining.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.AsteroidMining.Carbon;
import src.AsteroidMining.Resource;
import src.AsteroidMining.SpaceShip;

class SpaceShipTest {

    private SpaceShip spaceShip;
    private Resource resource;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        spaceShip = new SpaceShip();
        resource = new Carbon();
    }

    @Test
    void testAddResource_withCapacityAvailable_shouldAddResource() {
        assertTrue(spaceShip.addResource(resource));
        assertEquals(1, spaceShip.countResource(resource.getId()));
    }

    @Test
    void testAddResource_withCapacityFull_shouldNotAddResource()  {
        // Fill up the spaceShip's inventory to its maximum capacity ( 10 )
        for (int i = 1; i<=10 ; i++){
            spaceShip.addResource(resource);
        }

        assertFalse(spaceShip.addResource(resource));
        assertEquals(10, spaceShip.countResource(resource.getId()));
    }

    @Test
    void testRemoveResource_withExistingResource_shouldRemoveResource() {
        // Add the resource to the spaceShip's inventory
        spaceShip.addResource(resource);

        assertTrue(spaceShip.removeResource(resource));
        assertEquals(0, spaceShip.countResource(resource.getId()));
    }

    @Test
    void testRemoveNonExistingResource_shouldNotRemoveResource() {
        assertFalse(spaceShip.removeResource(resource));
    }

    @Test
    void testRemoveResourceById_shouldRemoveResource() {
        // Add 1 resource to the spaceShip's inventory
        spaceShip.addResource(resource);

        assertTrue(spaceShip.removeResource(resource.getId(), 1));
        assertEquals(0, spaceShip.countResource(resource.getId()));
    }

    @Test
    void testRemoveResourceById_wrongParam_shouldNotRemoveResource() {
        // Add 1 resource to the spaceShip's inventory
        spaceShip.addResource(new Carbon());

        //Problem: no validation for 2nd parameter, it can be anything
        assertFalse(spaceShip.removeResource(resource.getId(), -10));
        assertEquals(1, spaceShip.countResource(resource.getId()));
    }

    @Test
    void testCountResource_withExistingResource_shouldReturnCount() {
        // Add the resource to the spaceShip's inventory
        spaceShip.addResource(resource);

        assertEquals(1, spaceShip.countResource(resource.getId()));
    }

    @Test
    void testCountResource_withNonExistingResource_shouldReturnZero() {
        assertEquals(0, spaceShip.countResource(resource.getId()));
    }

    @Test
    void testGetResource_withExistingResource_shouldReturnResource() {
        // Add the resource to the spaceShip's inventory
        spaceShip.addResource(resource);

        assertEquals(resource, spaceShip.getResource(resource.getId()));
    }

    @Test
    void testGetResource_withNonExistingResource_shouldReturnNull() {
        assertNull(spaceShip.getResource(resource.getId()));
    }

    @Test
    void testCheckCapacity_withInventoryBelowCapacity_shouldReturnTrue() {
        assertTrue(spaceShip.checkCapacity());
    }

    @Test
    void testCheckCapacity_withInventoryAtCapacity_shouldReturnTrue() {
        // Fill up the spaceShip's inventory to its maximum capacity ( 10 )
        for (int i = 1; i<=10 ; i++){
            spaceShip.addResource(resource);
        }

        assertTrue(spaceShip.checkCapacity());
    }
}
