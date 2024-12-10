package school.faang.task_46246;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        isValid(message, key);
        DroidMessageEncryptor encryptor = (mes, k) -> cryptProcess(mes, (charB) -> (char) (charB + k));
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        isValid(message, key);
        DroidMessageEncryptor decrypt = (mes, k) -> cryptProcess(mes, (charB) -> (char) (charB - k));
        return decrypt.encrypt(message, key);
    }

    private String cryptProcess(String message, Function<Character, Character> cryptFunction) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            decrypted.append((char) (cryptFunction.apply(c)));
        }
        return decrypted.toString();
    }

    public void sendMessage(Droid recipient, String message, int key) {
        isValid(message, key);
        String encryptedMessage = encryptMessage(message, key);
        System.out.println("The droid " + this.name + " sent an encrypted message: " + encryptedMessage);
        receiveMessage(recipient, encryptedMessage, key);
    }

    public void receiveMessage(Droid recipient, String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println("The droid " + recipient.getName() + " received a decrypted message: " + decryptedMessage);
    }

    public void isValid( String message, int key) {
        if( message == null || message.isEmpty() || key < 1 ) {
            throw new IllegalArgumentException("Invalid message or key should not be grater than 0");
        }
    }
}
