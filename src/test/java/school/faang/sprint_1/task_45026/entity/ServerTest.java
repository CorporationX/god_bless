package school.faang.sprint_1.task_45026.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {
    private Server server;

    @BeforeEach
    void setUp() {
        double maxLoad = 1000.0;
        server = new Server(maxLoad);
    }

    @Test
    void addLoad_FullLoad() {
        double input = 1000.0;
        double expectedResult = 0.0;
        double expectedServerLoad = 1000.0;

        double result = server.addLoad(input);

        assertEquals(expectedResult, result);
        assertEquals(expectedServerLoad, server.getLoad());
    }

    @Test
    void addLoad_PartialLoad() {
        double input = 850.0;
        double expectedResult = 0.0;
        double expectedServerLoad = 850.0;

        double result = server.addLoad(input);

        assertEquals(expectedResult, result);
        assertEquals(expectedServerLoad, server.getLoad());
    }

    @Test
    void addLoad_OverLoad() {
        double input = 1500.0;
        double expectedResult = 500.0;
        double expectedServerLoad = 1000.0;

        double result = server.addLoad(input);

        assertEquals(expectedResult, result);
        assertEquals(expectedServerLoad, server.getLoad());
    }

    @Test
    void releaseLoad_FullRelease() {
        double inputLoad = 1000.0;
        double inputRelease = 1000.0;
        double expectedResult = 0.0;
        double expectedServerLoad = 0.0;

        server.addLoad(inputLoad);

        double result = server.releaseLoad(inputRelease);

        assertEquals(expectedResult, result);
        assertEquals(expectedServerLoad, server.getLoad());
    }

    @Test
    void releaseLoad_PartialRelease() {
        double inputLoad = 1000.0;
        double inputRelease = 850.0;
        double expectedResult = 0.0;
        double expectedServerLoad = 150.0;

        server.addLoad(inputLoad);

        double result = server.releaseLoad(inputRelease);

        assertEquals(expectedResult, result);
        assertEquals(expectedServerLoad, server.getLoad());
    }

    @Test
    void releaseLoad_OverRelease() {
        double inputLoad = 1000.0;
        double inputRelease = 1500.0;
        double expectedResult = 500.0;
        double expectedServerLoad = 0.0;

        server.addLoad(inputLoad);

        double result = server.releaseLoad(inputRelease);

        assertEquals(expectedResult, result);
        assertEquals(expectedServerLoad, server.getLoad());
    }
}