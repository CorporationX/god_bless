package faang.school.godbless.BJS2_10954;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class CharacterThread extends Thread {
  private Character character;
  private int sum;

  public CharacterThread(Character character) {
    this.character = character;
  }

  @Override
  public void run() {
    sum = character.getPower();
  }
}
