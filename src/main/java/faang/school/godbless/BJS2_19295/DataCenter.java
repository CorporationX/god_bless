package faang.school.godbless.BJS2_19295;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class DataCenter {

    @Getter
    @Setter
    private List<Server> servers;

    public DataCenter() {
        servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        Objects.requireNonNull(server, "Server can not be null");
        servers.add(server);
    }

    public void deleteServer(Server server) {
        Objects.requireNonNull(server, "Server can not be null");
        servers.remove(server);
    }

    public void addLoad(Server server, double load) {
        Objects.requireNonNull(server, "Server can not be null");

        if (server.getLoad() + load <= server.getMaxLoad()) {
            server.addLoad(load);
        } else {
            throw new IllegalArgumentException("The load exceeds the maximum permissible load");
        }
    }

    public void releaseLoad(Server server, double load) {
        Objects.requireNonNull(server, "Server can not be null");

        if (server.getLoad() - load >= 0) {
            server.releaseLoad(load);
        } else {
            throw new IllegalArgumentException("The load exceeds the maximum releasable load");
        }
    }

    @Override
    public String toString() {
        return servers.toString();
    }

}
