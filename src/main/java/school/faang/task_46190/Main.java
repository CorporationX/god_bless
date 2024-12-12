package school.faang.task_46190;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");
        int encryptionKey1 = 1;
        int encryptionKey2 = 7;

        r2d2.sendMessage(c3po, "Join the Rebellion!", encryptionKey1);
        c3po.sendMessage(r2d2, "The Death Star is operational!", encryptionKey2);
        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
    }
}
