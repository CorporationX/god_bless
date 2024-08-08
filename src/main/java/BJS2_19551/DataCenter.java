package BJS2_19551;

import java.util.List;

public class DataCenter {
    private List<Server> serverList;

    public DataCenter(List<Server> serverList) {
        this.serverList = serverList;
    }

    public List<Server> getServerList() {
        return serverList;
    }
}
