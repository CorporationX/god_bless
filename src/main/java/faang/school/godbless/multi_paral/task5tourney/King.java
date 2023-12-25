package faang.school.godbless.multi_paral.task5tourney;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("Сэр Ланселот");
        Knight knight2 = new Knight("Сэр Гавейн");

        knight1.addTrial(new Trial(knight1, "Испытание дракона"));
        knight1.addTrial(new Trial(knight1, "Испытание моста"));
        knight2.addTrial(new Trial(knight2, "Испытание лабиринта"));
        knight2.addTrial(new Trial(knight2, "Испытание меча"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        knight1.startTrials(executor);
        knight2.startTrials(executor);

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);

        System.out.println("---------------------------------------------");
        System.out.println("ТУРНИР ОКОНЧЕН ...");

        int countWinKnight1 = knight1.getCountWin();
        int countWinKnight2 = knight2.getCountWin();

        if (countWinKnight1 > countWinKnight2) {
            System.out.println(knight1.getName().toUpperCase() + " ПОБЕДИЛ!!!");
        } else if (countWinKnight2 > countWinKnight1) {
            System.out.println(knight2.getName().toUpperCase() + " ПОБЕДИЛ!!!");
        } else {
            System.out.println("НИЧЬЯ (");
        }
    }
}
