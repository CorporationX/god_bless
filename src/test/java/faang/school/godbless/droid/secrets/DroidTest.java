package faang.school.godbless.droid.secrets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    Droid droid;

    @BeforeEach
    void setUp() {
        droid = new Droid();
    }

    @ParameterizedTest
    @CsvSource({"hello, 2, jgnnq", "bye, 1, czf"})
    void sendEncryptedMessage_CorrectAnswer(String message, int key, String expected) {
        String result = droid.sendEncryptedMessage(message, key);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"jgnnq, 2, hello", "czf, 1, bye"})
    void receiveEncryptedMessage_CorrectAnswer(String message, int key, String expected) {
        String result = droid.receiveEncryptedMessage(message, key);
        assertEquals(expected, result);
    }
}