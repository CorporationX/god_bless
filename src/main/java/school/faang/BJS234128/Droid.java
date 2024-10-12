package school.faang.BJS234128;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private String name;

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
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMsg.append((char) ((ch - base + key) % 26 + base));
                } else {
                    encryptedMsg.append(ch);
                }
            }
            return encryptedMsg.toString();
        });
        return encryptor.encryptMessage(message, key);
    }

    String decryptMessage(String message, int key) {
        DroidMessageEncryptor decrypt = ((msg, encryptKey) ->
        {
            StringBuilder encryptedMsg = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMsg.append((char) ((ch - base - key + 26) % 26 + base));
                } else {
                    encryptedMsg.append(ch);
                }
            }
            return encryptedMsg.toString();
        });
        return decrypt.encryptMessage(message, key);
    }
}
