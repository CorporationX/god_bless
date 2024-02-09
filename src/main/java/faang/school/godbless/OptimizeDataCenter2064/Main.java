package faang.school.godbless.OptimizeDataCenter2064;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter1 = new DataCenter(List.of(
                new Server(85.51292, 100.0, 35),
                new Server(78.51147, 150.0, 40),
                new Server(55.00000, 55.0, 40),
                new Server(65.15956, 200.0, 40)));
        System.out.println(dataCenter1);
        DataCenterService test = new DataCenterService(dataCenter1);
        allocateTest(test, 35);
        allocateTest(test, 35);
        allocateTest(test, 55);
        allocateTest(test, 75);
        allocateTest(test, 105);
        allocateTest(test, 15);
        allocateTest(test, 15);
        allocateTest(test, 15);
        releaseTest(test, 15);
        releaseTest(test, 15);
        releaseTest(test, 250);
        releaseTest(test, 250);
        releaseTest(test, 250);
        releaseTest(test, 250);
    }

    public static void allocateTest(DataCenterService dataCenterService, double load) {
        if (dataCenterService.allocateResources(new ResourceRequest(load))) {
            System.out.println("Resources allocated!\nUpdated load:");
            System.out.println(dataCenterService.getDataCenter());
        } else {
            System.out.println("Not enough storage for your resources to allocate :(");
        }
    }

    public static void releaseTest(DataCenterService dataCenterService, double load) {
        if (dataCenterService.releaseResources(new ResourceRequest(load))) {
            System.out.println("Resources released!\nUpdated load:");
            System.out.println(dataCenterService.getDataCenter());
        } else {
            System.out.println("Nothing to release");
        }
    }
}