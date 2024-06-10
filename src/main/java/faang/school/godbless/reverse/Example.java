package faang.school.godbless.reverse;

/**
 * @author Evgenii Malkov
 */
public class Example {

  public static int[] reverse(int[] sourceArray) {
    int[] targetArray = new int[sourceArray.length];
    int j = 0;
    for (int i = sourceArray.length - 1; i >= 0; i--) {
      targetArray[j] = sourceArray[i];
      j++;
    }
    return targetArray;
  }
}
