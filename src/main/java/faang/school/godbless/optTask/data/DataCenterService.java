package faang.school.godbless.optTask.data;

import faang.school.godbless.optTask.optStrategy.OptThread;
import faang.school.godbless.optTask.optStrategy.OptimizationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataCenterService {
    private DataCenter dataCenter;
    Thread optThread;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy strategy) {

        this.dataCenter = dataCenter;
        optThread = new Thread(new OptThread(strategy, dataCenter));
        System.out.println("data center service created");
    }

    public void startOptimization() {
        optThread.start();
        System.out.println("optThread is started");
    }

    public void stopOptimization() {
        optThread.interrupt();
        System.out.println("optThread is closed");
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServers().remove(server);
    }


    public void allocateResources(ResourceRequest request) {
        for (Server server: dataCenter.getServers()){
            double buf = request.getLoad();
            request.setLoad(buf - (server.getMaxLoad() - server.getLoad()));
            if (request.getLoad()<=0){
                server.setLoad(server.getLoad() + buf);
                System.out.println("request allocate");
                return;
            }else {
                server.setLoad(server.getLoad() + (buf - request.getLoad()));
            }
        }
        throw new IllegalArgumentException("too much load to allocate!!!");
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server: dataCenter.getServers()){
            double buf = request.getLoad();
            request.setLoad(buf - server.getLoad());
            if (request.getLoad()<=0){
                server.setLoad(server.getLoad() - buf);
                System.out.println("request release");
                return;
            }else {
                server.setLoad(server.getLoad() - (buf - request.getLoad()));
            }
        }
        throw new IllegalArgumentException("too much load to release!!!");
    }
}
