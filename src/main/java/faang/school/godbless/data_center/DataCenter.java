package faang.school.godbless.data_center;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
    private double maxLoadSum = 0;
    private double currentLoadSum = 0;

}
