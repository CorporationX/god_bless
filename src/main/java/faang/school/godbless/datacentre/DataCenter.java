package faang.school.godbless.datacentre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCenter {
    private List<Server> servers;
    //private Map<Double, Server> loadServer;
    private Map<Integer, Server> requestServer;

    public DataCenter() {
        servers = new ArrayList<>();
        //loadServer = new HashMap<>();
        requestServer = new HashMap<>();
    }

    public List<Server> getServers() {
        return servers;
    }

    public Map<Integer, Server> getRequestServer() {
        return requestServer;
    }

    //public Map<Double, Server> getLoadServer() {
    //    return loadServer;
    //}
}
