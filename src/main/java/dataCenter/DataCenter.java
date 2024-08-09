package dataCenter;

import lombok.Data;

import java.util.List;
@Data
public class DataCenter {
    private double dopLoad;
   private List<Server> serverList = List.of(new Server(0,80.8, 100, 8.98),
                                             new Server(1,30.4, 100,5.53),
                                             new Server(2,16.4,100,9.76),
                                             new Server(3,26.5,100,7.77));

    public void addServerAtList(List<Server> serverList, Server server) {
        this.serverList = serverList;
        serverList.add(server);
    }

    public void removeServerAtList(List<Server> serverList, Server server) {
        serverList.remove(server);
    }
}
