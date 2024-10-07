package school.faang.bjs2_33282_dataCenter;

import lombok.Data;

@Data
public class Server {
    static double maxLoad = 100;
    static double energyConsumption = 100;

    private double load = 0;

    public Server() {
    }
}
