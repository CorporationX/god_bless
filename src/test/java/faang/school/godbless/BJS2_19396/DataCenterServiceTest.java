package faang.school.godbless.BJS2_19396;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataCenterServiceTest {

    private DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        List<Server> servers = new LinkedList<>(List.of(
                new Server(100,  120, 150),
                new Server(400,  250, 530)
        ));
        dataCenter = new DataCenter(servers);
    }

    @Test
    void addServer() {
        Server server = new Server(404,  120, 120);
        List<Server> correctAnswer = List.of(
                new Server(100,  120, 150),
                new Server(400,  250, 530),
                server
        );
        double correctEnergyConsumptionAllServers = 490;

        DataCenterService.addServer(dataCenter, server);
        List<Server> result = dataCenter.getServers();
        double resultEnergyConsumptionAllServers = dataCenter.getEnergyConsumption();

        assertEquals(correctAnswer, result);
        assertEquals(correctEnergyConsumptionAllServers, resultEnergyConsumptionAllServers);
    }

    @Test
    void removeServer() {
        List<Server> correctAnswer = List.of(new Server(400,  250, 530));
        double correctEnergyConsumptionAllServers = 250;

        DataCenterService.removeServer(dataCenter,
                new Server(100,  120, 150));
        List<Server> result = dataCenter.getServers();
        double resultEnergyConsumptionAllServers = dataCenter.getEnergyConsumption();

        assertEquals(correctAnswer, result);
        assertEquals(correctEnergyConsumptionAllServers, resultEnergyConsumptionAllServers);
    }

    @Test
    void allocateResources() {
        ResourceRequest request = new ResourceRequest(2400);
        double[] correctAnswer = {100, 1000, 1000, 800};

        DataCenterService.allocateResources(dataCenter, request);
        List<Server> resultServers = dataCenter.getServers();
        double[] result = listServerToArrayLoad(resultServers);

        assertArrayEquals(correctAnswer, result);
    }

    private double[] listServerToArrayLoad(List<Server> servers) {
        double[] loads = new double[servers.size()];

        for (int i = 0; i < servers.size(); i++) {
            loads[i] = servers.get(i).getLoad();
        }

        return loads;
    }

    @Test
    void releaseResources() {
        ResourceRequest request = new ResourceRequest(450);
        List<Server> correctAnswer = List.of(new Server(50,  250, 530));

        DataCenterService.releaseResources(dataCenter, request);
        List<Server> result = dataCenter.getServers();

        assertEquals(correctAnswer, result);
    }
}