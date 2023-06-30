package faang.school.godbless.kingTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
  public static void main(String[] args) {
    Knight knight1 = new Knight("Iron man");
    Knight knight2 = new Knight("Thor");

    knight1.addTrial(new Trial(knight1.getName(), "fight with cat"));
    knight1.addTrial(new Trial(knight1.getName(), "fight with dog"));
    knight2.addTrial(new Trial(knight2.getName(), "jump across the ocean"));

    ExecutorService executor = Executors.newFixedThreadPool(2);

    for (Trial trial : knight1.getTrials()) {
      executor.submit(trial);
    }

    for (Trial trial : knight2.getTrials()) {
      executor.submit(trial);
    }

    executor.shutdown();


    System.out.println("All the trials has finished");
  }
}
