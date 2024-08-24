package faang.school.godbless.fi.droids;

public class Main {

    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "may the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);

        System.out.println("> encrypted message: " + encryptedMsg);
        System.out.println("> original message: " + msg);
    }

}
