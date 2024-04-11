package droidSecrets;

import lombok.Data;

@Data
public class Droid {
    private String receivedMessage;

    public void sendEncryptedMessage(Droid droid, String message, Integer encryptionKey) {
        DroidMessageEncryptor encryptor = ((mess, enK) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (char symbol : mess.toCharArray()) {
                stringBuilder.append((char) (symbol + enK));
            }
            return stringBuilder.toString();
        });

        droid.setReceivedMessage(encryptor.encrypt(message, encryptionKey));
    }
}
