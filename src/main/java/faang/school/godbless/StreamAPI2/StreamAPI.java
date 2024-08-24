package faang.school.godbless.StreamAPI2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI {
    /*
    * На вход дан список целых чисел и число.
    * Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    * */
    public static int[][] findUniquePairs(int[] nums, int target) {
        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] == target)
                        .mapToObj(j -> new int[]{nums[i], nums[j]}))
                .toList()
                .toArray(int[][]::new);
    }

    /*
     * На вход получаем мапу с названиями стран и их столицами.
     * Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
     * */
    public static List<String>sortCapitalsByAlphabet(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    /*
    * Получаем список строк и букву в виде char.
    * Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине
    * в порядке возрастания, и верните список этих строк.
    * */
    public static List<String>filter(List<String> list, char  character) {
        return list.stream()
                .filter(s -> s.charAt(0) == character)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    /*
    * Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    * Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    * */
    public static List<List<String>> findPeopleThatNoFriendsButHaveMutualFriends(Map<String, List<String>> people) {
        List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(people.entrySet());

        return IntStream.range(0, entryList.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, entryList.size())
                        .filter(j -> {
                            String personI = entryList.get(i).getKey();
                            String personJ = entryList.get(j).getKey();
                            List<String> friendsI = entryList.get(i).getValue();
                            List<String> friendsJ = entryList.get(j).getValue();

                            boolean noDirectFriendship = !friendsI.contains(personJ) && !friendsJ.contains(personI);

                            Set<String> mutualFriends = new HashSet<>(friendsI);
                            mutualFriends.retainAll(friendsJ);

                            return noDirectFriendship && !mutualFriends.isEmpty();
                        })
                        .mapToObj(j -> Arrays.asList(entryList.get(i).getKey(), entryList.get(j).getKey())))
                .collect(Collectors.toList());
    }

    /*
     * Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
     * Найдите среднюю зарплату для каждого отдела.
     * Должна получится map с именем отдела и средней зарплатой.
     * */
    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    /*
     * Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
     * и отсортируйте их в порядке возрастания длины строк.
     * */
    public static List<String> filterAndSortStrings(List<String> strings, String alphabet) {
        Set<Character> allowedChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> allowedChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    /*
     * Написать метод, который преобразует список целых чисел в список строк,
     * где каждое число записано в двоичном виде.
     * */
    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    /*
     * Написать метод, который найдет все числа-палиндромы (читающиеся одинаково
     * слева направо и справа налево) в заданном диапазоне. На вход получаем число
     * для начала диапазона и число для второй границы диапазона.
     * */
    public static List<Integer> findAllPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(i -> new StringBuilder(i.toString()).reverse().toString().equals(i.toString()))
                .toList();
    }
}
