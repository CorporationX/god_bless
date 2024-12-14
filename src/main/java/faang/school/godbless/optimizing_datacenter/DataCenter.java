package faang.school.godbless.optimizing_datacenter;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
//Ive modified this class so that its a little easier to implement request allocation, release and optimization a little bit easier and use hashmap
    Map<ResourceRequest, Server> requestMap = new HashMap<>();
}
