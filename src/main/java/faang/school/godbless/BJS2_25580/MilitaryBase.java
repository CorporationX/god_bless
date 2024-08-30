package faang.school.godbless.BJS2_25580;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MilitaryBase implements Runnable {
    private static BlockingQueue<String> inbox = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    @Override
    @SneakyThrows
    public void run() {
        while (running) {
            Thread.sleep(1000L);
            String encryptMessage = inbox.poll();

            if (encryptMessage != null) {
                String decryptMessage = EncryptionUtils.decrypt(encryptMessage);
                if (running) {
                    System.out.printf("Base received a message: %s%n", decryptMessage);
                }
            }
        }
    }

    public static void sendMessage(String message) {
        String encryptMessage = EncryptionUtils.encrypt(message);
        inbox.offer(encryptMessage);
    }

    public void stop() {
        System.out.println("Stopping Military Base");
        running = false;
    }
}
