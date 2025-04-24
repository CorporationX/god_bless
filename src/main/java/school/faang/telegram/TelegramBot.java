package school.faang.telegram;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

import static school.WaitUtils.threadWait;

@Slf4j
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int REQUEST_TIME_LIMIT_MILLIS = 1000;

    private int requestCounter;
    private long pivotRequestTimestampMillis;
    private final Deque<Message> messages;
    private final Object limitLock;
    @Getter
    private final Object botLock;


    public TelegramBot() {
        this.requestCounter = 0;
        this.pivotRequestTimestampMillis = System.currentTimeMillis();
        this.messages = new ArrayDeque<>();
        this.limitLock = new Object();
        this.botLock = new Object();
    }

    public void sendMessage(Message message) {
        synchronized (botLock) {
            messages.add(message);
            botLock.notify();
        }
    }

    public Message provideMessage() {
        long deltaFromPivot = timeFromPivotRequest();
        tryResetPivotRequest(deltaFromPivot);
        overflowHandle(deltaFromPivot);

        synchronized (limitLock) {
            requestCounter++;
        }

        synchronized (botLock) {
            return messages.pop();
        }
    }

    public boolean messagesNotPresent() {
        synchronized (botLock) {
            return messages.isEmpty();
        }
    }

    private long timeFromPivotRequest() {
        synchronized (limitLock) {
            return System.currentTimeMillis() - pivotRequestTimestampMillis;
        }
    }

    private void overflowHandle(long deltaFromPivot) {
        synchronized (limitLock) {
            if (requestCounter > REQUEST_LIMIT) {
                long restTime = REQUEST_TIME_LIMIT_MILLIS - deltaFromPivot;
                log.info("overflow, rest for {} millis", restTime);
                threadWait(limitLock, restTime);
                log.info("continue");
                requestCounter = 0;
                pivotRequestTimestampMillis = System.currentTimeMillis();
            }
        }
    }

    private void tryResetPivotRequest(long deltaFromPivot) {
        synchronized (limitLock) {
            long deltaFromLimit = deltaFromPivot - REQUEST_TIME_LIMIT_MILLIS;
            if (deltaFromLimit > 0) {
                requestCounter = 0;
                pivotRequestTimestampMillis = System.currentTimeMillis();
            }
        }
    }
}
