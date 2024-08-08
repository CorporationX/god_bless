package faang.school.godbless.BJS2_19303;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataCenter {
    List<Server> servers;

    public double getTotalEnergy(){
        double totalEnergyConsumption = 0;
        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }
}
