package faang.school.godbless.BJS2_20971;

import lombok.Getter;


public class Droid {
    @Getter
    private DroidMessageReceiver receiver = new DroidMessageReceiver();
    private DroidMessageEncryptor encryptor = (message, encryptionKey) -> {
        StringBuilder encryptMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + encryptionKey) % 26 + base);
            }
            encryptMessage.append(c);
        }
        return encryptMessage.toString();
    };

    public void sendEncryptedMessage(Droid droid, String message, int encryptionKey) {
        String encryptedMessage = this.encryptor.encrypt(message, encryptionKey);
        droid.getReceiver().receiveEncryptedMessage(encryptedMessage, encryptionKey);
    }
}
