package faang.school.godbless.sprint_1.hashMap.task_13_dataCenter;

import java.util.ArrayList;
import java.util.List;

public record DataCenter(List<Server> servers) {
    DataCenter() {
        this(new ArrayList<>());
    }
}
