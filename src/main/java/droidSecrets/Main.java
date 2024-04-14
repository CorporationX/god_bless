package droidSecrets;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
        System.out.println(c3po.getReceivedMessage());

        DroidMessageReceiver receiver = new DroidMessageReceiver();

        receiver.receiveEncryptMessage(c3po.getReceivedMessage(), encryptionKey);
    }
}
