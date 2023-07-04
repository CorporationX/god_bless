package faang.school.godbless;

public class Droid {
    public String sendEncryptedMessage(String message, int key, DroidMessageEncryptor encoder) {
        return encoder.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key, DroidMessageEncryptor decoder) {
        return decoder.encrypt(message, key);
    }
}
