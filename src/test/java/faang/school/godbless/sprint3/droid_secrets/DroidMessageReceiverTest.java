package faang.school.godbless.sprint3.droid_secrets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidMessageReceiverTest {

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("def", "abc", 3),
                Arguments.of("ABC", "UVW", 6),
                Arguments.of("abc", "def", -3),
                Arguments.of("XYZ", "ABC", -3)
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void receiveEncryptedMessage(String message, String expected, int key) {
        Droid sender = new Droid();
        Droid recipient = new Droid();
        DroidMessageReceiver receiver = new DroidMessageReceiver();
        sender.sendEncryptedMessage(recipient, message, key);

        assertEquals(expected, receiver.receiveEncryptedMessage(message, key));
    }
}