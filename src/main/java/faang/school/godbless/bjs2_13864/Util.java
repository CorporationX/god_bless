package faang.school.godbless.bjs2_13864;

import java.util.Random;

public final class Util {

  private static final Random RANDOM = new Random();

  private Util() {}

  public static int getRandomNumber(int divisible) {
    return RANDOM.nextInt(divisible);
  }

}
