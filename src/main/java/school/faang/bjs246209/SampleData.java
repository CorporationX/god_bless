package school.faang.bjs246209;

public class SampleData {
    public static void test() {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        EncryptionService service = new EncryptionService();

        service.sendMessage(r2d2, c3po, message1, encryptionKey1);

        service.sendMessage(c3po, r2d2, message2, encryptionKey2);

        service.sendMessage(bb8, c3po, "The mission is complete.", encryptionKey1);
    }
}
