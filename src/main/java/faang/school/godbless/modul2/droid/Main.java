package faang.school.godbless.modul2.droid;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);

        System.out.println();

        int encryptionKeyTest1 = 0;
        r2d2.sendEncryptedMessage(c3po, message, encryptionKeyTest1);

        System.out.println();

        int encryptionKeyTest2 = 26;
        r2d2.sendEncryptedMessage(c3po, message, encryptionKeyTest2);
    }
}
