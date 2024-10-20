package bjs2_35747;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 10;
    private int requestCounter;
    long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        long currTime = System.currentTimeMillis();
        long timeDelta = currTime - lastRequestTime;
        long timeLimit = 1000;

        if (isTimeDeltaUnderLimit(timeDelta, timeLimit)) {
            requestCounter++;

            if (isRequestLimitExceeded()) {
                processRequestLimitExceeded(timeDelta, timeLimit);
            }
        } else {
            resetRequestCounter();
        }

        System.out.println(message);
    }

    private boolean isTimeDeltaUnderLimit(long timeDelta, long timeLimit) {
        return timeDelta < timeLimit;
    }

    private boolean isRequestLimitExceeded() {
        return requestCounter > REQUEST_LIMIT;
    }

    private void processRequestLimitExceeded(long timeDelta, long timeLimit) throws InterruptedException {
        wait(timeLimit - timeDelta);
        requestCounter = 0;
    }

    private void resetRequestCounter() {
        requestCounter = 1;
        lastRequestTime = System.currentTimeMillis();
        notifyAll();
    }
}
