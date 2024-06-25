package faang.school.godbless.bjs2_14083;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final long TIME_OUT = 30;
  private static final String TIME_OUT_EXCEPTION = "Превышено время ожидания: ";
  private static final String BATTLE_WINNER = "Победитель битвы: ";
  private static final String GET_WINNER_EXCEPTION = "При получении результата победителя возникла ошибка: ";

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Battle battle = new Battle(executorService);

    Robot r2d2 = new Robot("R2-D2", 5, 7, 300);
    Robot c3po = new Robot("C-3PO", 4, 8, 500);

    Robot droideka = new Robot("Дройдека", 10, 100, 700);
    Robot superBattleDroid = new Robot("Боевой супердроид В2", 15, 25, 900);

    Future<Robot> firstWinnerFuture = battle.fight(r2d2, c3po);
    Future<Robot> secondWinnerFuture = battle.fight(droideka, superBattleDroid);
    Future<Robot> finalWinnerFuture = battle.fight(getFutureValue(firstWinnerFuture), getFutureValue(secondWinnerFuture));

    shutdown(executorService);

    Robot winner = getFutureValue(finalWinnerFuture);
    System.out.println(BATTLE_WINNER + winner.getName());

  }

  private static <T> T getFutureValue(Future<T> future) {
    try {
      return future.get();
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(GET_WINNER_EXCEPTION + e);
    }
  }

  private static void shutdown(ExecutorService executorService) {
    executorService.shutdown();
    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(TIME_OUT_EXCEPTION + e);
    }
  }

}
