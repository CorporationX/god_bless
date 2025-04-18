package school.faang.data_center;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public double getTotalLoad() {
        return servers.stream().mapToDouble(Server::getLoad).sum();
    }

    public double getTotalMaxLoad() {
        return servers.stream().mapToDouble(Server::getMaxLoad).sum();
    }

    public double getPercentageLoad() {
        return getTotalLoad() / getTotalMaxLoad();
    }

    public double getFreeLoad() {
        return servers.stream().mapToDouble(server -> server.getMaxLoad() - server.getLoad()).sum();
    }
}
