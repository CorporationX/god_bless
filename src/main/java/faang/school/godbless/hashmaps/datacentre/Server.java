package faang.school.godbless.hashmaps.datacentre;

public class Server {
    private int id;
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server() {}

    public Server(int id, double load, double maxLoad, double energyConsumption) {
        this.id = id;
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public void increaseLoad(double load) {
        this.load += load;
    }

    public void decreaseLoad(double load) {
        this.load -= load;
    }

    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public double getEnergyConsumption () {
        return energyConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Server server = (Server) o;

        return id == server.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", load=" + load +
                ", maxLoad=" + maxLoad +
                ", energyConsumption=" + energyConsumption +
                '}';
    }
}
