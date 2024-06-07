package faang.school.godbless.functionalInterfaces.droids;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    Droid battleDroid = new Droid(12);
    Droid scoutDroid = new Droid(13);

    @Test
    void testSendEncryptedMessageValidArgs() {
        //given
        var originalMessage = "Enemy is detected!";
        var expectedResponse = "R{rz'-v!-qr\"rp\"rq.";

        //when
        var encryptedMessage = scoutDroid.sendEncryptedMessage(originalMessage);

        //then
        assertNotNull(encryptedMessage);
        assertEquals(expectedResponse, encryptedMessage);
    }

    @Test
    void testSendEncryptedMessageInvalidArgs() {
        //given
        var expectedMessage = "Message must be non-valued and have some information!";

        //when
        Exception nullValuedMessageThrownException = assertThrows(IllegalArgumentException.class, () -> {
            scoutDroid.sendEncryptedMessage(null);
        });
        Exception blankMessageThrownException = assertThrows(IllegalArgumentException.class, () -> {
            scoutDroid.sendEncryptedMessage("   ");
        });


        //then
        assertEquals(expectedMessage, nullValuedMessageThrownException.getMessage());
        assertEquals(expectedMessage, blankMessageThrownException.getMessage());
    }

    @Test
    void testReceiveEncryptedMessageValidArgs() {
        //given
        var expectedResponse = "Enemy is detected!";
        var encryptedMessage = scoutDroid.sendEncryptedMessage(expectedResponse);

        //when
        var decryptedMessage = battleDroid.receiveEncryptedMessage(encryptedMessage, scoutDroid.getEncryptionKey());

        //then
        assertNotNull(decryptedMessage);
        assertEquals(expectedResponse, decryptedMessage);
    }

    @Test
    void estReceiveEncryptedMessageInvalidArgs() {
        //given
        var expectedMessage = "Encrypted message must be non-valued and have some information!";

        //when
        Exception nullValuedMessageThrownException = assertThrows(IllegalArgumentException.class, () -> {
            battleDroid.receiveEncryptedMessage(null, scoutDroid.getEncryptionKey());
        });
        Exception blankMessageThrownException = assertThrows(IllegalArgumentException.class, () -> {
            battleDroid.receiveEncryptedMessage("  ", scoutDroid.getEncryptionKey());
        });


        //then
        assertEquals(expectedMessage, nullValuedMessageThrownException.getMessage());
        assertEquals(expectedMessage, blankMessageThrownException.getMessage());
    }
}