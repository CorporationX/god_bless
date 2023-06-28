package Droid_Secrets;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendOrReceiveMessage(message, encryptionKey, r2d2.getSendEncrypted());
        String msg = c3po.sendOrReceiveMessage(encryptedMsg, encryptionKey, c3po.getReceiveEncrypted());

        System.out.println(encryptedMsg);
        System.out.println(msg);
    }
}
