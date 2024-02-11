package faang.school.godbless.datacenter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DataCenter {

    private List<Server> servers;
}
