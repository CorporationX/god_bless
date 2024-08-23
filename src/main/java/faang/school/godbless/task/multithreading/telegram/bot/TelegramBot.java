package faang.school.godbless.task.multithreading.telegram.bot;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int TIME_LIMIT = 1000;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private int requestCounter = 0;
    private long lastRequestTime = System.currentTimeMillis();

    public synchronized String sendMessage(String message) {
        if (outOfQueryLimitPerTime()) {
            return sleepReset(message);
        } else if (getTimeRange() < TIME_LIMIT) {
            requestCounter++;
            return message;
        } else if (requestCounter > 0) {
            requestCounter = 0;
        }
        requestCounter++;
        lastRequestTime = System.currentTimeMillis();
        return message;
    }

    private boolean outOfQueryLimitPerTime() {
        return getTimeRange() < TIME_LIMIT && requestCounter == REQUEST_LIMIT;
    }

    private String sleepReset(String message) {
        sleepUntilNextRound();
        requestCounter = 1;
        lastRequestTime = System.currentTimeMillis();
        return message;
    }

    private void sleepUntilNextRound() {
        setAlarm();
        sleep();
    }

    private void setAlarm() {
        scheduler.schedule(this::notifyThread, TIME_LIMIT - getTimeRange(), TimeUnit.MILLISECONDS);
    }

    private void notifyThread() {
        synchronized (this) {
            this.notifyAll();
        }
    }

    private void sleep() {
        log.info("Sleep...\n");
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private long getTimeRange() {
        return System.currentTimeMillis() - lastRequestTime;
    }

    public void schedulerShutdown() {
        scheduler.shutdown();
    }
}
