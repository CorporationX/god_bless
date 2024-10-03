package school.faang.godbless.bjs2_31411;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExampleTest {

  @Test
  @DisplayName("Testing with array of even length")
  void testReverseEvenArrLength() {
    int[] arr = {2, 3, 7, 1};

    int[] expected = {1, 7, 3, 2};
    Example.reverse(arr);

    assertArrayEquals(expected, arr);
  }

  @Test
  @DisplayName("Testing with array of odd length")
  void testReverseOddArrLength() {
    int[] arr = {2, 3, 5, 7, 1};

    int[] expected = {1, 7, 5, 3, 2};
    Example.reverse(arr);

    assertArrayEquals(expected, arr);
  }
}