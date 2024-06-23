package faang.school.godbless.fun_interfaces_lambdas.task_11;

import lombok.Data;

@Data
public class Droid {
    private String message = null;

    public void sendEncryptedMessage(Droid otherDroid, String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (messageEnc, key) -> {
            char[] messageChars = messageEnc.toCharArray();
            for (int i = 0; i < messageChars.length; i++) {
                char ch = messageChars[i];

                if (Character.isLowerCase(ch)) {
                    messageChars[i] = (char) ((ch - 'a' + key) % 26 + 'a');
                } else if (Character.isUpperCase(ch)) {
                    messageChars[i] = (char) ((ch - 'A' + key) % 26 + 'A');
                }
            }
            return String.valueOf(messageChars);
        };
        otherDroid.setMessage(encryptor.encrypt(message, encryptionKey));
    }
}
