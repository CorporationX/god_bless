package faang.school.godbless.droids_secrets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DroidMessagesTests {

    Droid droid = new Droid();

    @Test
    @DisplayName("Encrypt message")
    void shouldEncryptMessage() {
        String cipher = "Thf aol mvyjl il dpao fvb";

        Assertions.assertEquals(cipher, droid.sendEncryptedMessage("May the force be with you", 7));
    }

    @Test
    @DisplayName("Decrypt message")
    void shouldDecryptMessage() {
        String message = "Thank god i have already implemented ceasar cipher algorithm few times in past";

        Assertions.assertEquals(message, droid.receiveEncryptedMessage(
                "Drkxu qyn s rkfo kvbokni swzvowoxdon mokckb mszrob kvqybsdrw pog dswoc sx zkcd",
                10));
    }
}
