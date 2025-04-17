package school.faang.stream2.drioidssecrets;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(c3po, message1, encryptionKey1);

        c3po.sendMessage(r2d2, message2, encryptionKey2);

        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
    }
}
