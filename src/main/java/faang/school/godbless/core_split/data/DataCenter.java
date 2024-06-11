package faang.school.godbless.core_split.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@Getter
public class DataCenter {

    private final List<Server> servers;

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.add(server);
    }

}
