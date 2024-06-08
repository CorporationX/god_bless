package faang.school.godbless.dataCenter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {

    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }
}
