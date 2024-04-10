package faang.school.godbless.data_center;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        if (!servers.contains(server)){
            servers.add(server);
            System.out.println("Сервер " + server + " добавлен");
        }
        else {
            System.out.println(server + " уже есть в списке");
        }
    }

    public void removeServer(Server server){
        if (!servers.isEmpty()){
            if (servers.contains(server)){
                servers.remove(server);
                System.out.println("Сервер " + server + " удалён");
            }
            else {
                System.out.println("Сервера " + server + " не найдено");
            }
        }
    }

    public double getTotalEnergy(){
        double sumEnergy = 0;
        for (Server server : servers){
            sumEnergy += server.getEnergyConsumption();
        }
        return sumEnergy;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request){
        List<Server> servers = dataCenter.getServers();
        if (servers.isEmpty()) {
            System.out.println("Нет серверов");
            return;
        }
        Server mostBusyServer = servers.get(0);
        for (Server server : servers) {
            if (server.getLoad() > mostBusyServer.getLoad()) {
                mostBusyServer = server;
            }
        }
        double newLoad = mostBusyServer.getLoad() - request.getLoad();
        if (newLoad < 0) {
            System.out.println("Невозможно высвободить ресырсы");
        } else {
            mostBusyServer.setLoad(newLoad);
            System.out.println("Ресурсы высвобождены с сервера " + mostBusyServer);
        }
    }

    public List<Server> getServers() {
        return servers;
    }
}

