package faang.school.godbless.BJS2_20970;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = new DroidMessageEncryptor() {

        }

        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key);
        }
        return String.valueOf(chars);
    }

    public String receiveEncryptedMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - key);
        }
        return String.valueOf(chars);
    }
}
