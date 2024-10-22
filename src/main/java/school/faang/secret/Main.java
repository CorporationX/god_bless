package school.faang.secret;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid("Abzalkhan");
        Droid droid2 = new Droid("Olzhas");

        String message1 = "ALOOO";
        String message2 = "POKAAA";

        int encryptionKey1 = 8;
        int encryptionKey2 = 7;

        String encryptedMessage1 = droid1.sendMessage(message1, encryptionKey1);
        String decryptedMessage1 = droid2.receiveMessage(encryptedMessage1, encryptionKey1);
        System.out.println(droid1.getName() + " -> " + droid2.getName() + " send message :" + decryptedMessage1);
        System.out.println("-------------");

        String encryptedMessage2 = droid2.sendMessage(message2, encryptionKey2);
        String decryptedMessage2 = droid1.receiveMessage(encryptedMessage2, encryptionKey2);
        System.out.println(droid2.getName() + " -> " + droid1.getName() + " send message :" + decryptedMessage2);
    }
}
