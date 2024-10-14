package school.faang.optimizingdc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load; // Current load on the server
    private double maxLoad; // Maximum load capacity of the server
    private double energyConsumption; // Current energy consumption of the server

    // Method to check if the server can handle additional load
    public boolean canAllocate(double additionalLoad) {
        return (load + additionalLoad) <= maxLoad;
    }

    // Method to allocate load to the server
    public void allocateLoad(double loadToAdd) {
        this.load += loadToAdd;
    }

    // Method to release load from the server
    public void releaseLoad(double loadToRelease) {
        this.load = Math.max(0, this.load - loadToRelease);
    }
}
