package faang.school.godbless.OptimizeDataCenter2064;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class DataCenter {

    private List<Server> serverList;

    public DataCenter(List<Server> serverList) {
        this.serverList = serverList;
    }
}