package faang.school.godbless.bjs2_8979;

import java.util.List;

public class PersonalCalculator<T extends Number> {

  public T calculate(List<T> nums, Calculator<T> calculator) {
    return calculator.calc(nums);
  }

}
