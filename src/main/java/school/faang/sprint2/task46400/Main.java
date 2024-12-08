package school.faang.sprint2.task46400;

import school.faang.sprint2.task46400.model.Droid;

public class Main {

    public static void main(String[] args) {

        int encryptionKey1 = 3;
        int encryptionKey2 = 4;
        int encryptionKey3 = 1;

        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        r2d2.sendMessage(c3po, message1, encryptionKey1);
        System.out.println("------");

        String message2 = "The Death Star is operational!";
        c3po.sendMessage(r2d2, message2, encryptionKey2);
        System.out.println("------");

        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey3);
        System.out.println("------");

        String message3 = "May the force be with you!";
        r2d2.sendMessage(r2d2, message3, encryptionKey3);
        System.out.println("------");

    }


}
