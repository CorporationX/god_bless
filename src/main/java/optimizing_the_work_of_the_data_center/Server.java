package optimizing_the_work_of_the_data_center;

import lombok.Data;

@Data
public class Server {
    private double load = 0;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public boolean allocateLoad(double load) {
        if (this.load + load <= maxLoad) {
            this.load += load;
            return true;
        }
        return false;
    }

    public void releaseLoad(double load) {
        this.load = Math.max(0, this.load - load);
    }
}

