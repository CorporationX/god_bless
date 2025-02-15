package school.faang.task57538;

import school.faang.task57538.service.Droid;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        String encForC3PO = r2d2.sendMessage(c3po, message1, encryptionKey1);
        System.out.println(encForC3PO);
        System.out.println(c3po.decryptMessage(encForC3PO, encryptionKey1));

        String encForR2D2 = c3po.sendMessage(r2d2, message2, encryptionKey2);
        System.out.println(encForR2D2);
        System.out.println(r2d2.decryptMessage(encForR2D2, encryptionKey2));
        System.out.println();
    }
}
