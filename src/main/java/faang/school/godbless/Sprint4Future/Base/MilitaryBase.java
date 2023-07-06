package faang.school.godbless.Sprint4Future.Base;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MilitaryBase implements Runnable {
    private boolean running;
    private BlockingQueue<String> inbox = new LinkedBlockingQueue<>();

    public MilitaryBase() {
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            if (!inbox.isEmpty()) {
                try {
                    System.out.println(EncryptionUtils.decrypt(inbox.take()));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void sendMessage(MilitaryBase base, String message) {
        String encryptMessage = EncryptionUtils.encrypt(message);
        try {
            base.getInbox().put(encryptMessage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        running = false;
    }

    public BlockingQueue<String> getInbox() {
        return inbox;
    }
}
