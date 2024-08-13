package faang.school.godbless.BJS2_21000;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Droid {
    private DroidMessageReceiver receiver = new DroidMessageReceiver();

    public void sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base + encryptionKey) % 26 + base);
                }
                encrypted.append(c);
            }
            return encrypted.toString();
        };
        String encryptedMessage = encryptor.encrypt(message, key);
        droid.getReceiver().receiveEncryptedMessage(encryptedMessage, key);
    }

    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
    }
}
