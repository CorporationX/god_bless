package school.faang.multithreading.army;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mage implements Powerable {

  private int power;

  @Override
  public int getPower() {
    return power;
  }
}
