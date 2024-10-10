package school.faang.Droids;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private static final int COUNT_OF_WORDS = 26;

    private String name;

    public String encryptMessage(String message, int key) {
        int shift = key % 26;
        DroidMessageEncryptor encryptor = (m, k) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char a;
                    if (Character.isUpperCase(c)) {
                        a = 'A';
                    } else {
                        a = 'a';
                    }
                    sb.append((char) ((c - a + shift + COUNT_OF_WORDS) % 26 + a));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        return encryptMessage(message, -key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        System.out.println(name + " sent message to " + recipient.getName() + ": " + encryptMessage(message, key));
        recipient.receiveMessage(encryptMessage(message, key), key);
    }

    public void receiveMessage(String message, int key) {
        System.out.println(name + " received message from: " + decryptMessage(message, key));
    }
}
