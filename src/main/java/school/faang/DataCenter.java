package school.faang;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}
