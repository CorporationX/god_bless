package faang.school.godbless.optimization_data_center;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@Data
public class DataCenter {
    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void deleteServer(Server server) {
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).equals(server)) {
                servers.remove(i);
                break;
            }
        }
    }

    public double getTotalByExpression(BiFunction<Double, Server, Double> function) {
        return servers.stream()
                .reduce(0.0, function, Double::sum);
    }
}
