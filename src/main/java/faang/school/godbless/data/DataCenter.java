package faang.school.godbless.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@RequiredArgsConstructor
@Getter
public class DataCenter {

    private List<Server> servers;

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.add(server);
    }




}
