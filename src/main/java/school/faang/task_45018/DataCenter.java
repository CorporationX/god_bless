package school.faang.task_45018;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DataCenter {
    private final List<Server> servers;

    public void addServer(@NonNull Server server) {
        servers.add(server);
    }

    public void removeServer(@NonNull Server server) {
        servers.remove(server);
    }
}