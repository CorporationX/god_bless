package faang.school.godbless.droids;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {

    private final Droid R2D2 = new Droid();
    private final String MESSAGE_DECRYPTED = "!ABCabcXYZxyz%";
    private final String MESSAGE_ENCRYPTED = "!BCDbcdYZAyza%";
    private final int POS_ENCTYPTION_KEY = 1;
    private final int NEG_ENCTYPTION_KEY = -1;

    @Test
    void sendNegativeEncryptedMessageTest() {
        assertEquals(MESSAGE_DECRYPTED, R2D2.encrypt(MESSAGE_ENCRYPTED, NEG_ENCTYPTION_KEY));
    }

    @Test
    void receiveNegativeEncryptedMessageTest() {
        assertEquals(MESSAGE_ENCRYPTED, R2D2.decrypt(MESSAGE_DECRYPTED, NEG_ENCTYPTION_KEY));
    }

    @Test
    void sendPositiveEncryptedMessageTest() {
        assertEquals(MESSAGE_ENCRYPTED, R2D2.encrypt(MESSAGE_DECRYPTED, POS_ENCTYPTION_KEY));
    }

    @Test
    void receivePositiveEncryptedMessageTest() {
        assertEquals(MESSAGE_DECRYPTED, R2D2.decrypt(MESSAGE_ENCRYPTED, POS_ENCTYPTION_KEY));
    }
}