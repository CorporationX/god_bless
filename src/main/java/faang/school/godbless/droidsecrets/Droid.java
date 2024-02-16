package faang.school.godbless.droidsecrets;

public class Droid {

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] chars = new char[message.length()];
            for (int i = 0; i < m.length(); i++) {
                chars[i] = (char) (m.charAt(i) + k);
            }
            return new String(chars);
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] chars = new char[message.length()];
            for (int i = 0; i < m.length(); i++) {
                chars[i] = (char) (m.charAt(i) - k);
            }
            return new String(chars);
        };
        return encryptor.encrypt(message, key);
    }
}
