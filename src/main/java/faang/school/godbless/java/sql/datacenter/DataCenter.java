package faang.school.godbless.java.sql.datacenter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public void addNewServer(Server server) {
        this.servers.add(server);
    }

    @Override
    public String toString() {
        return "servers={"+ servers +"}";
    }
}
