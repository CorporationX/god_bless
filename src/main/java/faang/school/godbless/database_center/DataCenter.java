package faang.school.godbless.database_center;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class DataCenter {
    private List<Server> listOfServers;

    public DataCenter() {
        this.listOfServers = new ArrayList<>();
    }
}
