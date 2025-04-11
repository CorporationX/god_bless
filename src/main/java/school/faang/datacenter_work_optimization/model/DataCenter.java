package school.faang.datacenter_work_optimization.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public double calculateTotalLoad() {
        return servers
                .stream().mapToDouble(server -> server.getLoad())
                .sum();
    }
}
