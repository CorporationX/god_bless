package faang.school.godbless.sprint2.droidSecret;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            if (encryptedMessage == null || encryptedMessage.isEmpty()) {
                throw new IllegalArgumentException("message is null");
            }

            int n = encryptedMessage.length();
            char[] chars = encryptedMessage.toCharArray();

            for (int i = 0; i < encryptedMessage.length(); i++) {
                char currentChar = chars[i];
                if (Character.isLetter(currentChar)) {
                    char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                    int index = currentChar - base;
                    int shiftedIndex = index <= key ? (index + 26 - key) % 26 : (index - key) % 26;
                    char shiftedChar = (char) (base + shiftedIndex);
                    chars[i] = shiftedChar;
                } else {
                    chars[i] = currentChar;
                }
            }
            return new String(chars);
        };
        return (droidMessageEncryptor.encryptor(encryptedMessage, key));
    }
}
