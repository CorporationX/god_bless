package school.faang.task_46179;

public class DroidMessageEncryptor {
    public String encrypt(int key, String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char cr = message.charAt(i);

            if (Character.isLetter(cr)) {
                cr = (char) (cr + key);
            }

            encryptedMessage.append(cr);
        }

        return encryptedMessage.toString();
    }

    public String decrypt(int key, String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char cr = message.charAt(i);

            if (Character.isLetter(cr - key)) {
                cr = (char) (cr - key);
            }

            decryptedMessage.append(cr);
        }

        return decryptedMessage.toString();
    }
}