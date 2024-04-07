package faang.school.godbless.database_center;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> listOfServers;

    public DataCenter() {
        this.listOfServers = new ArrayList<>();
    }

    public List<Server> getListOfServers() {
        return listOfServers;
    }

    public void setListOfServers(List<Server> listOfServers) {
        this.listOfServers = listOfServers;
    }
}
