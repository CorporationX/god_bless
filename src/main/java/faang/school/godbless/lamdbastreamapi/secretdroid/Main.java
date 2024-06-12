package faang.school.godbless.lamdbastreamapi.secretdroid;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("r2d2");
        Droid c3po = new Droid("c3po");

        final String message = "Hello, world!";
        int encryptionKey = 1;
        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(encryptedMsg);
        System.out.println(msg);
    }
}
