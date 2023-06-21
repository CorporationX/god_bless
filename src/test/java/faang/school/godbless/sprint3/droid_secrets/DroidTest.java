package faang.school.godbless.sprint3.droid_secrets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("abc", "def", 3),
                Arguments.of("UVW", "ABC", 6),
                Arguments.of("def", "abc", -3),
                Arguments.of("ABC", "XYZ", -3)
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void sendEncryptedMessage_messagesShouldMatch(String message, String expected, int key) {
        Droid sender = new Droid();
        Droid recipient = new Droid();
        sender.sendEncryptedMessage(recipient, message, key);

        assertEquals(expected, recipient.getMessage());
    }


}