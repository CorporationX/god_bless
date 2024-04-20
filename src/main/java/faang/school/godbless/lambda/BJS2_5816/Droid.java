package faang.school.godbless.lambda.BJS2_5816;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = getEncryptorDecryptor(true);
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor decryptor = getEncryptorDecryptor(false);
        return decryptor.encrypt(message, encryptionKey);
    }

    private DroidMessageEncryptor getEncryptorDecryptor(boolean doEncrypt) {
        return (msg, key) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                stringBuilder.append((char) (doEncrypt ? ch + key : ch - key));
            }
            return stringBuilder.toString();
        };
    }
}
