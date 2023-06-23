package faang.school.godbless.droid_secrets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroidMessageReceiverTest {

    @Test
    void testReceiveEncryptedMessage(){
        String actualOutput = new DroidMessageReceiver().receiveEncryptedMessage("Ifmmp",1);
        String expectedOutput = "Hello";

        assertEquals(expectedOutput,actualOutput);
    }
}
