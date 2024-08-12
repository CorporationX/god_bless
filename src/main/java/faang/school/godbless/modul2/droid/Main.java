package faang.school.godbless.modul2.droid;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);

        System.out.println(encryptedMsg);
        System.out.println(msg);

        int encryptionKeyTest = 0;
        String encryptedMsgTest = r2d2.sendEncryptedMessage(message, encryptionKeyTest);
        String msgTest = c3po.receiveEncryptedMessage(encryptedMsgTest, encryptionKeyTest);

        System.out.println();
        System.out.println(encryptedMsgTest);
        System.out.println(msgTest);
    }
}
