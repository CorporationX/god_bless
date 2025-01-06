package school.faang.sprint_4.task_51080;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

@Getter
@Slf4j
public class MilitaryBase implements Runnable {
    private static final int DELAY = 1000;
    private final String name;
    private final LinkedBlockingQueue<String> inbox;
    private volatile boolean running = true;

    public MilitaryBase(String name) {
        this.name = name;
        inbox = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(DELAY);
                if (!running) {
                    break;
                }
                if (inbox.isEmpty()) {
                    log.info("Сообщений в почте не обнаружено");
                } else {
                    String decryptedMessage = inbox.take();
                    String encryptedMessage = EncryptionUtils.decrypt(decryptedMessage);
                    log.info("Зашифрованное сообщение {} расшифровано в {}", decryptedMessage, encryptedMessage);
                }
            } catch (InterruptedException e) {
                log.error("Произошла ошибка во время ожидания задачи: {}", e.getMessage());
            } catch (Exception e) {
                log.error("Произошла ошибка во время расшифровки сообщения: {}", e.getMessage());
            }
        }
    }

    public void sendMessage(MilitaryBase destinationBase, String message) throws Exception {
        try {
            String encryptedMessage = EncryptionUtils.encrypt(message);
            destinationBase.inbox.put(encryptedMessage);
            log.info("Сообщение из базы {} передано на базу {}", this.name, destinationBase.getName());
        } catch (Exception e) {
            log.error("Произошла ошибка при отправлении сообщения на базу {}: {}",
                    destinationBase.getName(), e.getMessage());
        }
    }

    public void stop() {
        log.info("Работа военной базы остановлена");
        running = false;
    }

}
