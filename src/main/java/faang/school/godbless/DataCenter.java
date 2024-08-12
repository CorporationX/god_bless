package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class DataCenter {

    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }
}
