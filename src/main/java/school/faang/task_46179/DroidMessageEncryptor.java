package school.faang.task_46179;

public class DroidMessageEncryptor {
    public String encrypt(int key, String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char cr = message.charAt(i);

            // If the symbol is one of the letters of the Latin alphabet, then the letter is encrypted
            if (cr >= 65 && cr <= 90 || cr >= 97 && cr <= 122) {
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

            // If the symbol is one of the letters of the Latin alphabet + the encryption key,
            // then the letter is decrypted
            if ((cr >= 65 + key && cr <= 90 + key) || (cr >= 97 + key && cr <= 122 + key)) {
                cr = (char) (cr - key);
            }

            decryptedMessage.append(cr);
        }

        return decryptedMessage.toString();
    }
}