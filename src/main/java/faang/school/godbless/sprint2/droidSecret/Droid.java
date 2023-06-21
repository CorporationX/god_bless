package faang.school.godbless.sprint2.droidSecret;

public class Droid {
    public String sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                char oldChar = m.charAt(i);
                char newChar = (char) ((int) oldChar + k);
                result.append(newChar);
            }
            return result.toString();
        };
        return droidMessageEncryptor.encryptor(message, key);
    }

}

