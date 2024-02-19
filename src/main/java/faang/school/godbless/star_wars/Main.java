package faang.school.godbless.star_wars;

public class Main {
    public static void main(String[] args) {
        Droid d1 = new Droid();
        Droid d2 = new Droid();
        String message = "Hello";
        int encryptionKey = 1;

        String encryptedMsg = d1.sendEncryptedMessage(message, encryptionKey);
        System.out.println(encryptedMsg);
        String msg = d2.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(msg);
    }
}
