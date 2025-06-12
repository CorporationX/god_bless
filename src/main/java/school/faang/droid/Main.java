package school.faang.droid;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var r2d2 = new Droid("R2D2");
        var c3po = new Droid("C3PO");
        var bb8 = new Droid("BB-8");

        var message1 = "Join the Rebellion!";
        var message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(c3po, message1, encryptionKey1);
        c3po.sendMessage(r2d2, message2, encryptionKey2);
        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
    }

}
