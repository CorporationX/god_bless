package school.faang.module2.droid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class DroidTest {

    private final Droid r2d2 = new Droid();
    private final Droid c3po = new Droid();

    @Test
    void droidTest() {
        String message1 = "First msg";
        String message2 = "Second msg";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(message1, encryptionKey1, c3po);
        Assertions.assertEquals(message1, c3po.getDecryptedMessage());

        c3po.sendMessage(message2, encryptionKey2, r2d2);
        Assertions.assertEquals(message2, r2d2.getDecryptedMessage());
    }

    @Test
    void encryptTest() {
        String message = "Some message";
        int key1 = 1;
        int key2 = 2;

        String encrypted = ReflectionTestUtils.invokeMethod(r2d2, "encryptMessage", message, key1, new CaesarCipher());
        Assertions.assertEquals(
                message,
                ReflectionTestUtils.invokeMethod(r2d2, "decryptMessage", encrypted, key1, new CaesarCipher())
        );
        Assertions.assertNotEquals(
                message,
                ReflectionTestUtils.invokeMethod(r2d2, "decryptMessage", encrypted, key2, new CaesarCipher())
        );
    }
}