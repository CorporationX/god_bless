package faang.school.godbless.BJS2_10886;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
  private final static int THREADS = 2;

  public static void main(String[] args) {
    Knight firstKnight = new Knight("name1");
    Knight secondKnight = new Knight("name2");
    firstKnight.addTrial(new Trial(firstKnight.getName(), "trial1"));
    firstKnight.addTrial(new Trial(firstKnight.getName(), "trial2"));
    secondKnight.addTrial(new Trial(secondKnight.getName(), "trial3"));
    secondKnight.addTrial(new Trial(secondKnight.getName(), "trial4"));

    ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    executor.submit(firstKnight::startTrials);
    executor.submit(secondKnight::startTrials);
    executor.shutdown();
  }
}
