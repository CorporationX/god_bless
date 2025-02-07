package school.faang.datacenter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}
