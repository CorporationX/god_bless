package school.faang.module1.bjs2_80155;

public class Main {

    private static final String MESSAGE_1 = "Join the Rebellion!";
    private static final String MESSAGE_2 = "The Death Star is operational!";

    private static final int ENCRYPTION_KEY_1 = 3;
    private static final int ENCRYPTION_KEY_2 = 7;

    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        r2d2.sendMessage(MESSAGE_1, ENCRYPTION_KEY_1, c3po);
        c3po.sendMessage(MESSAGE_2, ENCRYPTION_KEY_2, r2d2);
        bb8.sendMessage(MESSAGE_1, ENCRYPTION_KEY_1, r2d2);
    }
}