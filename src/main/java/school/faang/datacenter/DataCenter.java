package school.faang.datacenter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}