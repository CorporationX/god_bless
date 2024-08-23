package ru.kraiush.BJS219602;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataCenterService  implements LoadStrategy{

    public double getTotalEnergyConsumption(List<Server> servers) {
        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(Server server, double maxLoad, double energyConsumption) {
        server.setLoad(maxLoad);
        server.setEnergyConsumption(energyConsumption);
    }

    public void releaseResources(Server server, double maxLoad, double energyConsumption) {
        server.setLoad(maxLoad);
        server.setEnergyConsumption(energyConsumption);
    }

    public List<Server> addServer(List<Server> servers, int id, double maxLoad, double energyConsumption) {

        if (servers == null) {
            return null;
        }
        servers.add(new Server(id, maxLoad, energyConsumption));
        return servers;
    }

    public void deleteServer(List<Server> servers, Integer id) {
        servers.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public List<Integer> load(DataServers dataCenter, double[] loads) {

        List<Server> servers = dataCenter.getServers();
        List<Integer> listOverload = new ArrayList<>(Collections.nCopies(servers.size(), 0));

        double diffGlobal = 0;
        double diffCurrent;
        for (int j = 0; j < loads.length; j++) {
            diffCurrent = (loads[j] + diffGlobal) - servers.get(j).getMaxLoad();
//            System.out.println("j: " + j + " loads[j]: " + loads[j] + " diffCurrent: " + diffCurrent + " diffGlobal: " + diffGlobal );
            System.out.println("j: " + j + " loads[j]: " + loads[j]);
            if (diffCurrent > 0) {
                servers.get(j).setLoad(servers.get(j).getMaxLoad());
                diffGlobal = diffCurrent;
                listOverload.set(j, 1);
            } else {
                diffGlobal = diffGlobal + loads[j];
                servers.get(j).setLoad(diffGlobal);
                diffGlobal = 0;
            }
        }
        return listOverload;
    }
}
