package streamApi;

import org.junit.jupiter.api.Test;

import java.util.List;

import faang.school.godbless.streamApi.StreamApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamApiTest {
  @Test
  public void getSumEvenNumbersTest() {
    List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);
    assertEquals(20, StreamApi.getSumEvenNumbers(nums));
  }

  @Test
  public void getMaxTest() {
    List<Integer> nums = List.of(1, 2, 33, 4, 5, 6, 7, 8);
    assertEquals(33, StreamApi.getMax(nums));
  }

  @Test
  public void getMediumNumTest() {
    List<Integer> nums = List.of(1, 2, 33, 4, 5, 6, 7, 8);
    assertEquals(8.25, StreamApi.getMediumNum(nums));
  }

  @Test
  public void getSubstrCount() {
    List<String> countries = List.of("USA", "Germany", "Poland", "Spain", "Ukraine");
    assertEquals(2, StreamApi.getSubstrCount(countries, "U"));
  }

  @Test
  public void getCountriesTest() {
    List<String> countries = List.of("USA", "Germany", "Poland", "Spain", "Ukraine");
    assertEquals(List.of("Ukraine"), StreamApi.getCountries(countries, "Ukr"));
  }

  @Test
  public void sortListByLengthTest() {
    List<String> countries = List.of("USA", "Germany", "Poland", "Spain", "Ukraine");
    List<String> expectedResult = List.of("USA", "Spain", "Poland", "Germany", "Ukraine");
    assertEquals(expectedResult, StreamApi.getSortListByLength(countries));
  }

  @Test
  public void areAllMatchesTest() {
    List<String> countries = List.of("USA", "Germany", "Poland", "Spain", "Ukraine");
    assertFalse(StreamApi.areAllMatches(countries, (c) -> c.length() > 4));
    assertTrue(StreamApi.areAllMatches(countries, (c) -> c.length() > 2));
  }

  @Test
  public void getMinAfterProvidedTest() {
    List<Integer> nums = List.of(15, 10, 20, 11, 5, 7, 8);
    assertEquals(10, StreamApi.getMinAfterProvided(nums, 9));
  }

  @Test
  public void getStrToLengthMapTest() {
    List<String> countries = List.of("USA", "Germany", "Poland", "Spain", "Ukraine");
    List<Integer> expectedResult = List.of(3, 7, 6, 5, 7);
    assertEquals(expectedResult, StreamApi.getStrToLengthMap(countries));
  }
}
