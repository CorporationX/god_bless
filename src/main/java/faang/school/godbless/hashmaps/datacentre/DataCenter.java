package faang.school.godbless.hashmaps.datacentre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCenter {
    private List<Server> servers;
    private Map<ResourceRequest, Server> requestServer;
    private Map<Server, List<ResourceRequest>> serverRequests;

    public DataCenter() {
        servers = new ArrayList<>();
        requestServer = new HashMap<>();
        serverRequests = new HashMap<>();
    }

    public List<Server> getServers() {
        return servers;
    }

    public Map<ResourceRequest, Server> getRequestServer() {
        return requestServer;
    }

    public Map<Server, List<ResourceRequest>> getServerRequests() {
        return serverRequests;
    }

    public List<Server> getSortServer() {
        servers.sort(new Comparator<Server>() {
            @Override
            public int compare(Server o1, Server o2) {
                if (o1.getMaxLoad() > o2.getMaxLoad()) {
                    return 1;
                } else if (o1.getMaxLoad() < o2.getMaxLoad()) {
                    return -1;
                } else {
                    if (o1.getLoad() > o2.getLoad()) {
                        return -1;
                    } else if (o1.getLoad() < o2.getLoad()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        return servers;
    }

    public void allocateResourcesOnServer(ResourceRequest request, Server server) {
        server.increaseLoad(request.load());
        getRequestServer().put(request, server);

        if (getServerRequests().containsKey(server)) {
            getServerRequests().get(server).add(request);
        } else {
            getServerRequests().put(server, new ArrayList<>(List.of(request)));
        }
    }

    public void releaseResourcesOnServer(ResourceRequest request, Server server) {
        server.decreaseLoad(request.load());
        getRequestServer().remove(request);
        getServerRequests().get(server).remove(request);
    }

    public void showServers() {
        System.out.println("Список серверов дата-центра");
        for (Server server : servers) {
            System.out.println(server);
        }
    }

    public void showServerRequests() {
        System.out.println("Список серверов и запросов на них");
        for (Map.Entry<Server, List<ResourceRequest>> serverRequestsEntry : serverRequests.entrySet()) {
            System.out.println("Сервер: " + serverRequestsEntry.getKey());
            for (ResourceRequest request : serverRequestsEntry.getValue()) {
                System.out.println("\t" + request);
            }
        }
    }
}
