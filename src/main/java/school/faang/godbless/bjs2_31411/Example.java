package school.faang.godbless.bjs2_31411;

import java.util.stream.IntStream;

public class Example {

  public static void reverse(int[] arr) {
    IntStream.range(0, arr.length / 2).forEach(i -> {
      int tmp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = tmp;
    });
  }
}
