package data.optimization;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DataCenter {
    private final Map<Server, Double> serverLoadsMap = new HashMap<>();

    public void getInfo() {
        System.out.println("\nCurent load: ");
        for (Server server : serverLoadsMap.keySet()) {
            System.out.println("    server: " + server.getLoad() + "/" + server.getMaxLoad());
        }
    }
}
