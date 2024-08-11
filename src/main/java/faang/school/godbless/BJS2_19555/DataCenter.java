package faang.school.godbless.BJS2_19555;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
    private Map<Server, Integer> serverIndexes = new HashMap<>();
}
