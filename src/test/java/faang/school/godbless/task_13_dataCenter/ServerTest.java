package faang.school.godbless.task_13_dataCenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServerTest {

    @Test
    public void testInit() {
        // Arrange
        double load = 15.0;
        double maxLoad = 30.0;
        double energyConsumption = 500.0;

        // Act
        Server server = new Server(load, maxLoad, energyConsumption);

        // Assert
        // Assertions.assertEquals(1, server.id(), "id field does not match");
        Assertions.assertEquals(load, server.load(), "load field does not match");
        Assertions.assertEquals(maxLoad, server.maxLoad(), "maxLoad field does not match");
        Assertions.assertEquals(energyConsumption, server.energyConsumption(), "energyConsumption field does not match");
    }

    @Test
    public void testInitLoadGreaterThanMax() {
        // Arrange
        double load = 30.0;
        double maxLoad = 15.0;
        double energyConsumption = 500.0;

        // Act
        Server server = new Server(load, maxLoad, energyConsumption);

        // Assert
        Assertions.assertEquals(load, server.load(), "load field does not match");
        Assertions.assertEquals(load, server.maxLoad(), "the maxLoad field should have taken the value of the load field");
    }

    @Test
    public void testGetFreeLoad() {
        // Arrange
        double load = 15.0;
        double maxLoad = 30.0;
        double energyConsumption = 500.0;
        Server server = new Server(load, maxLoad, energyConsumption);

        double expection = maxLoad - load;

        // Act
        double actual = server.getFreeLoad();

        // Assert
        Assertions.assertEquals(expection, actual, "free load results do not match");
    }

    @Test
    public void testAddLoad() {
        // Arrange
        double load = 15.0;
        double maxLoad = 30.0;
        double energyConsumption = 500.0;
        Server server = new Server(load, maxLoad, energyConsumption);

        double loadToAdd = 5.5;
        double expection = load + loadToAdd;

        // Act
        server.addLoad(loadToAdd);
        double actual = server.load();

        // Assert
        Assertions.assertEquals(expection, actual, "load results do not match");
    }

    @Test
    public void testAddLoad_overLoad() {
        // Arrange
        double load = 15.0;
        double maxLoad = 30.0;
        double energyConsumption = 500.0;
        Server server = new Server(load, maxLoad, energyConsumption);

        double loadToAdd = 20;
        double expection = load + Math.min(server.getFreeLoad(), loadToAdd);

        // Act
        server.addLoad(loadToAdd);
        double actual = server.load();

        // Assert
        Assertions.assertEquals(expection, actual, "load results do not match");
    }

    @Test
    public void testFreeUpResources() {
        // Arrange
        double load = 15.0;
        double maxLoad = 30.0;
        double energyConsumption = 500.0;
        Server server = new Server(load, maxLoad, energyConsumption);

        double loadToFree = 5.5;
        double expection = load - loadToFree;

        // Act
        server.freeUpResources(loadToFree);
        double actual = server.load();

        // Assert
        Assertions.assertEquals(expection, actual, "load results do not match");
    }

    @Test
    public void testFreeUpResources_belowZero() {
        // Arrange
        double load = 15.0;
        double maxLoad = 30.0;
        double energyConsumption = 500.0;
        Server server = new Server(load, maxLoad, energyConsumption);

        double loadToFree = 20.0;
        double expection = 0;

        // Act
        server.freeUpResources(loadToFree);
        double actual = server.load();

        // Assert
        Assertions.assertEquals(expection, actual, "load results do not match");
    }

    @Test
    public void testGetServerLoadInPercent() {
        // Arrange
        double load = 15.0;
        double maxLoad = 30.0;
        double energyConsumption = 500.0;
        Server server = new Server(load, maxLoad, energyConsumption);

        double expection = load / maxLoad * 100;

        // Act
        double actual = server.getServerLoadInPercent();

        // Assert
        Assertions.assertEquals(expection, actual, "load results do not match");
    }

}
