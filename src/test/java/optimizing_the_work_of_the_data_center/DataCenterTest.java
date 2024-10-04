package optimizing_the_work_of_the_data_center;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterTest {
    DataCenter dataCenter = new DataCenter();

    @AfterEach
    void tearDown() {
        dataCenter.getServers().clear();
    }

    @Test
    void addServer() {
        dataCenter.addServer(new Server(1, 2));
        assertEquals(1, dataCenter.getServers().size());
    }

    @Test
    void removeServer() {
        dataCenter.addServer(new Server(1, 2));
        dataCenter.removeServer(new Server(1, 2));
        assertEquals(0, dataCenter.getServers().size());
    }
}