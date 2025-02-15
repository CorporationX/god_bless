package school.faang.secretsdroids;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        try {
            // R2D2 отправляет сообщение C3PO
            r2d2.sendMessage(c3po, message1, encryptionKey1);

            // C3PO отвечает R2D2
            c3po.sendMessage(r2d2, message2, encryptionKey2);

            // BB-8 отправляет сообщение C3PO
            bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}