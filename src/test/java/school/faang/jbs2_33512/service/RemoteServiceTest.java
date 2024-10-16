package school.faang.jbs2_33512.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoteServiceTest {

    @Test
    void call() {
        RemoteService remoteService = new RemoteService();

        IllegalArgumentException exceptionParamEmpty = assertThrows(IllegalArgumentException.class,
                () -> remoteService.call(""));
        String correctErrMessage = "The service is unavailable";
        assertEquals(correctErrMessage, exceptionParamEmpty.getMessage());


        String resultParamNotEmpty = remoteService.call("Test");
        String correctResultParamNotEmpty = "call completed";
        assertEquals(correctResultParamNotEmpty, resultParamNotEmpty);
    }
}