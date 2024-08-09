package faang.school.godbless.datacenter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;
}
