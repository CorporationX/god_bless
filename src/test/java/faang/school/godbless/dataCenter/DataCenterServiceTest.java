package faang.school.godbless.dataCenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class DataCenterServiceTest {

    private DataCenterService dataCenterService;
    private DataCenter dataCenter;

    private Server server;

    private ResourceRequest resourceRequest;

    @BeforeEach
    @DisplayName("Set up variables for testing")
    public void beforeEachSetup() {
        resourceRequest = ResourceRequest.builder().load(10.0).build();
        server = Server.builder()
                .load(40.0)
                .maxLoad(70.0)
                .energyConsumption(40.0)
                .build();

        ArrayList<Server> listOfServers = new ArrayList<>();
        listOfServers.add(server);

        dataCenter = new DataCenter();
        dataCenter.setServers(listOfServers);

        dataCenterService = new DataCenterService(dataCenter);
    }

    @Test
    @DisplayName("Success adding server in data center via dataCenterService")
    void testAddServerSuccess() {
        Server expectedServer = new Server(40.0, 100.0, 10.0);

        Server actualCreatedServer = dataCenterService.addServer(expectedServer);

        assertEquals(expectedServer, actualCreatedServer);
    }

    @Test
    void testDeleteServerSuccess() {
        Server serverForDeleting = server;
        int expectedAmountOfServers = dataCenterService.getDataCenter().getServers().size() - 1;

        boolean actualResult = dataCenterService.deleteServer(serverForDeleting);

        assertAll(
                () -> assertTrue(actualResult),
                () -> assertEquals(expectedAmountOfServers, dataCenterService.getDataCenter().getServers().size()));
    }

    @Test
    void testGetTotalEnergyConsumption() {
        Double expectedTotalLoad = dataCenterService.getDataCenter().getServers().get(0).getLoad();

        Double actualTotalLoad = dataCenterService.getTotalEnergyConsumption();

        assertEquals(expectedTotalLoad, actualTotalLoad);
    }

    @Test
    void testGetTotalEnergyConsumptionFailed() {
        dataCenter.setServers(null);
        String expectedErrorMessage = "Data center contain null instead list of servers";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> dataCenterService.getTotalEnergyConsumption());

        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @Test
    void testAllocateResources() {
        boolean expectedResult = true;

        boolean actualResult = dataCenterService.allocateResources(resourceRequest);

        assertEquals(expectedResult, actualResult);
    }

    static Stream<ResourceRequest> getIncorrectResourceArguments() {
        return Stream.of(
                ResourceRequest.builder().load(null).build(),
                null
        );
    }

    @ParameterizedTest
    @MethodSource("getIncorrectResourceArguments")
    void testAllocateResourcesWithIncorrectResourceRequest(ResourceRequest request) {
        boolean expectedResult = false;

        boolean actualResult = dataCenterService.allocateResources(request);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testReleaseResourcesSuccess() {
        boolean expectedResult = true;

        boolean actualResult = dataCenterService.releaseResources(resourceRequest);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("getIncorrectResourceArguments")
    void testReleaseResourcesWithIncorrectResourceRequest(ResourceRequest request) {
        boolean expectedResult = false;

        boolean actualResult = dataCenterService.allocateResources(request);

        assertEquals(expectedResult, actualResult);
    }
}
