package faang.school.godbless.DroidSecrets;

public class Droid {

    public void sendEncryptedMessage(DroidMessageReceiver droid, String message, int key) {
        DroidMessageEncryptor encryptor = (message1, key1) -> {
            char[] chars = message1.toCharArray();
            char[] encryptedChars = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (chars[i] + key1);
                encryptedChars[i] = chars[i];
            }
            return new String(encryptedChars);
        };
        droid.receiveEncryptedMessage(encryptor.decodeMessage(message, key), key);
    }
}
