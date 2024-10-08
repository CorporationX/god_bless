package secrets_of_the_droids;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {
    private final Droid R2D2 = new Droid("R2D2");
    private final Droid C3PO = new Droid("C3PO");
    private final Droid BB8 = new Droid("BB-8");

    @Test
    void sendMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String FIRST_MESSAGE = "Join the Rebellion!";
        int FIRST_ENCRYPTION_KEY = 3;
        R2D2.sendMessage(C3PO, FIRST_MESSAGE, FIRST_ENCRYPTION_KEY);

        assertEquals(
                "R2D2 отправил зашифрованное сообщение: Mrlq wkh Uhehoolrq!\n" +
                "C3PO получил расшифрованное сообщение: Join the Rebellion!\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }

    @Test
    void receiveMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String SECOND_MESSAGE = "The Death Star is operational!";
        int SECOND_ENCRYPTION_KEY = 7;
        BB8.receiveMessage(SECOND_MESSAGE, SECOND_ENCRYPTION_KEY);

        assertEquals(
                "BB-8 получил расшифрованное сообщение: Max Wxtma Lmtk bl hixktmbhgte!\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}