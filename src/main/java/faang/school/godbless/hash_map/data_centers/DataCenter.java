package faang.school.godbless.hash_map.data_centers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class DataCenter{
    private List<Server> serverList = new ArrayList<>();

}
