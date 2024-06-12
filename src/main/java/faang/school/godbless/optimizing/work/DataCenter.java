package faang.school.godbless.optimizing.work;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {

    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        if(server != null) {
            servers.add(server);
        }
        else {
            System.err.println("Error!");
        }
    }

    public void removeServer(Server server) {
        if(!servers.isEmpty() && servers.contains(server)) {
            servers.remove(server);
        }
        else {
            System.err.println("Error!");
        }
    }

}
