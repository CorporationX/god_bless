package school.faang.task46202;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");

        String message = "Join the Rebellion!";
        int encryptionKey = 26;

        r2d2.sendMessage(message, encryptionKey, c3po);
    }
}
