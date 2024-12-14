package school.faang.task_46528;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Droid {
    private final String name;

    public void sendMessage(Droid droid, String message, int key) {
        String decryptedMessage = droid.encryptMessage(message, key);
        System.out.println(droid.getName() + " отправил зашифрованное сообщение: "
                + decryptedMessage);
        receiveMessage(decryptedMessage, key, droid);
    }

    public void receiveMessage(String message, int decryptKey, Droid droid) {
        String decryptedMessage = droid.decryptMessage(message, decryptKey);
        System.out.println(droid.getName() + " получил расшифрованное сообщение: "
                + decryptedMessage);
    }

    private String encryptMessage(String message, int encryptKey) {
        StringBuilder builder = new StringBuilder();
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    builder.append((char) ((ch - base + encryptKey) % 26 + base));
                } else {
                    builder.append(ch);
                }
            }
            return builder.toString();
        };

        return droidMessageEncryptor.encrypt(message, encryptKey);
    }

    private String decryptMessage(String message, int decryptKey) {
        StringBuilder builder = new StringBuilder();
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    builder.append((char) ((ch - base - decryptKey + 26) % 26 + base));
                } else {
                    builder.append(ch);
                }
            }
            return builder.toString();
        };

        return droidMessageEncryptor.encrypt(message, decryptKey);
    }
}
