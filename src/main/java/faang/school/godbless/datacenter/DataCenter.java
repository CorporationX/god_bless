package faang.school.godbless.datacenter;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> serversList;

    public DataCenter(){
        this.serversList = new ArrayList<>();
    }

    public List<Server> getServersList() {
        return serversList;
    }
}
