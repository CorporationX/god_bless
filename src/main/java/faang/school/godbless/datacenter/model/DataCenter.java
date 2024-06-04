package faang.school.godbless.datacenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {

    private List<Server> servers;
}
