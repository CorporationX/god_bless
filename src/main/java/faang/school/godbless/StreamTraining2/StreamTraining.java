package faang.school.godbless.StreamTraining2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTraining {
    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    public static Map<Integer, Integer> uniquePairs(List<Integer> list, Integer num) {
        Map<Integer, Integer> pairs = new HashMap<>();
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (!pairs.containsKey(list.get(i))) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) + list.get(j) == num && !indexes.contains(list.indexOf(list.get(i))) && !indexes.contains(list.indexOf(list.get(j)))) {
                        pairs.put(list.get(i), list.get(j));
                        indexes.add(list.indexOf(list.get(i)));
                        indexes.add(list.indexOf(list.get(j)));
                    }
                }
            }
        }
        return pairs;
    }

    //На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> capitals(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    //Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> sortedStrings(List<String> list, char ch) {
        return list.stream()
                .filter(str -> str.toLowerCase().startsWith(String.valueOf(ch).toLowerCase()))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей. Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static Map<String, String> friendsOfFriends(Map<String, List<String>> friendList) {
        Map<String, String> friendsOfFriends = new HashMap<>();

        friendList.forEach((main, friends) -> friends.forEach(friend -> {
            friendList.forEach((k, v) -> {
                if (!k.equals(main) && v.contains(friend) && !friends.contains(k) && !v.contains(main)) {
                    if (friendsOfFriends.containsKey(k)) {
                        if (!friendsOfFriends.get(k).contains(main)) {
                            friendsOfFriends.put(main, k);
                        }
                    } else {
                        friendsOfFriends.put(main, k);
                    }
                }
            });
        }));

        return friendsOfFriends;
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел. Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> averageSalary(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().mapToDouble(Employee::getSalary).average().orElseThrow()));
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
    public static List<String> alphabetContains(List<String> list, String alphabet) {
        return list.stream()
                .filter(str -> Set.of(alphabet.split("")).containsAll(List.of(str.replaceAll(" ", "").split(""))))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    public static List<String> numToBinary(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> numPalindromes(int start, int end) {
        return IntStream.range(start, end + 1)
                .filter(num -> {
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
                    String str = stringBuilder.toString();
                    String reversed = stringBuilder.reverse().toString();
                    return str.equals(reversed);
                })
                .boxed()
                .toList();
    }

    //Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> perfectNumbers(int start, int end) {
        return IntStream.range(start, end + 1)
                .filter(num -> IntStream.range(1, num).filter(divisor -> num % divisor == 0).sum() == num)
                .boxed()
                .toList();
    }
}
