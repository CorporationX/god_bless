package faang.school.godbless.task.hashmap.data.center.optimization;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
public class DataCenter {
    private final LinkedList<Server> servers;

    public List<Server> getServers() {
        if (servers.isEmpty()) {
            System.out.println("Список серверов пуст");
        }
        return servers;
    }

    public void addServer(@NonNull Server server) {
        servers.add(server);
    }

    public void removeServer(@NonNull Server server) {
        if (!servers.contains(server)) {
            System.out.println("Сервер %s не найден".formatted(server));
        }
        servers.remove(server);
    }

    public Server getNextServer() {
        if (servers.isEmpty()) {
            System.out.println("Список серверов пуст");
        }
        Server server = servers.getFirst();
        servers.removeFirst();
        servers.add(server);
        return servers.getLast();
    }
}
