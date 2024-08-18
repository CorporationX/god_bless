package data.centre;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DataCenter {

    private final Map<Integer, Server> serverIdMap = new HashMap<>();

    public void addServer(int id, Server server) {
        serverIdMap.put(id, server);
    }

    public double getTotalEnergyConsumption() {
        double result = 0;
        for (Server server : serverIdMap.values()) {
            result += server.getEnergyConsumption();
        }
        return result;
    }

    public double getTotalServerLoad() {
        double totalLoad = 0;
        for (Server server : serverIdMap.values()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public double getTotalServerMaxLoad() {
        double totalMaxLoad = 0;
        for (Server server : serverIdMap.values()) {
            totalMaxLoad += server.getMaxLoad();
        }
        return totalMaxLoad;
    }

    public void printServers() {
        for (Map.Entry<Integer, Server> entry : serverIdMap.entrySet()) {
            Server server = entry.getValue();
            System.out.println("Сервер ID: " + entry.getKey() + " и данные: " + server);
        }
    }

    public void deleteServer(int id) {

        if (serverIdMap.containsKey(id)) {

            if (serverIdMap.get(id).getLoad() > 0) {
                System.out.println("Нельзя отключить сервер под нагрузкой.");
            } else {
                serverIdMap.remove(id);

                System.out.println("Сервер с ID [" + id + "] отключен.");
            }
        } else {
            throw new IllegalArgumentException("Сервера с ID [" + id + "] нет.");
        }
    }

}
