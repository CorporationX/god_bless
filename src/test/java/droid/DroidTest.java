package droid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DroidTest {
    @Test
    public void shouldEncryptAndDecrypt() {
        Droid mockDroid = new Droid();
        String expectedDecryptMessage = "Come in, come in, how's the encoder? Is it working?";

        String encryptedMessage = mockDroid.sendEncryptedMessage(expectedDecryptMessage, 15);
        String decryptedMessage = mockDroid.receiveEncryptedMessage(encryptedMessage, 15);

        Assertions.assertEquals(expectedDecryptMessage, decryptedMessage);
    }
}
