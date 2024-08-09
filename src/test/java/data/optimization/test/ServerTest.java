package data.optimization.test;

import data.optimization.ResourceRequest;
import data.optimization.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServerTest {
    private Server server;

    @BeforeEach
    void setUp() {
        server = new Server(8, 1);
    }

    @Test
    @DisplayName("Testing add request to server")
    void serverTest_addingRequest() {
        ResourceRequest request = new ResourceRequest(5);
        double expected = server.getLoad() + request.getLoad();

        server.addRequest(request);

        assertAll(
                () -> assertTrue(server.getRequestsLoad().containsKey(request)),
                () -> assertEquals(expected, server.getLoad())
        );

    }

    @Test
    @DisplayName("Testind add request with not enough available load")
    void serverTest_addingRequestWithTooMuchLoad() {
        ResourceRequest request = new ResourceRequest(10);
        double expected = server.getLoad();

        server.addRequest(request);

        assertAll(
                () -> assertFalse(server.getRequestsLoad().containsKey(request)),
                () -> assertEquals(expected, server.getLoad())
        );
    }

    @Test
    @DisplayName("Testing add null request")
    void serverTest_addingNullRequest() {
        assertThrows(NullPointerException.class, () -> server.addRequest(null));
    }

    @Test
    @DisplayName("Testing remove request from server")
    void serverTest_removeRequest() {
        ResourceRequest request = new ResourceRequest(5);
        server.addRequest(request);
        double expected = server.getLoad() - request.getLoad();

        server.removeRequest(request);

        assertAll(
                () -> assertFalse(server.getRequestsLoad().containsKey(request)),
                () -> assertTrue(server.getRequestsLoad().isEmpty()),
                () -> assertEquals(expected, server.getLoad())
        );
    }

    @Test
    @DisplayName("Testing remove request not on server")
    void serverTest_removeNotAvailableRequest() {
        ResourceRequest request = new ResourceRequest(5);
        server.addRequest(request);
        double expected = server.getLoad();

        server.removeRequest(new ResourceRequest(7));

        assertAll(
                () -> assertEquals(1, server.getRequestsLoad().size()),
                () -> assertEquals(expected, server.getLoad())
        );
    }

    @Test
    @DisplayName("Testing remove null request")
    void serverTest_removeNullRequest() {
        assertThrows(NullPointerException.class, () -> server.removeRequest(null));
    }

    @Test
    @DisplayName("Testing get available load with no request on server")
    void serverTest_getAvailableLoadOnFullEmptyServer() {
        assertEquals(server.getMaxLoad(), server.getAvailableLoad());
    }

    @Test
    @DisplayName("Testing get available load with request added")
    void serverTest_getAvailableLoadWithAddedRequest() {
        ResourceRequest request = new ResourceRequest(5);
        double expected = server.getMaxLoad() - request.getLoad();

        server.addRequest(request);

        assertEquals(expected, server.getAvailableLoad());
    }

    @Test
    @DisplayName("Testing get available load after remove request")
    void serverTest_getAvailableLOadAfterRemoveRequest() {
        ResourceRequest request = new ResourceRequest(5);
        server.addRequest(request);
        server.removeRequest(request);

        assertEquals(server.getMaxLoad(), server.getAvailableLoad());
    }
}
