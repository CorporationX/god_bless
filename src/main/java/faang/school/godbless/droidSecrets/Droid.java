package faang.school.godbless.droidSecrets;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            // Реализацию шифрования я украл, сори, не додумался сам.
            // Но я разобрался в нем и понял, как оно работает
            // https://stackoverflow.com/questions/40969024/java-shift-all-character-codes-inside-a-string-by-a-constant-value
            char[] result = new char[msg.length()];

            for (int i = 0; i < result.length; i++) {
                result[i] = (char) (msg.charAt(i) + key);
            }

            return new String(result);
        };

        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int decryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            char[] result = new char[msg.length()];

            for (int i = 0; i < result.length; i++) {
                result[i] = (char) (msg.charAt(i) - key);
            }

            return new String(result);
        };

        return decryptor.encrypt(encryptedMessage, decryptionKey);
    }
}
