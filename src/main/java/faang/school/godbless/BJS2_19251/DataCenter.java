package faang.school.godbless.BJS2_19251;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DataCenter{
    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server){
        servers.add(server);
    }

    public double getTotalEnergyConsumption(){
        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }
}
