package school.faang.task_46246;

public class Main {
    public static void main(String[] args) {
        DroidService droidService = new DroidService();
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 5;
        int encryptionKey2 = 7;

        droidService.sendMessage(r2d2, c3po, message1, encryptionKey1);
        droidService.sendMessage(c3po, r2d2, message2, encryptionKey2);
        droidService.sendMessage(bb8, c3po, "The mission is complete.", encryptionKey1);
    }
}
