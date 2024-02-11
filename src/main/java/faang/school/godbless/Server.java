package faang.school.godbless;

public class Server {
    private int id;
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(int id, double load, double maxLoad, double energyConsumption) {
        this.id = id;
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public int getId() {
        return id;
    }

    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public String toString(){
        return id + " Load: " + load + " maxLoad: " + maxLoad + " energy consumption: " + energyConsumption;
    }
}
