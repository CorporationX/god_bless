package school.faang.task_45019;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

}
