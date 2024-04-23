package faang.school.godbless.BJS2_5763;

import java.util.ArrayList;
import java.util.List;

public class Army {
  private List<Character> characters = new ArrayList<>();

  public void addUnit(Character character) {
    characters.add(character);
  }

  public int calculateTotalPower() {
    List<CharacterThread> threads = new ArrayList<>();
    for (Character character : characters) {
      CharacterThread thread = new CharacterThread(character);
      threads.add(thread);
      thread.start();
    }

    int power = 0;
    for (CharacterThread thread : threads) {
      try {
        thread.join();
        power += thread.getPower();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    return power;
  }
}
