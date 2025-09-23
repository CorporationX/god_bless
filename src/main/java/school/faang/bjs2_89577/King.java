package school.faang.bjs2_89577;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int KING_PATIENCE_IN_MINUTES = 1;

    public static void main(String[] args) {
        Knight harvin = new Knight("Харвин Стронг");
        Knight laynor = new Knight("Лейнор Веларион");

        harvin.addTrial(new Trial("Обезглавить белого медведя", harvin.getName()));
        harvin.addTrial(new Trial("Добыть вкуснейший плод из необитаемых земель", harvin.getName()));
        laynor.addTrial(new Trial("Улучшить имеющеся наступательные тактики", laynor.getName()));
        laynor.addTrial(new Trial("Переиграть короля в шахматы", laynor.getName()));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        harvin.startTrials(executor);
        laynor.startTrials(executor);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(KING_PATIENCE_IN_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Король устал ждать. Не все рыцари вернулись обратно...");
                executor.shutdownNow();
            } else {
                System.out.println("Отлично, рыцари справились со своими испытаниями! Король доволен.");
            }
        } catch (InterruptedException e) {
            System.out.println("На короля было совершено покушение! - Рыцарям придется оторваться от испытаний.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
