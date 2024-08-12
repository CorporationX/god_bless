package faang.school.gobless.BJS2_19555;

import faang.school.godbless.BJS2_19555.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerTest {
    private Server server;

    @BeforeEach
    void setUp() {
        server = new Server(50.0, 100.0, 200.0);
    }

    @Test
    void testGetAvailableLoad() {
        double expectedValue = 50.0;
        assertEquals(expectedValue, server.getAvailableLoad());
    }

    @Test
    void testIncreaseLoad() {
        server.increaseLoad(20.0);
        double expectedValue = 70.0;
        assertEquals(expectedValue, server.getLoad());
    }

    @Test
    void testDecreaseLoad() {
        server.decreaseLoad(20.0);
        double expectedValue = 30.0;
        assertEquals(expectedValue, server.getLoad());
    }

    @Test
    void testChangeEnergyConsumption() {
        server.changeEnergyConsumption(server.getLoad(), 75.0);
        double expectedValue = 300;
        assertEquals(expectedValue, server.getEnergyConsumption());
    }
}
