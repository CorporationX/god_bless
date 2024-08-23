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
