package the_tournament_at_kings_landing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Trial {
    private String knightName;
    private String trialName;
    private static final int MIN_SECONDS = 5;
    private static final int MAX_SECONDS = 10;
    private final Random random = new Random();

    /**
     * Запускает испытание. Метод не возвращает никаких значений,
     * но выводит сообщения о начале и конце испытания.
     * @throws InterruptedException
     *         если было прервано выполнение потока
     */
    public void run() throws InterruptedException {
        System.out.printf("Рычарь: %s. Испытание %s началось\n", knightName, trialName);

        Thread.sleep(random.nextInt((MAX_SECONDS - MIN_SECONDS + 1) + MIN_SECONDS) * 1000);

        System.out.printf("Рычарь: %s. Испытание %s закончилось\n", knightName, trialName);
    }
}
