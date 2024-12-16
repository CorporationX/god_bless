package school.faang.task_45023;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}
