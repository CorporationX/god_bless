package bjs2_33397;

public class Main {

    public static void main(String[] args) {
        Droid droid1 = new Droid();
        Droid droid2 = new Droid();

        String encryptedMessage = droid1.encryptMessage("Some message", 1);
        System.out.println(encryptedMessage);
        String decryptedMessage = droid2.decryptMessage(encryptedMessage, 1);
        System.out.println(decryptedMessage);

        String enccryptedMessage2 = droid2.encryptMessage("Another message", 4);
        System.out.println(enccryptedMessage2);
        String decryptedMessage2 = droid1.decryptMessage(enccryptedMessage2, 4);
        System.out.println(decryptedMessage2);
    }

}
