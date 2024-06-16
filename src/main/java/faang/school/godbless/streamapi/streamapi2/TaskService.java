package faang.school.godbless.streamapi.streamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskService {

    //1
    public static Set<Pair<Integer>> findUniqueIntPairs(List<Integer> integers, int targetSum) {
        return integers.stream() // пробегаем по всем числам
                .flatMap(i -> integers.stream() // создаем второй поток, чтобы  сравнивать одно число с другим
                        .filter(j -> !i.equals(j)) // отбрасываем само себя + дубликаты
                        .filter(j -> i + j == targetSum) // отбираем числа дающие нужную сумму
                        .map(j -> { // собираем в Pair таким образом, чтобы не было перевернутых дубликатов
                            if (i < j) {
                                return new Pair<>(i, j);
                            } else {
                                return new Pair<>(j, i);
                            }
                        }))
                .collect(Collectors.toSet());
    }

    //2
    public static List<String> sortByKeyAndGetValuesList(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    //3
    public static List<String> filterByStartCharAndSortByLength(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.charAt(0) == c)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //4
    public static Set<Pair<String>> findUsersNotFriendsWithMutualFriends(
            Map<String, List<String>> userToFriendsMap) {

        return userToFriendsMap.entrySet()
                .stream() // создаём поток по пользователям
                .flatMap(entryI -> userToFriendsMap.entrySet().stream() // создаём второй поток, чтобы сравнить пользователя из основного потока с другими пользователями
                        .filter(entryJ -> !entryI.equals(entryJ)) // отбрасываем его самого
                        .filter(entryJ -> !entryJ.getValue().contains(entryI.getKey())) // отбрасываем тех кто есть в друзьях
                        .filter(entryJ -> entryI.getValue() // получаем список из людей которые не являются ни тем самым пользователем, ни другом этого пользователя
                                .stream().anyMatch(friendI -> entryJ.getValue().contains(friendI))) // находим людей, у которых есть пересечения между друзьями
                        .map(entryJ -> { // создаем пару таким образом, чтобы не было перевернутых дубликатов
                            if (entryI.getKey().compareTo(entryJ.getKey()) <= 0) {
                                return new Pair<>(entryI.getKey(), entryJ.getKey());
                            } else {
                                return new Pair<>(entryJ.getKey(), entryI.getKey());
                            }
                        }))
                .collect(Collectors.toSet()); // собираем в сет, дубликаты удаляются сами
    }

    //5
    public static Map<String, Double> findAvgSalaryByDept(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.averagingDouble(Employee::getSalary)));
    }

    //6
    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, char[] alphabet) {
        Set<Integer> alphabetChars = String.valueOf(alphabet).chars().boxed().collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(alphabetChars::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //7
    public static List<String> convertIntegersToBinaryFormStrings(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //8
    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .map(String::valueOf)
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .map(Integer::valueOf)
                .toList();
    }
}
