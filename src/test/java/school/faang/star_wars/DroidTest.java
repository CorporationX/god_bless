package school.faang.star_wars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroidTest {

    private final ByteArrayOutputStream outContext = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContext));
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testSendMessage(Droid sender, Droid recipient, String message,
                                int encryptorKey, String expectedOutput) {
        sender.sendMessage(recipient, message, encryptorKey);
        assertEquals(expectedOutput, outContext.toString().trim());
    }

    private static Stream<Arguments> provideParameters() {
        Droid r2d2 = new Droid("R2D2");

        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String outputMessageR2d2ToC3po = "R2D2 sent encrypted message: \"Jgnnq E3RQ, K'o T2F2!\"\n" +
                "C3PO received encrypted message:\"Jgnnq E3RQ, K'o T2F2!\"\n" +
                "\tdecrypted message: \"Hello C3PO, I'm R2D2!\"";

        String outputMessageR2d2ToBb8 = "R2D2 sent encrypted message: \"Khoor EE-8, L'p U2G2!\"\n" +
                "BB-8 received encrypted message:\"Khoor EE-8, L'p U2G2!\"\n" +
                "\tdecrypted message: \"Hello BB-8, I'm R2D2!\"";

        String outputMessageC3poToR2d2 = "C3PO sent encrypted message: \"Lipps V2H2, M'q G3TS!\"\n" +
                "R2D2 received encrypted message:\"Lipps V2H2, M'q G3TS!\"\n" +
                "\tdecrypted message: \"Hello R2D2, I'm C3PO!\"";

        String outputMessageBb8ToR2d2 = "BB-8 sent encrypted message: \"Mjqqt W2I2, N'r GG-8!\"\n" +
                "R2D2 received encrypted message:\"Mjqqt W2I2, N'r GG-8!\"\n" +
                "\tdecrypted message: \"Hello R2D2, I'm BB-8!\"";

        return Stream.of(
                Arguments.of(r2d2, c3po, "Hello C3PO, I'm R2D2!", 2, outputMessageR2d2ToC3po),
                Arguments.of(r2d2, bb8, "Hello BB-8, I'm R2D2!", 3, outputMessageR2d2ToBb8),
                Arguments.of(c3po, r2d2, "Hello R2D2, I'm C3PO!", 4, outputMessageC3poToR2d2),
                Arguments.of(bb8, r2d2, "Hello R2D2, I'm BB-8!", 5, outputMessageBb8ToR2d2)
        );
    }
}
