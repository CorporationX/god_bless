package faang.school.godbless.r_edzie.datacenter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;
}
