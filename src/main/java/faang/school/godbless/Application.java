package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
    }
}