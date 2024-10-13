package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static school.faang.CaesarCipher.caesarCipher;

@Getter
@AllArgsConstructor
@ToString
public class Droid {
    private String name;

    public void sendMessage(Droid droid, String message, int shift) {
        encryptMessage(message, droid, (message, shift) -> {} );

    }

    public static void receiveMessage() {

    }

    private static void encryptMessage(String message, int shift,
                                      DroidMessageEncryptor<String, Integer, String> messageEncryptor) {
        message = caesarCipher(message, shift);
    }

    private static void decryptMessage(String message, DroidMessageEncryptor<String, Integer, String> messageEncryptor) {

    }
}
