package school.faang.bjs245016;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Server {
    private final UUID id;
    private final String name;
    private double load;
    private final double maxLoad;
    private double energyConsumption;

    public void shutDown() {
        this.energyConsumption = 0;
    }

}
