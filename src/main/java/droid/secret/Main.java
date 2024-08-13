package droid.secret;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMessage = r2d2.sendEncryptedMessage(message, encryptionKey);
        System.out.println("Зашифрованное сообщение: " + encryptedMessage);

        String resultMessage = c3po.receiveEncryptedMessage(encryptedMessage, encryptionKey);
        System.out.println("Расшифрованное сообщение: " + resultMessage);
    }
}
