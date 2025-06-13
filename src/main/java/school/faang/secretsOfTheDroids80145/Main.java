package school.faang.secretsOfTheDroids80145;

public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
        r2d2.sendMessage(c3po, message1, encryptionKey1);
        r2d2.sendMessage(c3po, "Checking the connection, can you hear me?", encryptionKey1);
        c3po.sendMessage(r2d2, message2, encryptionKey2);

        c3po.receiveMessage();
        r2d2.receiveMessage();
        bb8.receiveMessage();

        Droid b92 = new Droid("Bookinisto");
        System.out.println(b92.decryptMessage("P sprl zabkfpun ha Mhhun Zjovvs !!!", encryptionKey2));
    }
}
