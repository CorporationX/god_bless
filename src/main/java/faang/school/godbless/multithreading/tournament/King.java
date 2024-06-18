package faang.school.godbless.multithreading.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight kingthOne = new Knight("Валера1");
        Trial trialToKingthOne1 = new Trial("Валера1", "Добыть сердце дракона");
        Trial trialToKingthOne2 =  new Trial("Валера1", "Запрыгнуть на балкон принцессы");
        kingthOne.addTrial(trialToKingthOne1);
        kingthOne.addTrial(trialToKingthOne2);

        Trial trialToKingthTwo1 = new Trial("Валера2", "Поймать золотую рыбку");
        Trial trialToKingthTwo2 = new Trial("Валера2", "Запрыгнуть на балкон принцессы");
        Knight kingthTwo = new Knight("Валера2");
        kingthTwo.addTrial(trialToKingthTwo1);
        kingthTwo.addTrial(trialToKingthTwo2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(trialToKingthOne1);
        executorService.submit(trialToKingthTwo1);
        executorService.submit(trialToKingthOne2);
        executorService.submit(trialToKingthTwo2);

        executorService.shutdown();
    }
}
