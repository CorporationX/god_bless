package faang.school.godbless.secrets_of_droids;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid();
        Droid droid2 = new Droid();
        String message = "May the Force be with you";
        int encryptionKey = 3;
        String encryptionMessage = droid1.sendEncryptedMessage(message, encryptionKey);
        String msg = droid2.receiveEncryptedMessage(encryptionMessage, encryptionKey);
        System.out.println(encryptionMessage);
        System.out.println(msg);
    }
}
