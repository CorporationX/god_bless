package optimizingdatacenter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
}
