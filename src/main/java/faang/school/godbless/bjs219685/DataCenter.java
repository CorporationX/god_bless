package faang.school.godbless.bjs219685;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public double getTotalEnergyConsumption() {
        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public double getTotalLoad() {
        return servers.stream()
                .mapToDouble(Server::getLoad)
                .sum();
    }

    public void deleteServer(Server server) {
        servers.remove(server);
    }

}
