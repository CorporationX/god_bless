package faang.school.godbless.DroidSecret;

public class Test {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        System.out.println("Original message: " + message);

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
    }
}
