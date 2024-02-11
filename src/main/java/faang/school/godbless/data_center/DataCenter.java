package faang.school.godbless.data_center;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataCenter {
    private List<Server> serverList;
}
