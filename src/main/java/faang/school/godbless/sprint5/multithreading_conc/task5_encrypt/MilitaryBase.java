package faang.school.godbless.sprint5.multithreading_conc.task5_encrypt;

import lombok.Getter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
public class MilitaryBase implements Runnable {

    private final BlockingQueue<String> inbox;

    private boolean running;

    public MilitaryBase() {
        this.running = true;
        inbox = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (!inbox.isEmpty()) {
                    String encryptMessage = inbox.take();
                    String message = EncryptionUtils.decrypt(encryptMessage);
                    System.out.println(message);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("exit run");
    }

    public void sendMessage(String message, MilitaryBase militaryBase) throws InterruptedException {
        String encrypt = EncryptionUtils.encrypt(message);
        militaryBase.getInbox().put(encrypt);
    }

    public void stop() {
        System.out.println("stop");
        running = false;
    }
}
