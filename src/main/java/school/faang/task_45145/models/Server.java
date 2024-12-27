package school.faang.task_45145.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Server {
    private static final double MIN_SERVER_LOAD = 0.0;
    private static final double MAX_SERVER_LOAD = 1000.0;
    private static final double MIN_SERVER_MAX_LOAD = 0.0;
    private static final double MAX_SERVER_MAX_LOAD = 1000.0;
    private static final double MIN_SERVER_ENERGY_CONSUMPTION = 10.0;
    private static final double MAX_SERVER_ENERGY_CONSUMPTION = 10000.0;

    private static final String ERROR_NAME = "Server name must not be null or blank.";
    private static final String ERROR_LOAD = "Server load must be between 0 and 1000.";
    private static final String ERROR_MAX_LOAD = "Server max load must be between 0 and 1000.";
    private static final String ERROR_ENERGY_CONSUMPTION = "Energy consumption value must be between 10 and 10000.";

    @EqualsAndHashCode.Include
    private final String name;
    private final double maxLoad;

    private double load;
    private double energyConsumption;

    public Server(String name, double load, double maxLoad, double energyConsumption) {
        if (name == null || name.isBlank()) {
            log.error(ERROR_NAME);
            throw new IllegalArgumentException(ERROR_NAME);
        }
        if (load < MIN_SERVER_LOAD || load > MAX_SERVER_LOAD) {
            log.error(ERROR_LOAD);
            throw new IllegalArgumentException(ERROR_LOAD);
        }
        if (maxLoad < MIN_SERVER_MAX_LOAD || maxLoad > MAX_SERVER_MAX_LOAD) {
            log.error(ERROR_MAX_LOAD);
            throw new IllegalArgumentException(ERROR_MAX_LOAD);
        }
        if (energyConsumption < MIN_SERVER_ENERGY_CONSUMPTION || energyConsumption > MAX_SERVER_ENERGY_CONSUMPTION) {
            log.error(ERROR_ENERGY_CONSUMPTION);
            throw new IllegalArgumentException(ERROR_ENERGY_CONSUMPTION);
        }

        this.name = name;
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;

        log.info("Server '{}' has been successfully created", name);
    }
}
