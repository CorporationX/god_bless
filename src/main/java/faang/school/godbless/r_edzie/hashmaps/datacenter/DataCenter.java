package faang.school.godbless.r_edzie.hashmaps.datacenter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;
}
