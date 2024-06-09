package faang.school.godbless.OptimizeTheOperationOfDataCenter;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataCenter extends DataCenterService {
    private List<Server> servers;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }

}
