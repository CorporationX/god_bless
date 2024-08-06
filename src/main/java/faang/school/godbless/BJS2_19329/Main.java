package faang.school.godbless.BJS2_19329;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter(List.of(
                new Server(30, 100),
                new Server(33, 100),
                new Server(45, 100),
                new Server(15, 100)
        ));
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.printDataCenterConfiguration();
        dataCenterService.allocateResources(new ResourceRequest(400));
        dataCenterService.printDataCenterConfiguration();
    }
}
