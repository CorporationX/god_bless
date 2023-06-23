package faang.school.godbless.droidSecrets;

public class Application {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMessage = r2d2.sendEncryptedMessage(message, encryptionKey);
        String decryptedMessage = c3po.receiveEncryptedMessage(encryptedMessage, encryptionKey);
        System.out.println(encryptedMessage);
        System.out.println(decryptedMessage);
    }
}
