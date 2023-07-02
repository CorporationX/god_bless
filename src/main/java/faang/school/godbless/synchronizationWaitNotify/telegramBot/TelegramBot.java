package faang.school.godbless.synchronizationWaitNotify.telegramBot;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        lastRequestTime = LocalDateTime.MIN;
    }

    public TelegramBot(int requestCounter, LocalDateTime lastRequestTime) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) {
        long period = 0;

        if (requestCounter != 0) {
            period = ChronoUnit.MILLIS.between(lastRequestTime, LocalDateTime.now());
        }

        if (period < 1000) {
            updateDataForCurrentSecond();
        } else {
            updateDataForNewSecond();
        }

        System.out.println("Counter: " + requestCounter);
        System.out.printf("Поток: %s. Сообщение: %s отправлено в %d:%d\n", Thread.currentThread().getName(),
                message, lastRequestTime.getSecond(), lastRequestTime.getNano());
        this.notify();
    }

    private void updateDataForCurrentSecond() {
        this.requestCounter++;

        if (this.requestCounter > REQUEST_LIMIT) {
            try {
                //По условию в секунду 5 запросов. Разве не нужно запоминать, когда эта секунда началась?
                long waiting = 1000 - ChronoUnit.MILLIS.between(lastRequestTime, LocalDateTime.now());
                System.out.printf("Превышение лимита! Поток: %s; lastRequestTime: %d:%d; Ждать: %d\n",
                        Thread.currentThread().getName(),
                        lastRequestTime.getSecond(), lastRequestTime.getNano(), waiting);

                this.wait( waiting);

                //допустим все потоки зашли сюда и ждут окончания секунды. Как только она закончится, все должны
                //поочередно проснуться и продолжить выполнение с этого момента, а не с начала. Не могу догадаться, как для них тогда
                //сохранять requestCounter. Ведь когда эта секунда пройдет, счетчик должен начаться заново.
                //Если делать = 0, то он для всех потоков поочередно будет перезаписывать на 0.
                //А должен продолжить считать также с 0. Так как мы не контролируем какой из потоков будет выполняться
                //в данный момент, то вообще непонятно, как после пробуждения его можно расчитать :(
                //this.requestCounter = ???;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.lastRequestTime = LocalDateTime.now();
    }

    private void updateDataForNewSecond() {
        this.requestCounter = 1;
        this.lastRequestTime = LocalDateTime.now();
    }
}
