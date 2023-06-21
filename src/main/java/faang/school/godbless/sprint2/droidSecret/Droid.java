package faang.school.godbless.sprint2.droidSecret;

public class Droid {
    public String sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                char ch = m.charAt(i);
                char newCh = (char) ((int) ch + k);
                result.append(newCh);
            }
            return result.toString();
        };
        return droidMessageEncryptor.encryptor(message, key);
    }

}

