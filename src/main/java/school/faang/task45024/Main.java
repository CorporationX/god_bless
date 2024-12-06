package school.faang.task45024;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService(new DataCenter(new ArrayList<>(
                List.of(
                        new Server(50, 100, 200),
                        new Server(100, 120, 400),
                        new Server(30, 30, 150))
        )));

        dataCenterService.optimize(dataCenterService.getDataCenter());
    }
}
