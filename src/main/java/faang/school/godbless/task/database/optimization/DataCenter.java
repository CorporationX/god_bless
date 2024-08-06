package faang.school.godbless.task.database.optimization;

import lombok.Data;

import java.util.LinkedList;
import java.util.NoSuchElementException;

@Data
public class DataCenter {
    private LinkedList<Server> servers;

    public DataCenter() {
        servers = new LinkedList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public Server getNextServer() {
        if (servers.isEmpty()) {
            throw new NoSuchElementException("Список серверов пуст");
        }
        Server server = servers.getFirst();
        servers.removeFirst();
        servers.add(server);
        return servers.getLast();
    }
}
