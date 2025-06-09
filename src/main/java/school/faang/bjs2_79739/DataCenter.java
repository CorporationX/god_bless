package school.faang.bjs2_79739;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        if (!servers.contains(server)) {
            servers.add(server);
        }
    }

    public void removeServer(Server server) {
        if (!servers.remove(server)) {
            System.out.println("Сервер не найден");
        }
    }
}
