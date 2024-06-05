package faang.school.godbless.reverse;

import java.util.Arrays;

/**
 * @author Evgenii Malkov
 */
public class Main {

  public static void main(String[] args) {
    int[] sourceArray = new int[]{1, 2, 3, 4, 5};
    int[] reverseArray = Example.reverse(sourceArray);
    System.out.println(Arrays.toString(reverseArray));
  }
}
