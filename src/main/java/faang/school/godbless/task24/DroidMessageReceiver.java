package faang.school.godbless.task24;

public class DroidMessageReceiver {
    public void receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, k) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    int offset = Character.isUpperCase(c) ? 'A' : 'a';
                    decryptedMessage.append((char) (((c - offset - k + 26) % 26) + offset));
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };

        String decryptedMessage = decryptor.encrypt(message, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
