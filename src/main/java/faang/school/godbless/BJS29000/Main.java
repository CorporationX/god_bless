package faang.school.godbless.BJS29000;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int cipher = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, cipher);
        System.out.println(encryptedMsg);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, cipher);
        System.out.println(msg);

    }
}
