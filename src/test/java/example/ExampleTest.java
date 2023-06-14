package example;

import faang.school.godbless.example.Example;
import faang.school.godbless.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
  Example example;
  @BeforeEach
  public void setUp() {
    example = new Example();
  }

  @Test
  public void testReverse() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    List<Integer> expectedNumbers = List.of(5, 4, 3, 2, 1);
    assertEquals(expectedNumbers, example.reverse(numbers));
  }
}
