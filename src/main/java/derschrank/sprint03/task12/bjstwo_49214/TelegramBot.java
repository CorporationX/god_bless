package derschrank.sprint03.task12.bjstwo_49214;

public class TelegramBot implements TelegramBotInterface {
    private static final int REQUEST_LIMIT = 5;
    private static final int DELAY_AWAIT_PERMISSION_MILLIS = 500;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        lastRequestTime = getCurrentTimeSeconds();
        requestCounter = 0;
    }


    @Override
    public synchronized void sendMessage(String message) {
        try {
            while (!isAllowedSendAmessage()) {
                this.wait(DELAY_AWAIT_PERMISSION_MILLIS);
            }

            incrementCounter();
            sendMessageToTelegramApi(message);

        } catch (InterruptedException e) {
            System.out.printf("sendMessage: %s, was interrupted: %s%n", message, e);
        }
    }

    private boolean isAllowedSendAmessage() {
        return (isThatAnewSecond() || requestCounter < REQUEST_LIMIT);
    }

    private boolean isThatAnewSecond() {
        return getCurrentTimeSeconds() > lastRequestTime;
    }

    private void incrementCounter() {
        if (isThatAnewSecond()) {
            lastRequestTime = getCurrentTimeSeconds();
            requestCounter = 0;
        }
        requestCounter++;
        this.notify();
    }

    private long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    private void sendMessageToTelegramApi(String msg) {
        System.out.printf("[%d %d/%d] %s%n",
                getCurrentTimeSeconds(),
                requestCounter,
                REQUEST_LIMIT,
                msg);
    }
}
