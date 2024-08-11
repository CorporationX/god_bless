package faang.school.godbless.BJS2_19329;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenter {
    private final double SMALL_SERVER;
    private final double MEDIUM_SERVER;
    private final double LARGE_SERVER;
    private List<Server> serversList;

    public DataCenter(List<Server> serversList, double SMALL_SERVER, double MEDIUM_SERVER, double LARGE_SERVER) {
        this.serversList = serversList;
        this.SMALL_SERVER = SMALL_SERVER;
        this.MEDIUM_SERVER = MEDIUM_SERVER;
        this.LARGE_SERVER = LARGE_SERVER;
    }
}
