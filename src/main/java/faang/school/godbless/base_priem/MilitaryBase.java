package faang.school.godbless.base_priem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class MilitaryBase implements Runnable {
    private final int SLEEPING_TIME_IN_MILLIS_LOWER_BOUND = 1000;
    private final int SLEEPING_TIME_IN_MILLIS_UPPER_BOUND = 4000;
    private final String[] MESSAGES = new String[]{"Hello", "We are alive", "We have troubles", "Bye"};

    private final String militaryBaseName;
    private volatile boolean isRunning = true;
    private LinkedBlockingQueue<byte[]> OPPONENT_INBOX;
    private final EncryptionUtils encryptionUtils = new EncryptionUtils();

    @Override
    public void run() {
        while (isRunning) {
            String messageToSend = getRandomMessage();
            byte[] encryptedBytes = encryptionUtils.encryptMessage(messageToSend);
            getOPPONENT_INBOX().add(encryptedBytes);
            try {
                byte[] encryptedOpponentBytes = OPPONENT_INBOX.take();
                String decryptedOpponentMessage = encryptionUtils.decryptMessage(encryptedOpponentBytes);
                log.info("{} got : {}", militaryBaseName, decryptedOpponentMessage);
                int sleepingTime = ThreadLocalRandom.current().nextInt(
                        SLEEPING_TIME_IN_MILLIS_LOWER_BOUND,
                        SLEEPING_TIME_IN_MILLIS_UPPER_BOUND
                );
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted during message taking ", e);
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        setRunning(false);
    }

    private String getRandomMessage() {
        return MESSAGES[ThreadLocalRandom.current().nextInt(0, MESSAGES.length)];
    }
}
