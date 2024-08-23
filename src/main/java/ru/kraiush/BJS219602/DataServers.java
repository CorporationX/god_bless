package ru.kraiush.BJS219602;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataServers {

    public List<Server> getServers() {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server(1, 100, 1000));
        servers.add(new Server(2,   200, 2000));
        servers.add(new Server(3,  300, 3000));
        servers.add(new Server(4,  400, 4000));

        return servers;
    }
}

