package faang.school.godbless.sprint4.base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MilitaryBase implements Runnable {
    private final EncryptionUtils encryptionUtils = new EncryptionUtils();
    private final BlockingQueue<String> inbox = new ArrayBlockingQueue<>(10);
    private boolean running = true;

    public void sendMessage(MilitaryBase base, String message) throws Exception {
        String encryptedMessage = encryptionUtils.encrypt(message);
        base.inbox.put(encryptedMessage);
    }

    @Override
    public void run() {
        while (running) {
            try {
                String message = inbox.poll(1, TimeUnit.SECONDS);
                if (message != null) {
                    System.out.println("encryptedMessage = " + message);
                    String decryptedMessage = encryptionUtils.decrypt(message);
                    System.out.println("decryptedMessage = " + decryptedMessage);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        running = false;
    }
}
