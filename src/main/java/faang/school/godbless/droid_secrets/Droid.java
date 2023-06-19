package faang.school.godbless.droid_secrets;

interface DroidMessageEncryptor {
    int encrypt(int key);
}

public class Droid {

    static String encryptMessage(String message, int key, DroidMessageEncryptor droidMessageEncryptor) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch != ' ') {
                int originalPosition = ch;
                char newCh = (char) (originalPosition + droidMessageEncryptor.encrypt(key));
                result.append(newCh);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public String sendEncryptedMessage(Droid toDroid, String message, int key) {
        return Droid.encryptMessage(message, key, k -> k);
    }
}

class DroidMessageReceiver {
    public static void receiveEncryptedMessage(String encryptedMessage, int key) {
        String decryptedMessage = Droid.encryptMessage(encryptedMessage, key, k -> -k);
        System.out.println(decryptedMessage);
    }
}
