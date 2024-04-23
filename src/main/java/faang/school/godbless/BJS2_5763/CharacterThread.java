package faang.school.godbless.BJS2_5763;

import lombok.Getter;

@Getter
public class CharacterThread extends Thread {
  private Character character;
  private int power;

  public CharacterThread(Character character) {
    this.character = character;
  }

  @Override
  public void run() {
    power = character.getPower();
  }
}
