package faang.school.godbless.BJS2_19911;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public void addServer(Server server){
        dataCenter.getServerList().add(server);
    }
    public void removeServer(Server server){
        dataCenter.getServerList().remove(server);
    }

    public double getTotalEnergyConsumption(){
        double result = 0;

        for(Server server : dataCenter.getServerList()){
            result += server.getEnergyConsumption();
        }
        return result;
    }

    public void allocateResources(ResourceRequest resourceRequest){

    }

}
