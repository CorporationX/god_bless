package school.faang.telegram;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

import static school.WaitUtils.sleep;
import static school.WaitUtils.threadWait;

@Slf4j
public class TelegramBot {

    private static final int REQUEST_LIMIT = 10;
    private static final int REQUEST_TIME_LIMIT_MILLIS = 1000;
    private static final int MESSAGE_SEND_PROCESS_MILLIS = 90;

    private int requestCounter;
    private long lastRequestTimeMillis;
    private final Deque<Message> messages;
    private boolean botActive;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTimeMillis = System.currentTimeMillis();
        this.messages = new ArrayDeque<>();
        this.botActive = false;
    }

    public void activateBot() {
        log.info("Activate bot");
        botActive = true;
        while (botActive) {
            log.info("Start sending messages");
            proceedMessages();
        }
    }

    public void deactivateBot() {
        log.info("Deactivate bot");
        synchronized (messages) {
            if (!messages.isEmpty()) {
                log.info("Wait all messages is send");
                threadWait(messages);
            }
            log.info("Turn off bot");
            botActive = false;
            log.info("Notify message sender");
            messages.notify();
        }
    }

    public void sendMessage(Message message) {
        synchronized (messages) {
            messages.add(message);
            messages.notify();
        }
    }

    private void proceedMessages() {
        emptyMessagePollHandle();

        if (!botActive) {
            log.info("Deactivating bot");
            return;
        }

        increaseMessageSendPerLimitCounter();
        overflowHandle();
        resetMessageSendPerLimitCounter();

        sendMessageProcess();
    }

    private long timeFromLastRequest() {
        return System.currentTimeMillis() - lastRequestTimeMillis;
    }

    private void emptyMessagePollHandle() {
        if (messages.isEmpty()) {
            synchronized (messages) {
                log.info("Notify deactivating thread");
                messages.notify();
                log.info("Waiting new messages");
                threadWait(messages);
            }
        }
    }

    private void sendMessageProcess() {
        Message messageToSend;
        synchronized (messages) {
            messageToSend = messages.pop();
        }
        log.info("Sending: {}", messageToSend.content());
        sleep(MESSAGE_SEND_PROCESS_MILLIS);
        log.info("Message is send: {}", messageToSend.content());
    }

    private void increaseMessageSendPerLimitCounter() {
        if (timeFromLastRequest() < REQUEST_TIME_LIMIT_MILLIS) {
            requestCounter++;
        }
    }

    private void overflowHandle() {
        if (requestCounter > REQUEST_LIMIT) {
            long restTime = REQUEST_TIME_LIMIT_MILLIS - timeFromLastRequest();
            log.info("overflow, rest for {} millis", restTime);
            sleep(restTime < 0 ? 0 : restTime);
            log.info("continue");
        }
    }

    private void resetMessageSendPerLimitCounter() {
        if (timeFromLastRequest() > REQUEST_TIME_LIMIT_MILLIS) {
            requestCounter = 0;
            lastRequestTimeMillis = System.currentTimeMillis();
        }
    }
}
