package school.faang.bjs245016;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataCenter {
    private final List<Server> serversList = new ArrayList<>();
    private final List<ResourceRequest> requestsList = new ArrayList<>();
}
