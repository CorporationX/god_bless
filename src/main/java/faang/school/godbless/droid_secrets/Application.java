package faang.school.godbless.droid_secrets;

import static faang.school.godbless.droid_secrets.DroidMessageReceiver.receiveEncryptedMessage;

public class Application {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "may the forse be with you";
        int encryptionKey = 3;

        String encryptMessage = r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
        System.out.println(encryptMessage);
        receiveEncryptedMessage(encryptMessage, encryptionKey);
    }
}
