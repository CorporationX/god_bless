package faang.school.godbless.java_hashmap.optimizing_work_data_center;


import lombok.Data;

@Data
public class Server {

    private double load;
    private double maxLoad = 100;
    private double availableLoad;
    private double energyConsumption;

    public Server(double load) {
        this.load = load;
        this.availableLoad = maxLoad - load;
        energyConsumption = load * 5;
    }
}
