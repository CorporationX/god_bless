package school.faang.droidsecret.main;

import school.faang.droidsecret.maincode.Droid;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        Droid bb8 = new Droid();

        String message1 = "Join the rebellion!";
        String message2 = "The Death Star is operational!";

        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(message1, encryptionKey1, c3po);
        c3po.sendMessage(message2, encryptionKey2, r2d2);
        bb8.sendMessage("The mission complete", encryptionKey1, c3po);


    }
}
