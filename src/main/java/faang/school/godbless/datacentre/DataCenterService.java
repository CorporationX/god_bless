package faang.school.godbless.datacentre;


import java.util.List;

public class DataCenterService {
    private DataCenter dataCenter;

    public DataCenterService() {
        dataCenter = new DataCenter();
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public void getTotalEnergyConsumption() {
        double totalEnergyConsumtion = 0.0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumtion += server.getEnergyConsumption();
        }
        System.out.println("Общее потребление электроэнергии в дата-центре: " + totalEnergyConsumtion);
    }

    public void allocateResources(ResourceRequest request) {
        /*
         Выбирается наименее загруженн сервер на момент прихода запроса и выделяются на нём ресурсы,
         если у него их достаточно
         */
        List<Server> servers = dataCenter.getServers();
        Server minLoadServer = servers.get(0);
        for (int i = 1; i < servers.size(); i++) {
            if (servers.get(i).getLoad() < minLoadServer.getLoad() ) {
                minLoadServer = servers.get(i);
            }
        }

        if (request.load() + minLoadServer.getLoad() <= minLoadServer.getEnergyConsumption()) {
            minLoadServer.increaseLoad(request.load());
            dataCenter.getRequestServer().put(request.id(), minLoadServer);
        } else {
            System.out.println("Дата-центр перегружен, вернитесь позднее");
        }
    }

    public void releaseResources(ResourceRequest request) {
        dataCenter.getRequestServer().get(request.id()).decreaseLoad(request.load());
        dataCenter.getRequestServer().remove(request.id());
    }
}
