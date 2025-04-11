package school.faang.data_center.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Server {
    private static final double BASE_POWER_CONSUMPTION = 100;
    private static final double MAX_ADDITIONAL_POWER = 200;

    private double load;
    private double maxLoad;
    private double energyConsumption;
    @Getter
    private Set<ResourceRequest> activeRequests = new HashSet<>();

    public Server(double load, double maxLoad) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = calculateEnergyConsumption();
    }

    private double calculateEnergyConsumption() {
        final double currentLoadRatio = load / maxLoad;
        return BASE_POWER_CONSUMPTION + (currentLoadRatio * MAX_ADDITIONAL_POWER);
    }
}

