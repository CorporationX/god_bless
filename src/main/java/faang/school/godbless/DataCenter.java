package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {
    private List<Server> serverList;

    public double getTotalCurrentLoad() {
        double result = 0d;
        for (Server server : serverList) {
            result += server.getLoad();
        }
        return result;
    }

    public double getTotalMaxLoad() {
        double result = 0d;
        for (Server server : serverList) {
            result += server.getMaxLoad();
        }
        return result;
    }

    public double getTotalEnergyConsumption() {
        double result = 0d;
        for (Server server : serverList) {
            result += server.getEnergyConsumption();
        }
        return result;
    }
}
