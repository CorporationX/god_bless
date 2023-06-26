package faang.school.godbless.lambda.droidSecrets;

public class CheckDroidEncryptor {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("r2d2");
        Droid c3po = new Droid("c3po");
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMessage = r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
        DroidMessageReceiver droidMessageReceiver = new DroidMessageReceiver();
        droidMessageReceiver.receiveEncryptedMessage(encryptedMessage, encryptionKey);
    }
}
