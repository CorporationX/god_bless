package school.faang.multithreading.army;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Archer implements Powerable {

  private int power;

  @Override
  public int getPower() {
    return power;
  }
}
