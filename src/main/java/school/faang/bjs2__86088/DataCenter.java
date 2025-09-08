package school.faang.bjs2__86088;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class DataCenter {
    private List<Server> listServer = new ArrayList<>();

    public void addServerInList(Server server) {
        listServer.add(server);
    }

}
