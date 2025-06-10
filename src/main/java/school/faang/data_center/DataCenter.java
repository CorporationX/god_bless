package school.faang.data_center;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataCenter {
    @Getter
    private List<Server> serverList;

    public DataCenter() {
        serverList = new ArrayList<>();
    }

    public boolean addServer(Server server) {
        Objects.requireNonNull(server);
        return serverList.add(server);
    }

    public boolean removeServer(Server server) {
        Objects.requireNonNull(server);
        return serverList.remove(server);
    }
}
