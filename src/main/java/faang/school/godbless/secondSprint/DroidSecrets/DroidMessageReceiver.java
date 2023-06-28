package faang.school.godbless.secondSprint.DroidSecrets;

public class DroidMessageReceiver {
    public static String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor messageEncryptor = (m, k) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                char letter = m.charAt(i);
                if (Character.isLowerCase(letter)) {
                    letter = (char) ((letter - key - 'a' + 26) % 26 + 'a');
                } else if (Character.isUpperCase(letter)) {
                    letter = (char) ((letter - key - 'A' + 26) % 26 + 'A');
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
