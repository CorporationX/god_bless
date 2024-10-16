package school.faang.jbs2_33512.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoteServiceTest {

    @Test
    void call() throws Exception {
        IllegalArgumentException exceptionParamEmpty = assertThrows(IllegalArgumentException.class,
                () -> RemoteService.call(""));
        String correctErrMessage = "The service is unavailable";
        assertEquals(correctErrMessage, exceptionParamEmpty.getMessage());


        String resultParamNotEmpty = RemoteService.call("Test");
        String correctResultParamNotEmpty = "call completed";
        assertEquals(correctResultParamNotEmpty, resultParamNotEmpty);
    }
}