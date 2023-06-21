package faang.school.godbless.sprint3.droid_secrets;

import java.io.Console;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            k = 26 - (k % 26);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                char c = m.charAt(i);
                if (Character.isLowerCase(c)) {
                    c = (char) ((c - 97 + k) % 26 + 97);
                } else if (Character.isUpperCase(c)) {
                    c = (char) ((c - 65 + k) % 26 + 65);
                }
                builder.append(c);
            }
            return builder.toString();
        };
        String decryptedMessage = encryptor.encryptMessage(message, key);
        System.out.println(decryptedMessage);
        return decryptedMessage;
    }
}
