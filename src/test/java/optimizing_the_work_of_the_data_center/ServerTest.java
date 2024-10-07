package optimizing_the_work_of_the_data_center;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {
    private Server server;

    @BeforeEach
    void setUp() {
        server = new Server(100, 200);
    }

    @Test
    void testAllocateLoadSuccessful() {
        assertTrue(server.allocateLoad(50));
        assertEquals(50, server.getLoad());

        assertTrue(server.allocateLoad(50));
        assertEquals(100, server.getLoad());
    }

    @Test
    void testAllocateLoadExceedsMaxLoad() {
        assertFalse(server.allocateLoad(120));
        assertEquals(0, server.getLoad());
    }

    @Test
    void testAllocateLoadEdgeCase() {
        assertTrue(server.allocateLoad(100));
        assertEquals(100, server.getLoad());
    }

    @Test
    void testAllocateLoadWhenPartiallyFull() {
        assertTrue(server.allocateLoad(30));
        assertEquals(30, server.getLoad());

        assertTrue(server.allocateLoad(50));
        assertEquals(80, server.getLoad());

        assertFalse(server.allocateLoad(30));
        assertEquals(80, server.getLoad());
    }

    @Test
    void testReleaseLoad() {
        server.allocateLoad(80);
        assertEquals(80, server.getLoad());

        server.releaseLoad(30);
        assertEquals(50, server.getLoad());

        server.releaseLoad(50);
        assertEquals(0, server.getLoad());
    }

    @Test
    void testReleaseLoadMoreThanAllocated() {
        server.allocateLoad(50);
        assertEquals(50, server.getLoad());

        server.releaseLoad(70);
        assertEquals(0, server.getLoad());
    }

    @Test
    void testReleaseLoadOnEmptyServer() {
        server.releaseLoad(50);
        assertEquals(0, server.getLoad());
    }
}