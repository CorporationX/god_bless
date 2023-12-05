package faang.school.godbless.temp;

import faang.school.godbless.BJS2_433.DataCenterService;
import faang.school.godbless.BJS2_433.Server;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private static DataCenter instance;
    private List<Server> serverList;
    private int count;
    private DataCenter () {
        serverList = new ArrayList<>();
    }

    public static DataCenter getInstance () {
        if (instance == null) {
            instance = new DataCenter();
        }
        return instance;
    }

    public void add (Server server) {
        serverList.add(server);
        count++;
    }

    public void remove (Server server) {
        serverList.remove(server);
        count--;
    }
    public void remove (int index) {
        serverList.remove(index);
        count--;
    }
}
