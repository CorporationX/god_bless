package faang.school.godbless.task.database.optimization;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class DataCenter {
    private final LinkedList<Server> servers;

    public List<Server> getServers() {
        if (servers.isEmpty()) {
            serversListIsEmptyExceptionThrow();
        }
        return servers;
    }

    public void addServer(Server server) {
        serverValidOrNullPointerExceptionThrow(server);
        servers.add(server);
    }

    public void removeServer(Server server) {
        serverValidOrNullPointerExceptionThrow(server);
        if (!servers.contains(server)) {
            serverNotFoundExceptionThrow(server);
        }
        servers.remove(server);
    }

    public Server getNextServer() {
        if (servers.isEmpty()) {
            serversListIsEmptyExceptionThrow();
        }
        Server server = servers.getFirst();
        servers.removeFirst();
        servers.add(server);
        return servers.getLast();
    }

    public void serverValidOrNullPointerExceptionThrow(Server server) {
        if (server == null) {
            throw new NullPointerException("Сервер не может быть null");
        }
    }

    private void serverNotFoundExceptionThrow(Server server) {
        throw new NoSuchElementException("Сервер %s не найден".formatted(server));
    }

    private void serversListIsEmptyExceptionThrow() {
        throw new NoSuchElementException("Список серверов пуст");
    }
}
