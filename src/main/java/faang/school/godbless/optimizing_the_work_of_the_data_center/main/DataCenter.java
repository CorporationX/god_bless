package faang.school.godbless.optimizing_the_work_of_the_data_center.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;
}
