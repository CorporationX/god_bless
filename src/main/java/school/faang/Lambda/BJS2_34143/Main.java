package school.faang.Lambda.BJS2_34143;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        String encryptedMessage1 = r2d2.sendMessage(message1, encryptionKey1);
        String decryptedMessage1 = c3po.receiveMessage(encryptedMessage1, encryptionKey1);
        System.out.println("R2D2 -> C3PO: " + decryptedMessage1);

        String encryptedMessage2 = c3po.sendMessage(message2, encryptionKey2);
        String decryptedMessage2 = r2d2.receiveMessage(encryptedMessage2, encryptionKey2);
        System.out.println("C3PO -> R2D2: " + decryptedMessage2);

        String encryptedMessage3 = bb8.sendMessage("The mission is complete.", encryptionKey1);
        String decryptedMessage3 = c3po.receiveMessage(encryptedMessage3, encryptionKey1);
        System.out.println("BB-8 -> C3PO: " + decryptedMessage3);
    }
}
