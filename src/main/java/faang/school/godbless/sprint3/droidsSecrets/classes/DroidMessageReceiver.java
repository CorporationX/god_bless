package faang.school.godbless.sprint3.droidsSecrets.classes;

import faang.school.godbless.sprint3.droidsSecrets.interfaces.DroidMessageEncryptor;

public class DroidMessageReceiver {

    public String receiveEncryptedMessage(String encrypted, int encryptKey) {
        DroidMessageEncryptor droidMessageEncryptor = (encryptedMessage, encryptedKey) -> {
            char[] chars = encryptedMessage.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c : chars) {
                builder.append(Character.toString(c - encryptedKey));
            }
            return builder.toString();
        };
        return droidMessageEncryptor.encrypt(encrypted, encryptKey);
    }
}
