package school.faang.fieldbasecomein;

import java.util.concurrent.LinkedBlockingQueue;

public class MilitaryBase implements Runnable {
    private final LinkedBlockingQueue<String> inbox = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public void sendMessage(MilitaryBase destinationBase, String message) {
        try {
            String encryptedMessage = EncryptionUtils.encrypt(message);
            destinationBase.inbox.put(encryptedMessage);
            System.out.println("Message sent to base: " + encryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String encryptedMessage = inbox.take();
                String decryptedMessage = EncryptionUtils.decrypt(encryptedMessage);
                System.out.println("Received message: " + decryptedMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("MilitaryBase stopped.");
    }
}

