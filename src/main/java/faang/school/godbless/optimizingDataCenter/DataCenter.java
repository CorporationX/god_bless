package faang.school.godbless.optimizingDataCenter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
}

