package faang.school.godbless.task.droids;

public class DroidMessageReceiver {

    static public String receiveEncryptedMessage(String encryptedMessage, int encryptKey) {
        if (encryptKey < 0) {
            throw new IllegalArgumentException(Droid.EXCEPTION_NEGATIVE_KEY_VALUE);
        }

        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> msg.chars()
                .map(ch -> (ch - key > 0) ? ch - key : ch - key + Character.MAX_VALUE)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return droidMessageEncryptor.encryptMessage(encryptedMessage, encryptKey);
    }
}
