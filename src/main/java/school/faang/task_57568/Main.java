package school.faang.task_57568;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String firstMessage = "Join the Rebellion!";
        String secondMessage = "The Death Star is operational!";
        int firstEncryptionKey = 3;
        int secondEncryptionKey = 7;

        r2d2.sendMessage(c3po, firstMessage, firstEncryptionKey);

        c3po.sendMessage(r2d2, secondMessage, secondEncryptionKey);

        bb8.sendMessage(c3po, "The mission is complete.", firstEncryptionKey);
    }
}
