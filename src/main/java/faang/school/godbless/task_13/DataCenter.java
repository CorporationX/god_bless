package faang.school.godbless.task_13;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;

    public void addServer(Server server) {
        if (server == null) {
            return;
        }
        servers.add(server);
    }

    public void removeServer(Server server) {
        if (server == null) {
            return;
        }
        servers.remove(server);
    }

    public boolean isEmpty() {
        return servers.isEmpty();
    }
}
