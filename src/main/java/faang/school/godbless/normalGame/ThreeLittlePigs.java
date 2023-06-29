package faang.school.godbless.normalGame;

import java.util.List;

public class ThreeLittlePigs {
  private static final List<Thread> PIGS = List.of(
      new Pig1Thread("Daisy"),
      new Pig2Thread("Charlotte"),
      new Pig3Thread("Bella")
  );

  public static void main(String[] args) {
    for (Thread pig : PIGS) {
      pig.start();
    }

    for (Thread thread : PIGS) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        System.out.printf("Problem: " + e.toString() + " at thread called: " + thread.getName());
      }
    }
    System.out.println("Game is over!");
  }
}
