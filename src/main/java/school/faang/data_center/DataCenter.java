package school.faang.data_center;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}
