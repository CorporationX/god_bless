package school.faang.task_45026.repository;

import lombok.Getter;
import school.faang.task_45026.entity.Server;

import java.util.ArrayList;
import java.util.List;

//не уверен, что это хорошая практика делать такой геттер,
//может лучше сделать возврат копии/неизменяемого списка для геттера
@Getter
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }
}
