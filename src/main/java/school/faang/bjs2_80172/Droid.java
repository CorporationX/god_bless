package school.faang.bjs2_80172;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    private static DroidMessageEncryptor droidMessageEncryptor;
    private static final int ALPHABET_SIZE = 26;

    public String encryptMessage(String message, int encryptKey) {
        droidMessageEncryptor = (str, key) -> {
            StringBuilder encryptStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    ch = (char) (((ch - base + key) % ALPHABET_SIZE) + base);
                }
                encryptStr.append(ch);
            }
            return encryptStr.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptKey);
    }

    public String decryptMessage(String message, int encryptKey) {
        droidMessageEncryptor = (str, key) -> encryptMessage(str, ALPHABET_SIZE - key % ALPHABET_SIZE);
        return droidMessageEncryptor.encrypt(message, encryptKey);
    }

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        String encryptMessage = encryptMessage(message, encryptionKey);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", name, encryptMessage);
        receiveMessage(droid.getName(), encryptMessage, encryptionKey);
    }

    public void receiveMessage(String droidName, String message, int encryptionKey) {
        String decryptMessage = decryptMessage(message, encryptionKey);
        System.out.printf("%s получил расшифрованное сообщение: %s%n", droidName, decryptMessage);
    }
}