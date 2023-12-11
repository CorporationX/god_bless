package DataCenter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DataCenter {
    private List<Server> listOfServers;
    private Map<Double, List<Server>> loadServersMap;

    public DataCenter(List<Server> serverList) {
        this.listOfServers = serverList;
        for (Server server : listOfServers){
            //Заполняем мапу по ключам load значениями из serverList
            List<Server> tempList = loadServersMap.getOrDefault(server.getLoad(), new ArrayList<>());
            tempList.add(server);
            loadServersMap.put(server.getLoad(), tempList);
        }
    }
}
