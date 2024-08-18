package faang.school.godbless.bjs2_20947;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {

    @Test
    void testApplication() {
        var message = "AazZ";
        int key = 1;
        var droid = new Droid();
        var encryptedMessage = droid.sendEncryptedMessage(message, key);
        assertEquals("BbaA", encryptedMessage);
        var decryptedMessage = droid.receiveEncryptedMessage(encryptedMessage, key);
        assertEquals(message, decryptedMessage);
    }
}