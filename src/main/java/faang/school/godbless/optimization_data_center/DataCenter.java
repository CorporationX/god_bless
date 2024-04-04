package faang.school.godbless.optimization_data_center;

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
