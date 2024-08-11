import faang.school.godbless.BJS2_19559.Server;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServerTest {

    @Test
    public void testAllocateResources() {
        Server server = new Server(100.0, 50.0);
        server.allocate(30.0);
        assertEquals(30.0, server.getLoad());
    }

    @Test
    public void testCannotAllocateOverMaxLoad() {
        Server server = new Server(100.0, 50.0);
        assertThrows(IllegalArgumentException.class, () -> server.allocate(120.0));
    }
}