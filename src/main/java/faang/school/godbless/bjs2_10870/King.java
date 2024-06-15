package faang.school.godbless.bjs2_10870;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

public class King {

  private static final int POOL_SIZE = 2;
  private static final int TIME_OUT = 30;
  private static final String TRIALS_OVER = "Испытания закончены!";

  public static void main(String[] args) throws InterruptedException {
    Knight firstKnight = new Knight("Джорах Мормонт");
    Knight secondKnight = new Knight("Бронн");

    Trial firstTrial = new Trial(firstKnight.getName(), "Пробежать 1000 м в доспехах");
    Trial secondTrial = new Trial(firstKnight.getName(), "Отразить все атаки соперника");
    Trial thirdTrial = new Trial(secondKnight.getName(), "Отбить стрелы щитом");
    Trial fourthTrial = new Trial(secondKnight.getName(), "Удержаться на коне");

    firstKnight.addTrial(firstTrial);
    firstKnight.addTrial(secondTrial);
    secondKnight.addTrial(thirdTrial);
    secondKnight.addTrial(fourthTrial);

    startTrials(List.of(firstKnight, secondKnight));

    System.out.println(TRIALS_OVER);
  }

  @SneakyThrows
  private static void startTrials(List<Knight> knights) {
    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    knights.stream()
        .flatMap(knight -> knight.getTrials().stream())
        .forEach(executorService::submit);

    executorService.shutdown();
    executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
  }

}
