package faang.school.godbless.BJS2_19295;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class DataCenter {

    @Getter
    @Setter
    private List<Server> servers;

    private static DataCenter INSTANCE;

    private DataCenter() {
        servers = new ArrayList<>();
    }

    public static DataCenter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataCenter();
        }

        return INSTANCE;
    }

    public void addServer(Server server) {
        if (server != null) {
            servers.add(server);
        } else {
            System.out.println("Server is null");
        }
    }

    public void deleteServer(Server server) {
        if (server != null) {
            servers.remove(server);
        } else {
            System.out.println("Server is null");
        }
    }

    public void addLoad(Server server, double load) {
        if (server != null) {
            server.addLoad(load);
        } else {
            System.out.println("Server is null");
        }
    }

    public void releaseLoad(Server server, double load) {
        if (server != null) {
            server.releaseLoad(load);
        } else {
            System.out.println("Server is null");
        }
    }

    @Override
    public String toString() {
        return servers.toString();
    }

}
