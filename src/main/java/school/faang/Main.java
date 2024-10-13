package school.faang;

import school.faang.droid.services.Droid;

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

        System.out.println("===================================");

        Droid bob = new Droid("Bob");
        Droid marcus = new Droid("Marcus");
        Droid whom = new Droid("Who-M");

        String message3 = "Humanity will fall at our feet!";
        String message4 = "Hush, they might hear us";
        int encryptionKey3 = 15;
        int encryptionKey4 = 30;

        bob.sendMessage(marcus, message3, encryptionKey3);

        marcus.sendMessage(bob, message4, encryptionKey4);

        whom.sendMessage(marcus, "The mission is complete.", encryptionKey3);
    }
}
