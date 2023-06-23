package faang.school.godbless.sprint3.droidsSecrets.classes;

import faang.school.godbless.sprint3.droidsSecrets.interfaces.DroidMessageEncryptor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Droid {
    private String encryptedMessage;

    public void sendEncryptedMessage(Droid droid, String message, int encryptKey) {
        DroidMessageEncryptor encryptor = (encryptedMessage, encryptedKey) -> {
            char[] chars = message.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c : chars) {
                builder.append(Character.toString(c + encryptedKey));
            }
            return builder.toString();
        };
        String encryptedMessage = encryptor.encrypt(message, encryptKey);
        droid.setEncryptedMessage(encryptedMessage);
    }
}
