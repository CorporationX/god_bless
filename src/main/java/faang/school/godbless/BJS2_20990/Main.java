package faang.school.godbless.BJS2_20990;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "RobertZz123!?";
        int encryptionKey = 2;

        String encryptedMessage = r2d2.sendEncryptedMessage(message, encryptionKey);
        String decryptMessage = c3po.receiveEncryptedMessage(encryptedMessage, encryptionKey);

        System.out.println(encryptedMessage);
        System.out.println(decryptMessage);
    }
}
