package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad=maxLoad;
        this.energyConsumption=energyConsumption;
    }
    public String toString(){
        return "Load: "+getLoad()+", MaxLoad: "+getMaxLoad()+", Consumption: "+getEnergyConsumption();
    }
}
