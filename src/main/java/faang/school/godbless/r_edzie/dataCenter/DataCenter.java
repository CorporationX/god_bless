package faang.school.godbless.r_edzie.dataCenter;

import lombok.Data;

import java.util.List;

@Data
public class DataCenter {
    private List<Server> servers;
    public DataCenter(List<Server> serverList) {
        this.servers = serverList;
    }
}
