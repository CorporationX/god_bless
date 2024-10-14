package dima.evseenko.droid;

import org.junit.jupiter.api.Test;

import javax.crypto.spec.SecretKeySpec;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptorUtilTest {

    @Test
    void encryptMessage() {
        byte[] keyBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        byte[] encryptedMessage = EncryptorUtil.encryptMessage("Hello".getBytes(), key);

        assertArrayEquals(new byte[]{-18, -117, 26, -15, -45, -56, 33, 100, -40, 103, -120, -123, 73, -55, 20, 93}, encryptedMessage);
    }

    @Test
    void decryptMessage() {
        byte[] keyBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        byte[] encMsg = new byte[]{-18, -117, 26, -15, -45, -56, 33, 100, -40, 103, -120, -123, 73, -55, 20, 93};

        byte[] decryptedMessage = EncryptorUtil.decryptMessage(encMsg, key);

        assertEquals("Hello", new String(decryptedMessage));
    }
}