package faang.school.godbless.OptimizeTheOperationOfDataCenter;


import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class DataCenter extends DataCenterService{
    private List<Server> servers;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }
//    DataCenter dataCenter;
//
//    Timer timer = new Timer();
//    TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            optimize(dataCenter);
//        }
//    };

//    @Override
//    public void optimize(DataCenter dataCenter) {
//        double allLoad = 0;
//        for (Server server : dataCenter.getServers()) {
//            allLoad += server.getLoad();
//        }
//        for (Server server : dataCenter.getServers()) {
//            server.setLoad(allLoad / dataCenter.servers.size());
//        }
////        timer.schedule(task, 0, 18000);
//    }
}
