package mailclient;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SenderRunnableTest {

    @Nested
    class SenderRunnableTests {
        @Test
        void testSenderRunnableCompletes() {
            SenderRunnable sender = new SenderRunnable(0, 10);
            assertDoesNotThrow(sender::run);
        }

        @Test
        void testSenderRunnableWhenStartEqualsEnd() {
            SenderRunnable sender = new SenderRunnable(5, 5);
            assertDoesNotThrow(sender::run);
        }

        @Test
        void testSenderRunnableWithNegativeValues() {
            SenderRunnable sender = new SenderRunnable(-5, 5);
            assertDoesNotThrow(sender::run);
        }

        @Test
        void testSenderRunnableWithBothNegative() {
            SenderRunnable sender = new SenderRunnable(-10, -5);
            assertDoesNotThrow(sender::run);
        }
    }

    @Nested
    class MailSenderMainTests {
        /**
         * Verifies that MailSender.main() completes without exceptions.
         * This integration test ensures that thread creation and management work as expected.
         */
        @Test
        void testMailSenderMainCompletes() {
            assertDoesNotThrow(() -> MailSender.main(new String[0]));
        }
    }
}
