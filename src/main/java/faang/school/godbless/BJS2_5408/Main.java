package faang.school.godbless.BJS2_5408;

public class Main {
    public static void main(String[] args) {
        String messages = "May the Force be with you!";
        int encryptionKey = 3;

        Droid droid = new Droid();
        String encryptedMsg = droid.sendEncryptedMessage(messages, encryptionKey);

        System.out.println(encryptedMsg);
        System.out.println(droid.receiveEncryptedMessage(encryptedMsg, encryptionKey));
    }
}
