package school.faang.bjs2_92700;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int WAITING_TIME = 1;

    public static void main(String[] args) {
        KingdomMessenger messenger = new KingdomMessenger();
        messenger.sendRaven(new Kingdom("Болгарская империя"), new Kingdom("Киевская Русь"));
        messenger.sendRaven(new Kingdom("Византийская империя"), new Kingdom("Хазарский Каганат"));
        messenger.sendRaven(new Kingdom("Хазарский Каганат"), new Kingdom("Киевская Русь"));
        messenger.sendRaven(new Kingdom("Хазарский Каганат"), new Kingdom("Византийская империя"));
        messenger.getExecutor().shutdown();
        try {
            if (!messenger.getExecutor().awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                log.error("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток main не смог должаться окончания, он был прерван.");
        }
    }
}
