package faang.school.godbless.sprint2.droidSecret;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < m.length(); i++) {
                char oldChar = m.charAt(i);
                char newChar = (char) ((int) oldChar - k);
                result.append(newChar);
            }
            return result.toString();
        };
        return (droidMessageEncryptor.encryptor(encryptedMessage, key));
    }
}
