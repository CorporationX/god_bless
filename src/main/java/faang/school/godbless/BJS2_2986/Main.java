package faang.school.godbless.BJS2_2986;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 1;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        System.out.println(encryptedMsg);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(msg);
    }
}
