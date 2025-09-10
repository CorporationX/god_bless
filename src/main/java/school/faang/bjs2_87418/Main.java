package school.faang.bjs2_87418;

public class Main {
    public static void main(String[] args) {
        String firstMessage = "Join the Rebellion!";
        String secondMessage = "The Death Star is operational!";
        int firstEncryptionKey = 3;
        int secondEncryptionKey = 7;

        Droid r2d2 = new Droid("R2D2");
        Droid c3p3 = new Droid("C3P3");
        Droid bb8 = new Droid("BB-8");

        r2d2.sendMessage(c3p3, firstMessage, firstEncryptionKey);
        c3p3.sendMessage(r2d2, secondMessage, secondEncryptionKey);
        bb8.sendMessage(c3p3, "The mission is complete", secondEncryptionKey);
    }
}
