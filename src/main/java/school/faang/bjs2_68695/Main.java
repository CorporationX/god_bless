package school.faang.bjs2_68695;

import java.util.ArrayList;

/**
 * Задача "Оптимизируем работу дата-центра"
 */
public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter(new ArrayList<>());
        DataCenterService dataCenterService = new DataCenterService();

        dataCenterService.addServer(dataCenter, new Server(125.077, 3750));
        dataCenterService.addServer(dataCenter, new Server(125.378, 3750));
        dataCenterService.addServer(dataCenter, new Server(124.090, 3650));
        dataCenterService.allocateResources(dataCenter, new ResourceRequest(100.00));
        dataCenterService.allocateResources(dataCenter, new ResourceRequest(100.00));
        dataCenterService.allocateResources(dataCenter, new ResourceRequest(100.00));
        dataCenterService.allocateResources(dataCenter, new ResourceRequest(100.00));

    }
}
