package faang.school.godbless.android;

import java.util.stream.Collectors;

public class Droid {

    public String sendEncryptedMessage(Droid enotherDroid, String message, int keyEncryption) {
        DroidMessageEncryptor encryptor = (mess, key) -> mess.chars()
                .map(c -> c * key)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        return encryptor.encryptionMessage(message, keyEncryption);
    }

    public String receiveEncryptedMessage(String message, int keyEncryption) {
        DroidMessageReceiver receiver = (mess, key) -> mess.chars()
                .map(c-> c / key)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        return receiver.receiveEncryptedMessage(message, keyEncryption);
    }
}
