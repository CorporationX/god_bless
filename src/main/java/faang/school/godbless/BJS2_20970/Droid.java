package faang.school.godbless.BJS2_20970;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, encryptKey) -> {
            char[] chars = msg.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (chars[i] + encryptKey);
            }
            return String.valueOf(chars);
        };
        return droidMessageEncryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageDecryptor = (msg, encryptKey) -> {
            char[] chars = message.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (chars[i] - key);
            }
            return String.valueOf(chars);
        };
        return droidMessageDecryptor.encrypt(message, key);
    }
}
