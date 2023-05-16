package src.AsteroidMining.test;

import org.junit.jupiter.api.Test;
import src.AsteroidMining.ID;
import src.AsteroidMining.Resource;

import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

class ResourceTest {

    @Test
    void testGetImg_ReturnsNullInitially() {
        ID resourceId = ID.Inventory;
        Resource resource = new Resource(resourceId);

        BufferedImage img = resource.getImg();

        assertNull(img);
    }
}