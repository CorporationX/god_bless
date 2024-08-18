package faang.school.godbless.droidsMessages;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid(1);
        Droid c3po = new Droid(2);
        String message1 = "May the Force be with you!";
        int encryptionKey1 = 3;
        String message2 = "Some message";
        int encryptionKey2 = 6;

        r2d2.sendEncryptedMessage(c3po, message1, encryptionKey1);
        r2d2.sendEncryptedMessage(c3po, message2, encryptionKey2);

        for (Map.Entry<String, Integer> entry : c3po.getReceivedEncryptedMessages().entrySet()) {
            System.out.println("Encrypted message: " + entry.getKey());
            DroidMessageReceiver.receiveEncryptedMessage(entry.getKey(), entry.getValue());
        }
    }
}
