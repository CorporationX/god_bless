package faang.school.godbless.secondSprint.DroidSecrets;

public class DroidMessageReceiver {
    public static String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor messageEncryptor = (m, k) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                char letter = (char) (m.charAt(i) - k);
                if (letter < 32) {
                    letter = 32;
                } else if (letter < 65 || letter > 90 && letter < 97) {
                    letter += 26;
                }
                stringBuilder.append(letter);
            }
            return stringBuilder.toString();
        };

        String originalMessage = messageEncryptor.encrypt(encryptedMessage, key);
        System.out.println(originalMessage);
        return originalMessage;
    }
}
