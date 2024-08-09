package faang.school.godbless.BJS2_19800.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    public DataCenter() {
        this.serverList = new ArrayList<>();
    }

    private List<Server> serverList;
}
