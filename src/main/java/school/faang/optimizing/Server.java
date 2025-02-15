package school.faang.optimizing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public boolean allocate(double requestedLoad) {
        if (load + requestedLoad <= maxLoad) {
            load += requestedLoad;
            return true;
        }
        return false;
    }

    public void release(double requestedLoad) {
        load = Math.max(0, load - requestedLoad);
    }
}
