package school.faang.bjs2_33282_dataCenter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}
