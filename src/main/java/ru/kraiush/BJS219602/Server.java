package ru.kraiush.BJS219602;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {

// why are you using the reference type here? if you use a link, then you assume that the field can be null
// the ID should not be null  ???
    Integer id;
    double load;
    double maxLoad;
    double energyConsumption;

    public Server(int id, double maxLoad, double energyConsumption) {
        this.id = id;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
// a computer does not have a "give all computers" method, especially since one server is not responsible for CREATING other servers
//It doesn't make sense to create class objects in the same class. It is from the logic side - how can a server create another server?
//You need to fill the list of servers from the outside when a new server is added, that is, there should be a method in the DataCenter
// class that adds a new server to the data center. And the list of servers lies precisely in the data center - since the data center
// is the repository of all servers. And the server is just a computer with characteristics
//    public static List<Server> getServers() {
//        List<Server> servers = new ArrayList<>();
//        servers.add(new Server(1, 100, 1000));
//        servers.add(new Server(2, 200, 2000));
//        servers.add(new Server(3, 300, 3000));
//        servers.add(new Server(4, 400, 4000));
//        return servers;
//    }

    @Override
    public String toString() {
        return "{id=" + id + ", load=" + load + "}";
    }
}
