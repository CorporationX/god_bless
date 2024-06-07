package faang.school.godbless.module1.sprint1.task13;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter(new ArrayList<>());
        DataCenterService dataCenterService = new DataCenterService();
        ResourceRequest resourceRequest = new ResourceRequest();

        dataCenter.getServers().add(new Server());
        dataCenter.getServers().add(new Server());
        dataCenter.getServers().add(new Server());
        dataCenter.getServers().add(new Server());

        dataCenterService.getTotalEnergyConsumption(dataCenter);
        dataCenterService.allocateResources(resourceRequest, dataCenter);
        dataCenterService.releaseResources(resourceRequest, dataCenter);
    }
}
