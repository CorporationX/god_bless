package faang.school.godbless.task.droids;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidMessageReceiverTest {

    @Test
    void receiveEncryptedMessage_positiveCase() {
        assertEquals("Hello there!", DroidMessageReceiver.receiveEncryptedMessage("бюѕѕјЉѝёюћюЊ", 1001));
    }
}