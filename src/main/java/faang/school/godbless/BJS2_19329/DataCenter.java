package faang.school.godbless.BJS2_19329;

import lombok.Getter;

import java.util.List;
@Getter
public class DataCenter {
    private final double SMALL_SERVER;
    private final double MEDIUM_SERVER;
    private final double LARGE_SERVER;
    private List<Server> serversList;

    public DataCenter(List<Server> serversList) {
        this.serversList = serversList;
        this.SMALL_SERVER=serversList.get(0).getSMALL_SERVER();
        this.MEDIUM_SERVER=serversList.get(0).getMEDIUM_SERVER();
        this.LARGE_SERVER=serversList.get(0).getLARGE_SERVER();
    }
}
