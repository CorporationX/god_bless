package faang.school.godbless.streamApi;

import java.util.List;
import java.util.function.Predicate;

public class StreamApi {
  // Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
  public static int getSumEvenNumbers(List<Integer> nums) {
    return nums.stream()
        .filter(num -> num % 2 == 0)
        .reduce(Integer::sum)
        .get();
  }

  // Найти максимальный элемент в списке чисел;
  public static int getMax(List<Integer> nums) {
    return nums.stream()
        .mapToInt(Integer::intValue)
        .max()
        .getAsInt();
  }

  // Найти среднее значение чисел в списке;
  public static double getMediumNum(List<Integer> nums) {
    return nums.stream()
        .mapToInt(Integer::intValue)
        .average()
        .getAsDouble();
  }

  // Найти количество строк, начинающихся с определённого символа в списке строк;
  public static long getSubstrCount(List<String> strings, String substr) {
    return strings.stream()
        .filter(string -> string.startsWith(substr))
        .count();
  }

  // Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
  public static List<String> getCountries(List<String> countries, String query) {
    return countries.stream().filter(country -> country.contains(query)).toList();
  }

  //  Отсортировать список строк по длине
  public static List<String> getSortListByLength(List<String> list) {
    return list.stream().sorted((a, b) -> a.length() - b.length()).toList();
  }

  // Проверить, все ли элементы списка удовлетворяют определённому условию;
  public static boolean areAllMatches(List<String> list, Predicate<String> predicate) {
    return list.stream().allMatch(predicate);
  }

  // Найти наименьший элемент в списке, который больше заданного числа;
  public static int getMinAfterProvided(List<Integer> nums, int provided) {
    return nums.stream().filter(n -> n > provided).mapToInt(Integer::intValue).min().getAsInt();
  }

  // Преобразовать список строк в список их длин.
  public static List<Integer> getStrToLengthMap(List<String> strings) {
    return strings.stream().map(String::length).toList();
  }
}
