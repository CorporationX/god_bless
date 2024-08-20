package faang.school.godbless.BJS2_23624;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SenderRunnableTest {

    @Test
    public void testEmailSending() {
        int startIndex = 0;
        int endIndex = 4; // отправка 5 писем
        StringBuilder output = new StringBuilder();

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
        sender.run();

        String[] expectedOutput = {
                "Email 0 отправлен успешно",
                "Письмо 1 отправлено успешно",
                "Email 2 отправлен успешно",
                "Email 3 отправлен успешно",
                "Email 4 отправлен успешно"
        };

        String[] actualOutput = outputStream.toString().trim().split(System.lineSeparator());
        assertEquals(expectedOutput.length, actualOutput.length);
        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], actualOutput[i]);
        }

        System.setOut(originalOut);

    }

}
