package faang.school.godbless.task24;

public class Droid {
    public DroidMessageEncryptor droidMessageEncryptor = (x, k) -> {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : x.toCharArray()) {
            if (Character.isLetter(c)) {
                int offset = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedMessage.append((char) (((c - offset + k) % 26) + offset));
            } else {
                encryptedMessage.append(c);
            }
        }
        return encryptedMessage.toString();
    };

    public void sendEncryptedMessage(Droid droid, String message, int key) {

        droid.receiveEncryptedMessage(droidMessageEncryptor.encrypt(message, key), key);
    }

    public void receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageReceiver receiver = new DroidMessageReceiver();
        receiver.receiveEncryptedMessage(encryptedMessage, key);
    }

}
