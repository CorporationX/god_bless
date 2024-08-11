package faang.school.godbless.task.hashmap.database.optimization;

import faang.school.godbless.task.hashmap.database.optimization.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerTest {
    private Server server;

    @BeforeEach
    void setUp() {
        server = new Server();
    }

    @Test
    void testAllocateLoad() {
        double load = 12.3;
        server.allocateLoad(load);
        assertEquals(load, server.getLoad());
    }

    @Test
    void testReleaseLoad() {
        double load = 12.3;
        server.allocateLoad(load);
        server.releaseLoad(load);
        assertEquals(0.0, server.getLoad());
    }
}
