package faang.school.godbless.BJS28666;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;
    public void addServer(Server server) {
        if (!dataCenter.getServers().contains(server)) {
            dataCenter.getServers().add(server);
        } else {
            System.out.println("This server already exists in the DC");
        }
    }

    public void removeServer(Server server) {
        if (dataCenter.getServers().removeIf(s -> s.equals(server))) {
            System.out.println("The server removed successfully from the the DC");
        } else {
            System.out.println("The DC doesn't include this server");
        }
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        if (!servers.isEmpty()) {
            servers.sort(Comparator.comparing(Server::getEnergyConsumption));
            if (servers.stream().anyMatch(server -> server.tryAllocateResources(request))) {
                System.out.println("The resources allocated successfully");
            } else if (releaseResources(request)) {
                allocateResources(request);
            } else {
                // тут нужно реализовать создание очереди реквестов fifo
                System.out.println("Unfortunately, the DC hasn't enough resources now. " +
                        "But don't worry, your request will be processed later");
            }
        } else {
            System.out.println("There's no servers in the DC");
        }
    }

    private boolean releaseResources(ResourceRequest request) {

    }
}
