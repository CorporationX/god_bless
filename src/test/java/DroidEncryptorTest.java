import org.junit.jupiter.api.Test;
import school.faang.droidSecrets.Droid;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroidEncryptorTest {
    private final Droid r2d2 = new Droid("R2D2");

    @Test
    public void testEncryptor() {
        // arrange
        String message = "MESsage, 3, 2, 1...";
        int key = 3;
        String expected = "PHVvdjh, 3, 2, 1...";

        // act
        String actual = r2d2.encryptMessage(message, key);

        // assert
        assertEquals(expected, actual, "Should return new message");
    }

    @Test
    public void testDecryptor() {
        // arrange
        String message = "some OTHER message, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0.0, -100zz!!!";
        int key = 3;

        // act
        String encryptedMessage = r2d2.encryptMessage(message, key);
        String actual = r2d2.decryptMessage(encryptedMessage, key);

        // assert
        System.out.println(encryptedMessage);
        assertEquals(message, actual, "Should return the same message.");
    }

    @Test
    public void testIfReceivesMessage() {
        // arrange
        String message = "PHVvdjh, 3, 2, 1...";
        int key = 3;
        String expected = "MESsage, 3, 2, 1...";

        // act
        String actual = r2d2.receiveMessage(message, key);

        // assert
        assertEquals(expected, actual);
    }
    // тест на sendMessage решил не делать, тк уже протестил все что входит в его функционал, и не хотелось делать костыли
}
