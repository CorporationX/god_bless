package school.faang.sprint_1.task_45025.data_center;

import lombok.Getter;
import school.faang.sprint_1.task_45025.models.Server;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
}
