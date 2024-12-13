package school.faang.sprint2.bjs_46216;

public class Main {
    public static void main(String[] args) {

        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join FAANG School!";
        String message2 = "Discover new opportunities for your development in IT!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(c3po, message1, encryptionKey1);
        c3po.sendMessage(r2d2, message2, encryptionKey2);
        bb8.sendMessage(c3po, "Become a true Back-End Developer!", encryptionKey1);
    }
}
