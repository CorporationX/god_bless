package faang.school.godbless.task.lambda.secret.of.droids;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            char[] chars = msg.toCharArray();
            StringBuilder encMsg = new StringBuilder();
            for (char ch : chars) {
                encMsg.append((char) (ch + key));
            }
            return encMsg.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (encMsg, key) -> {
            char[] chars = encMsg.toCharArray();
            StringBuilder msg = new StringBuilder();
            for (char ch : chars) {
                msg.append((char) (ch - key));
            }
            return msg.toString();
        };
        return droidMessageEncryptor.encrypt(encryptedMsg, encryptionKey);
    }
}
