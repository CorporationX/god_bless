package school.faang.telegram;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

import static school.WaitUtils.sleep;

@Slf4j
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int REQUEST_TIME_LIMIT_MILLIS = 1000;
    private static final int MESSAGE_SEND_PROCESS_MILLIS = 50;

    private AtomicInteger requestCounter;
    private long lastRequestTimeMillis;

    public TelegramBot() {
        this.requestCounter = new AtomicInteger(0);
        this.lastRequestTimeMillis = System.currentTimeMillis();
    }

    public synchronized void sendMessage(Message message) {
        increaseRequestCounter();
        overflowHandle();
        resetMessageSendPerLimitCounter();
        sendMessageProcess(message);
    }

    private void increaseRequestCounter() {
        if (timeFromLastRequest() < REQUEST_TIME_LIMIT_MILLIS) {
            requestCounter.incrementAndGet();
        }
    }

    private long timeFromLastRequest() {
        return System.currentTimeMillis() - lastRequestTimeMillis;
    }

    private void sendMessageProcess(Message message) {
        log.info("Sending: {}", message.content());
        sleep(MESSAGE_SEND_PROCESS_MILLIS);
        log.info("Message is send: {}", message.content());
    }

    private void overflowHandle() {
        if (requestCounter.get() > REQUEST_LIMIT) {
            long restTime = REQUEST_TIME_LIMIT_MILLIS - timeFromLastRequest();
            log.info("overflow, rest for {} millis", restTime);
            sleep(restTime < 0 ? 0 : restTime);
            log.info("continue");
        }
    }

    private void resetMessageSendPerLimitCounter() {
        if (timeFromLastRequest() > REQUEST_TIME_LIMIT_MILLIS) {
            requestCounter = new AtomicInteger(0);
            lastRequestTimeMillis = System.currentTimeMillis();
        }
    }
}
