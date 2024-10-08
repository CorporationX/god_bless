package school.faang.data.center;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public List<Server> getServers() {
        return new ArrayList<>(servers);
    }

    public void setServers(List<Server> servers) {
        if (servers == null) {
            throw new IllegalArgumentException("servers не может быть null");
        }
        this.servers = servers;
    }
}
