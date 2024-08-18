package faang.school.godbless.BJS2_20962;

public class Droid {


    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String sendEncryptedMessage(String message, Integer key) {

        DroidMessageEncryptor encryptor = (message1, key1) -> {
            StringBuilder result = new StringBuilder();
            for (char c : message1.toCharArray()) {
                if (alphabet.contains(String.valueOf(c))) {
                    int newIndex = (alphabet.indexOf(c) + key1) % alphabet.length();
                    result.append(alphabet.charAt(newIndex));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String encryptedMessage, Integer key) {
        DroidMessageEncryptor decryptor = ((encryptedMessage1, key1) -> {
            StringBuilder result = new StringBuilder();
            for (char c : encryptedMessage1.toCharArray()) {
                if (alphabet.contains(String.valueOf(c))) {
                    int index = alphabet.indexOf(c);
                    int delta;
                    int newIndex = (delta = index - key1) >= 0 ? delta : alphabet.length() + delta;
                    result.append(alphabet.charAt(newIndex));
                }
                else {
                    result.append(c);
                }
            }
            return result.toString();
        });
        return decryptor.encrypt(encryptedMessage, key);
    }
}
