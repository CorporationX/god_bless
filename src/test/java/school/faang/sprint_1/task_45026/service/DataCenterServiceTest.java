package school.faang.sprint_1.task_45026.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_45026.entity.ResourceRequest;
import school.faang.sprint_1.task_45026.entity.Server;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    private DataCenterService dataCenterService;

    @BeforeEach
    void setUp() {
        dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server(1000));
        dataCenterService.addServer(new Server(2000));
        dataCenterService.addServer(new Server(3000));
    }

    @Test
    void getTotalEnergyConsumption() {
        for (Server server : dataCenterService.getDataCenter().getServers()) {
            server.setEnergyConsumption(500);
        }
        double expected = 1500;

        double result = dataCenterService.getTotalEnergyConsumption();

        assertEquals(expected, result);
    }

    @Test
    void allocateResources_LessThenMaxLoad() {
        double totalLoad = 3500;
        ResourceRequest input = new ResourceRequest(totalLoad);
        double expectedReturn = 0;


        double resultReturn = dataCenterService.allocateResources(input);
        double resultTotalLoad = dataCenterService.getDataCenter()
                .getServers()
                .stream()
                .mapToDouble(Server::getLoad)
                .sum();

        assertEquals(expectedReturn, resultReturn);
        assertEquals(totalLoad, resultTotalLoad);
    }

    @Test
    void allocateResources_EqualMaxLoad() {
        double totalLoad = 6000;
        ResourceRequest input = new ResourceRequest(totalLoad);
        double expectedReturn = 0;


        double resultReturn = dataCenterService.allocateResources(input);
        double resultTotalLoad = dataCenterService.getDataCenter()
                .getServers()
                .stream()
                .mapToDouble(Server::getLoad)
                .sum();

        assertEquals(expectedReturn, resultReturn);
        assertEquals(totalLoad, resultTotalLoad);
    }

    @Test
    void allocateResources_GreaterThenMaxLoad() {
        double totalLoad = 8000;
        ResourceRequest input = new ResourceRequest(totalLoad);
        double expectedTotalLoad = 6000;
        double expectedReturn = 2000;


        double resultReturn = dataCenterService.allocateResources(input);
        double resultTotalLoad = dataCenterService.getDataCenter()
                .getServers()
                .stream()
                .mapToDouble(Server::getLoad)
                .sum();

        assertEquals(expectedReturn, resultReturn);
        assertEquals(expectedTotalLoad, resultTotalLoad);
    }

    @Test
    void allocateResources_NullRequest() {
        ResourceRequest input = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dataCenterService.allocateResources(input));
        assertEquals("request is null", exception.getMessage());
    }

    @Test
    void releaseResources_LessThenMaxLoad() {
        double totalLoad = 6000;
        ResourceRequest loadToAllocate = new ResourceRequest(totalLoad);
        dataCenterService.allocateResources(loadToAllocate);

        double expectedTotalRelease = 4000;
        ResourceRequest loadToRelease = new ResourceRequest(expectedTotalRelease);
        double expectedTotalLoad = 2000;


        dataCenterService.releaseResources(loadToRelease);
        double resultTotalLoad = dataCenterService.getDataCenter()
                .getServers()
                .stream()
                .mapToDouble(Server::getLoad)
                .sum();

        assertEquals(expectedTotalLoad, resultTotalLoad);
    }

    @Test
    void releaseResources_EqualMaxLoad() {
        double totalLoad = 6000;
        ResourceRequest loadToAllocate = new ResourceRequest(totalLoad);
        dataCenterService.allocateResources(loadToAllocate);

        double expectedTotalRelease = 6000;
        ResourceRequest loadToRelease = new ResourceRequest(expectedTotalRelease);
        double expectedTotalLoad = 0;


        dataCenterService.releaseResources(loadToRelease);
        double resultTotalLoad = dataCenterService.getDataCenter()
                .getServers()
                .stream()
                .mapToDouble(Server::getLoad)
                .sum();

        assertEquals(expectedTotalLoad, resultTotalLoad);
    }

    @Test
    void releaseResources_GreaterThenMaxLoad() {
        double totalLoad = 6000;
        ResourceRequest loadToAllocate = new ResourceRequest(totalLoad);
        dataCenterService.allocateResources(loadToAllocate);

        double expectedTotalRelease = 8000;
        ResourceRequest loadToRelease = new ResourceRequest(expectedTotalRelease);
        double expectedTotalLoad = 0;


        dataCenterService.releaseResources(loadToRelease);
        double resultTotalLoad = dataCenterService.getDataCenter()
                .getServers()
                .stream()
                .mapToDouble(Server::getLoad)
                .sum();

        assertEquals(expectedTotalLoad, resultTotalLoad);
    }

    @Test
    void releaseResources_NullRequest() {
        ResourceRequest input = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dataCenterService.releaseResources(input));
        assertEquals("request is null", exception.getMessage());
    }
}