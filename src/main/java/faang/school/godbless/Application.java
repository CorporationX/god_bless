package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        DroidMessageReceiver c3po = new DroidMessageReceiver();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
    }
}