package faang.school.godbless.task_13_dataCenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataCenterServiceTest {
    @Test
    public void testInit() {
        // Arrange
        DataCenter dataCenter = new DataCenter();

        // Act
        DataCenterService dataCenterService = new DataCenterService();

        // Assert
        Assertions.assertEquals(dataCenter, dataCenterService.dataCenter(), "dataCenters must be equal");
    }

    @Test
    public void testAddServer() {
        // Arrange
        Server server = new Server(15.5, 30.0, 500);

        DataCenterService dataCenterService = new DataCenterService();

        // Act
        dataCenterService.addServer(server);

        // Assert
        Assertions.assertTrue(dataCenterService.dataCenter().servers().contains(server), "The server was not added to the data center");
    }

    @Test
    public void testRemoveServer() {
        // Arrange
        Server server = new Server(15.5, 30.0, 500);

        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(server);

        // Act
        dataCenterService.removeServer(server);

        // Assert
        Assertions.assertFalse(dataCenterService.dataCenter().servers().contains(server), "The server was added to the data center");
    }

    @Test
    public void testGetTotalEnergyConsumption() {
        // Arrange
        double consumptionFirstServer = 500.0;
        double consumptionSecondServer = 300.5;
        double consumptionThirdServer = 150.7;
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server(15.5, 30.0, consumptionFirstServer));
        dataCenterService.addServer(new Server(10.2, 27.0, consumptionSecondServer));
        dataCenterService.addServer(new Server(5.5, 25.0, consumptionThirdServer));
        double expection = consumptionFirstServer + consumptionSecondServer + consumptionThirdServer;

        // Act
        double actual = dataCenterService.getTotalEnergyConsumption();

        // Assert
        Assertions.assertEquals(expection, actual, "the total amount of energy does not match");
    }

    @Test
    public void testAllocateResources() {
        // Arrange
        double load = 15.5;
        double addLoad = 27.2;
        ResourceRequest request = new ResourceRequest(addLoad);
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server(load, 60.0, 500.0));
        double expection = load + addLoad;

        // Act
        dataCenterService.allocateResources(request);
        double actual = dataCenterService.dataCenter().servers().get(0).load();

        // Assert
        Assertions.assertEquals(expection, actual, "load does not match after adding");
    }

    @Test
    public void testReleaseResources() {
        // Arrange
        double load = 15.5;
        double freeLoad = 6.2;
        ResourceRequest request = new ResourceRequest(freeLoad);
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server(load, 60.0, 500.0));
        double expection = load - freeLoad;

        // Act
        dataCenterService.releaseResources(request);
        double actual = dataCenterService.dataCenter().servers().get(0).load();

        // Assert
        Assertions.assertEquals(expection, actual, "the load after release is not the same");
    }

    @Test
    public void testOptimize() {
        // Arrange
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server(20.0, 60.0, 500.0));
        dataCenterService.addServer(new Server(40.0, 60.0, 500.0));

        // Act
        dataCenterService.optimize(dataCenterService.dataCenter());
        double actual = dataCenterService.dataCenter().servers().get(0).load();

        // Assert
        Assertions.assertTrue(actual > 29.5 && actual < 30.5, "optimization was not successful");
    }

    @Test
    public void testOptimize_moreThanTwoServices() {
        // Arrange
        double firstLoad = 20.0;
        double firstMaxLoad = 60.0;
        double secondLoad = 40.0;
        double secondMaxLoad = 50.0;
        double thirdLoad = 40.0;
        double thirdMaxLoad = 40.0;
        DataCenterService dataCenterService = new DataCenterService();
        Server firstServer = new Server(firstLoad, firstMaxLoad, 500.0);
        Server secondServer = new Server(secondLoad, secondMaxLoad, 500.0);
        Server thirdServer = new Server(thirdLoad, thirdMaxLoad, 500.0);
        dataCenterService.addServer(firstServer);
        dataCenterService.addServer(secondServer);
        dataCenterService.addServer(thirdServer);
        double averageLoad = (firstServer.getServerLoadInPercent() +
                secondServer.getServerLoadInPercent() +
                thirdServer.getServerLoadInPercent()) / 3; // 33.3 + 80 + 100 = 71,1

        double expSecondLoad = secondMaxLoad * averageLoad; // 35,5
        double expThirdLoad = thirdMaxLoad * averageLoad; // 28,4
        double expFirstLoad = firstMaxLoad + (secondLoad - expSecondLoad) +
                (thirdLoad - expThirdLoad); // 20.0 + 4.4 + 11.5 = 36

        // Act
        dataCenterService.optimize(dataCenterService.dataCenter());
        double actualFirst = dataCenterService.dataCenter().servers().get(0).load();
        double actualSecond = dataCenterService.dataCenter().servers().get(1).load();
        double actualThird = dataCenterService.dataCenter().servers().get(2).load();

        // Assert
        Assertions.assertTrue(actualFirst > 35.9 && actualFirst < 36.1, "optimization was not successful");
        Assertions.assertTrue(actualSecond > 35.4 && actualSecond < 35.6, "optimization was not successful");
        Assertions.assertTrue(actualThird > 28.3 && actualThird < 28.5, "optimization was not successful");
    }
}
