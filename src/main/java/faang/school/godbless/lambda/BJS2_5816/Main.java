package faang.school.godbless.lambda.BJS2_5816;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "He is his son!";
        int encryptionKey = 5;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        System.out.println("encryptedMsg - " + encryptedMsg);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println("msg - " + msg);
    }
}
