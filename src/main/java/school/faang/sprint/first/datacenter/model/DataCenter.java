package school.faang.sprint.first.datacenter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
}
