package faang.school.godbless.droid_secrets;

public class DroidMessageReceiver {
    public static void receiveEncryptedMessage(String message, Integer key) {
        DroidMessageEncryptor caesarCipher = (m, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                encryptedMessage.append((char) (c-key));
            }
            return encryptedMessage.toString();
        };
        System.out.println("Received: " + caesarCipher.encrypt(message, key));
    }
}
