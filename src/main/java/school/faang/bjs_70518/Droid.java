package school.faang.bjs_70518;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {

    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> m.chars().map(c -> c + k)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> m.chars().map(c -> c - k)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return encryptor.encrypt(message, key);
    }

    public void sendMessage(String message, int key, Droid droidThatReceives) {
        String encrypted = encryptMessage(message, key);
        System.out.printf("Droid %s sent encrypted message %s\n", this.getName(), encrypted);
        String decrypted = droidThatReceives.receiveMessage(encrypted, key);
        System.out.printf("Droid %s received decrypted message %s\n", droidThatReceives.getName(), decrypted);
    }

    public String receiveMessage(String message, int key) {
        return decryptMessage(message, key);
    }

}
