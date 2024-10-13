package school.faang.BJS234128;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private String name;
    private static final int ALPHABET_LENGTH = 26;

    public void sendMessage(Droid droid, String msg, int encryptKey) {
        String encryptMsg = encryptMessage(msg, encryptKey);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptMsg);
        System.out.println(droid.getName() + " получил расшифрованное сообщение: " + decryptMessage(encryptMsg, encryptKey));
    }

    String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = ((msg, encryptKey) ->
        {
            StringBuilder encryptedMsg = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char encrypted = (char) (ch + key);
                    if ((Character.isLowerCase(ch) && encrypted > 'z') || (Character.isUpperCase(ch) && encrypted > 'Z')) {
                        encryptedMsg.append((char) ((ch - (ALPHABET_LENGTH - key))));
                    } else {
                        encryptedMsg.append(encrypted);
                    }
                } else {
                    encryptedMsg.append(ch);
                }
            }
            return encryptedMsg.toString();
        });
        return encryptor.encryptMessage(message, key);
    }

    String decryptMessage(String message, int key) {
        return encryptMessage(message, ALPHABET_LENGTH - key);
    }
}
