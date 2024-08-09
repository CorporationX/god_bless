package faang.school.godbless.task.database.optimization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataCenterTest {
    private Server server1 = new Server();
    private Server server2 = new Server();
    private Server server3 = new Server();

    private DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter(new LinkedList<>());
    }

    @Test
    void testAddServer() {
        dataCenter.addServer(server1);
        assertEquals(server1, dataCenter.getNextServer());
    }

    @Test
    void testRemoveServer() {
        dataCenter.addServer(server1);
        dataCenter.removeServer(server1);
        assertThrows(NoSuchElementException.class, () -> dataCenter.getNextServer());
    }

    @Test
    void testGetNextServer() {
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
        dataCenter.addServer(server3);
        assertEquals(server1, dataCenter.getNextServer());
        assertEquals(server2, dataCenter.getNextServer());
        assertEquals(server3, dataCenter.getNextServer());
    }
}
