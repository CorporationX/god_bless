package school.faang.lambda.droids;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(message1, encryptionKey1, c3po);
        c3po.sendMessage(message2, encryptionKey2, r2d2);
        bb8.sendMessage("The mission is complete.", encryptionKey1, c3po);

        String message3 = "Luke, I am your father!";
        int encryptionKey3 = 10;
        r2d2.sendMessage(message3, encryptionKey3, bb8);
    }
}
