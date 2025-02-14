package BJS257432;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid enemyDroid = new Droid("!!!ENEMY!!!");

        String firstMessage = "Hello World!";
        String secondMessage = "Goodbye World!";

        int firstEncryptionKey = 5;
        int secondEncryptionKey = 2;

        r2d2.sendMessage(firstMessage, firstEncryptionKey, c3po);
        c3po.sendMessage(firstMessage, firstEncryptionKey, r2d2);
        enemyDroid.sendMessage(secondMessage, secondEncryptionKey, c3po);
        enemyDroid.sendMessage(secondMessage, secondEncryptionKey, r2d2);
    }
}
