package faang.school.godbless.javaHashMap.dataCenter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers;

    public DataCenter() {
        servers = new ArrayList<>();

        servers.add(new Server(0, 100, 25));
        servers.add(new Server(0, 100, 25));
        servers.add(new Server(0, 100, 25));
        servers.add(new Server(0, 120, 30));
        servers.add(new Server(12, 120, 30));
    }
}
