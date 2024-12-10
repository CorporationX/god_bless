package school.faang.sprint_2.task_46288;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star plans are in the hands of Count Dooku";
        String message3 = "The R2D2 memory boards burned out";
        int encryptionKey1 = 5;
        int encryptionKey2 = 9;
        int encryptionKey3 = 2;

        try {
            r2d2.sendMessage(c3po, message1, encryptionKey1);

            c3po.sendMessage(bb8, message2, encryptionKey2);

            bb8.sendMessage(c3po, message3, encryptionKey3);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}