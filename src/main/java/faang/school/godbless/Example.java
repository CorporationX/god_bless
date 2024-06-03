package faang.school.godbless;

public class Example {

  /**
   * Метод для реверса переданного массива.
   *
   * @param array принимает массив целых чисел.
   */
  public static void reverse(int[] array) {
    for (int  i = 0; i < array.length / 2; i++) {
      final int tmpArray = array[i];
      array[i] = array[array.length - i - 1];
      array[array.length - 1 - i] = tmpArray;
    }
  }

}
