package faang.school.godbless.BJS2_21000;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Droid {
    private DroidMessageReceiver receiver = new DroidMessageReceiver();

    public void sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            String encrypted = msg.chars()
                    .mapToObj(c -> {
                        if (Character.isLetter(c)) {
                            char base = Character.isLowerCase(c) ? 'a' : 'A';
                            return (char) ((c - base + encryptionKey) % 26 + base);
                        } else {
                            return (char) c;
                        }
                    })
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();

            return encrypted;
        };
        String encryptedMessage = encryptor.encrypt(message, key);
        System.out.println("Шифр: " + encryptedMessage);
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
