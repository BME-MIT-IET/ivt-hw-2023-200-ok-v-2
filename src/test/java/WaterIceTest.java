package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.*;

import static org.junit.jupiter.api.Assertions.*;

class WaterIceTest {

    @Test
    void sublimeTest() {
        Asteroid asteroid = new Asteroid(700, 250, new WaterIce(), 10);
        WaterIce waterIce = (WaterIce) asteroid.getResource();

        waterIce.sublime(asteroid);

        assertTrue(asteroid.isHollow());
        assertNull(asteroid.getResource());
    }
}