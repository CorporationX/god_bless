package school.faang.bjs245028.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;
}
