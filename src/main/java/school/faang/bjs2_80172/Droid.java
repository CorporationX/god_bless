package school.faang.bjs2_80172;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int encryptKey) {
        DroidMessageEncryptor droidMessageEncryptor = (str, key) -> {
            StringBuilder encryptStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    ch = (char) (((ch - base + key) % 26) + base);
                }
                encryptStr.append(ch);
            }
            return encryptStr.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptKey);
    }

    public String decryptMessage(String message, int encryptKey) {
        DroidMessageEncryptor droidMessageEncryptor = (str, key) -> encryptMessage(str, 26 - key % 26);
        return droidMessageEncryptor.encrypt(message, encryptKey);
    }

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        String encryptMessage = encryptMessage(message, encryptionKey);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", name, encryptMessage);
        receiveMessage(droid, encryptMessage, encryptionKey);
    }

    public void receiveMessage(Droid droid, String message, int encryptionKey) {
        String decryptMessage = decryptMessage(message, encryptionKey);
        System.out.printf("%s получил расшифрованное сообщение: %s%n", droid.getName(), decryptMessage);
    }
}