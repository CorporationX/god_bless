package faang.school.godbless.javalambda.task11;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 17;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        System.out.println(encryptedMsg);
        c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
    }
}
