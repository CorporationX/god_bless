package faang.school.godbless.bjs2_8979;

import java.util.List;

public class Main {

  private static final int ID = 1;

  public static void main(String[] args) {

    PersonalCalculator<Integer> integerPersonalCalculator = new PersonalCalculator<>();
    List<Integer> list = List.of(1, 2, 3, 4, 5, 13, 8, 20);

    Integer i = integerPersonalCalculator.calculate(list, Main::product);
    Integer j = integerPersonalCalculator.calculate(list, Main::sum);
    System.out.println(i);
    System.out.println(j);
  }

  public static Integer product(List<Integer> nums) {
    return  nums.stream()
        .reduce(ID, (num, acc) -> num * acc);
  }

  public static Integer sum(List<Integer> nums) {
    return nums.stream()
        .mapToInt(num -> num)
        .sum();
  }

}
