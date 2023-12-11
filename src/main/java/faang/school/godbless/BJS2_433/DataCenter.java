package faang.school.godbless.BJS2_433;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private static DataCenter instance;
    private List<Server> serverList;
    private int size;

    private DataCenter() { //singleton
        serverList = new ArrayList<>();
    }

    public static DataCenter getInstance() {
        if (instance == null) {
            instance = new DataCenter();
        }
        return instance;
    }

    public void add(Server server) {
        serverList.add(server);
        size++;
    }

    public void add(double maxLoad, int amount) {
        int count = 0;
        while (count < amount) {
            add(new Server(maxLoad));
            count++;
        }
    }

    public void remove(Server server) {
        serverList.remove(server);
        size--;
    }

    public void remove(int index) {
        serverList.remove(index);
        size--;
    }
}