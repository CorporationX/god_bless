package faang.school.godbless.BJS2_19329;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class DataCenter {
    private final double SMALL_SERVER = 100;
    private final double MEDIUM_SERVER = 150;
    private final double LARGE_SERVER = 200;
    private List<Server> serversList;
}
