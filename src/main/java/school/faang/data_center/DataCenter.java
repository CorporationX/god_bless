package school.faang.data_center;

import lombok.Getter;
import lombok.Setter;
import school.faang.util.ParameterUtil;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    @Getter
    private List<Server> serverList;

    public DataCenter() {
        serverList = new ArrayList<>();
    }

    public boolean addServer(Server server) {
        ParameterUtil.checkToNull(server, "server");
        return serverList.add(server);
    }

    public boolean removeServer(Server server) {
        ParameterUtil.checkToNull(server, "server");
        return serverList.remove(server);
    }
}
