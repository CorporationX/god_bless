package faang.school.godbless.javahashmap.task2dataserver;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    @Getter
    private static List<Server> servers = new ArrayList<>();

}
