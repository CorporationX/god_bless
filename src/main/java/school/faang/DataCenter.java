package school.faang;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class DataCenter {
    protected final List<Server> servers = new ArrayList<>();
}
