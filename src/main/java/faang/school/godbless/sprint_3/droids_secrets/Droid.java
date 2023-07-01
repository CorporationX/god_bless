package faang.school.godbless.sprint_3.droids_secrets;

public class Droid {
    public static void main(String... args) {
        String result = "It's Bootcamp Beta";
        Droid droid = new Droid();
        String encryptedMessage = droid.sendEncryptedMessage(droid, result, 2);
        System.out.println(encryptedMessage);
        droid.receiveEncryptedMessage(encryptedMessage, 2);
    }

    public String sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor messageEncryptor = ((stroke, value) -> {
            if (message == null || message.isEmpty()) {
                throw new IllegalArgumentException("Message is Empty");
            }
            int n = message.length();
            char[] result = new char[n];
            for (int i = 0; i < n; i++) {
                char c = message.charAt(i);
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int index = c - base;
                    int shiftedIndex = (index + key) % 26;
                    if (shiftedIndex < 0)
                        shiftedIndex += 26;
                    char shiftedChar = (char) (base + shiftedIndex);
                    result[i] = shiftedChar;
                } else {
                    result[i] = c;
                }
            }
            return new String(result);
        });
        return messageEncryptor.encrypt(message, key);
    }

    public void receiveEncryptedMessage(String encryptedMessage, int key) {
        if (encryptedMessage == null || encryptedMessage.isEmpty()) {
            throw new IllegalArgumentException("Incoming encryptedMessage is Empty");
        }
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
        String finalVersion = new String(chars);
        System.out.println(finalVersion);
    }
}