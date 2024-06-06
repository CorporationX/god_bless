package faang.school.godbless.data_center;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServerTest {
    Server serverForTest;

    @BeforeEach
    void setUp(){
        serverForTest = new Server(1, 200);
    }

    @Test
    void testServer_testAddRequest_EnergyConsumption(){
        ResourceRequest resourceRequestToAdd = new ResourceRequest(1, 20);
        serverForTest.addRequest(resourceRequestToAdd);

        assertEquals(34, serverForTest.getEnergyConsumption());
    }

    @Test
    void testServer_testAddRequestAndRemove_EnergyConsumption(){
        ResourceRequest resourceRequestToAddAndRemove = new ResourceRequest(1, 20);
        serverForTest.addRequest(resourceRequestToAddAndRemove);
        serverForTest.removeRequest(resourceRequestToAddAndRemove);

        assertEquals(10, serverForTest.getEnergyConsumption());
    }

    @Test
    void testServer_requiringTooMuchLoad(){
        ResourceRequest resourceRequestToAdd= new ResourceRequest(1, 2000);

        assertThrows(RuntimeException.class, () -> serverForTest.addRequest(resourceRequestToAdd));
    }
}