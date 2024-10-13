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
        message = encryptMessage(message, shift, (u, v) -> caesarCipher(u, v));
        System.out.println(this.getName() + " send " + message + " to: " + droid.getName());
        droid.receiveMessage(message, shift);
    }

    public void receiveMessage(String message, int shift) {
        message = decryptMessage(message, shift, (u, v) -> caesarCipher(u, v));
        System.out.println(this.getName() + " decrypt to: " + message);
    }

    private static String encryptMessage(String message, int shift,
                                         DroidMessageEncryptor<String, Integer, String> messageEncryptor) {
        return messageEncryptor.apply(message, shift);
    }

    private static String decryptMessage(String message, int shift,
                                         DroidMessageEncryptor<String, Integer, String> messageEncryptor) {
        return messageEncryptor.apply(message, 0 - shift);
    }
}
