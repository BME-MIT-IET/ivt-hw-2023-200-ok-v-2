package AsteroidMining;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TeleportationGateTest {
    private TeleportationGate gate1;
    private TeleportationGate gate2;

    @BeforeEach
    void setUp() {
        gate1 = new TeleportationGate();
        gate2 = new TeleportationGate();
    }

    @Test
    void getGateTest_NotSetUp() {
        assertNull(gate1.getGate());
    }

    @Test
    void setGateTest() {
        gate1.setGate(gate2);
        //one way connection gate1 to gate 2
        assertEquals(gate2, gate1.getGate());
        assertNull(gate2.getGate());

        //two-way connected
        gate2.setGate(gate1);
        assertEquals(gate1, gate2.getGate());
    }
}