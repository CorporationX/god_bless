package faang.school.godbless.BJS_9017;

public class APP_9017 {

    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3p0 = new Droid();
        String encryptedMsg = r2d2.sendEncryptedMessage("May the force be with you", 1);
        System.out.println("Encrypted message is: " + encryptedMsg);
        String receivedMessage = c3p0.receiveEncryptedMessage(encryptedMsg, 1);
        System.out.println("Received message is: " + receivedMessage);
    }
}