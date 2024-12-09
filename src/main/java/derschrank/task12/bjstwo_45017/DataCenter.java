package derschrank.task12.bjstwo_45017;

import derschrank.task12.bjstwo_45017.servers.Server;

import java.util.HashSet;
import java.util.Set;

public class DataCenter {
    private Set<Server> servers;

    public DataCenter() {
        this(new HashSet<>());
    }

    public DataCenter(Set<Server> servers) {
        this.servers = servers;
    }

    public Set<Server> getServers() {
        return servers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Server server : servers) {
            result.append(server);
            result.append("\n");
        }
        return result.toString();
    }
}
