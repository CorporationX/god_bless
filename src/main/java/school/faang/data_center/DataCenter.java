package school.faang.data_center;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
        private final List<Server> SERVERS = new ArrayList<>();

    public List<Server> getServers() {
        return this.SERVERS;
    }
}
