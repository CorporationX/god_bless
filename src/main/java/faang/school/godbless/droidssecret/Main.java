package faang.school.godbless.droidssecret;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        System.out.println("Encrypted message: " + encryptedMsg);
        String decryptedMsg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println("Decrypted message: " + decryptedMsg);
    }
}