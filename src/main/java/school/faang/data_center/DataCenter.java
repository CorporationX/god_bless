package school.faang.data_center;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataCenter {
    private List<Server> serverList;

    public DataCenter() {
        serverList = new ArrayList<>();
    }
}
