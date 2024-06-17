package faang.school.godbless.lamdbastreamapi.steamapi2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(List.of( 1, 9, 3, 6, 4, 5));
        // Получение пар чисел, которые в сумме равны переданному параметру
        System.out.println(getUniquePairsForSum(nums, 10));

        // Сортировка столиц стран
        Map<String, String> countriesCapitals = new HashMap<>(Map.of(
                "Россия", "Москва",
                "Великобритания","Лондон",
                "Япония","Токио",
                "Франция","Париж"
        ));
        showCapital(countriesCapitals);

        // Строки, начинаются с заданного символа
        List<String> words = new ArrayList<>(List.of(
                "абвге",
                "выфвапе",
                "аывапаып",
                "апе"
        ));
        System.out.println(filterStringSort(words, 'а'));

        // Обшие друзья
        Map<String, List<String>> peopleWithFriends = new HashMap<>();
        peopleWithFriends.put("Дима", new ArrayList<>(List.of("Пётр","Иван")));
        peopleWithFriends.put("Пётр", new ArrayList<>(List.of("Иван", "Дима")));
        peopleWithFriends.put("Александр", new ArrayList<>(List.of("Миша")));
        peopleWithFriends.put("Иван", new ArrayList<>(List.of("Пётр","Дима","Миша")));
        System.out.println(findHaveCommonFriends(peopleWithFriends));

        // Средняя зп по отделу
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", 10000, "IT"));
        employees.add(new Employee("2", 12000, "IT"));
        employees.add(new Employee("3", 11000, "IT"));
        employees.add(new Employee("4", 3000, "HR"));
        employees.add(new Employee("5", 4000, "HR"));
        System.out.println(getAvgSalaryForDepartment(employees));

        // Получение слов по алфавиту
        System.out.println(filterStringByAlphabet(words, "выфвапе"));

        // Преобразования в двоичный вид
        System.out.println(parseToBinary(new ArrayList<>(List.of(1, 3, 10, 5))));

        // Поиск чисел-палиндромов
        System.out.println(Arrays.toString(findNumbersPalindrom(10, 100)));

        // Поиск палиндромов в строке
        System.out.println(findStringPalindrom("adada"));

        // Вывод всех совершенных чисел
        System.out.println(Arrays.toString(findPerfectNumbers(1, 100)));
    }

    public static Set<Set<Integer>> getUniquePairsForSum(List<Integer> nums, int numSum) {
        return Stream.iterate(0, n -> n + 1).limit(nums.size())
                .flatMap(idx -> {
                    return Stream.iterate(0, n -> n + 1).limit(nums.size())
                            .filter(idxPair -> {
                                return !Objects.equals(idx,idxPair) && nums.get(idx) + nums.get(idxPair) == numSum;
                            })
                            .map(idxPair -> new HashSet<>(Set.of(nums.get(idx), nums.get(idxPair))));
                })
                .collect(Collectors.toSet());
    }

    public static void showCapital(Map<String, String> countriesCapitals) {
        List<String> capitals = countriesCapitals.entrySet().stream().sorted((countryCapital1, countryCapital2) -> {
            return countryCapital1.getKey().compareTo(countryCapital2.getKey());
        }).map(Map.Entry::getValue).toList();
        System.out.println(capitals);
    }

    public static List<String> filterStringSort(List<String> words, char filterChar) {
        return words.stream().filter(word -> word.charAt(0) == filterChar).sorted((word1, word2) -> {
            return Integer.compare(word1.length(), word2.length());
        }).toList();
    }

    public static Set<Set<String>> findHaveCommonFriends(Map<String, List<String>> peopleWithFriends) {
        Set<String> uniquePeoplie = peopleWithFriends.entrySet().stream()
                .flatMap(people -> {
                    people.getValue().add(people.getKey());
                    return people.getValue().stream();
                })
                .collect(Collectors.toSet());

        return peopleWithFriends.entrySet().stream().flatMap(people -> {
                Set<String> peopleFriends = new HashSet<>(people.getValue());
                Set<String> notFriends = new HashSet<>(uniquePeoplie);
                notFriends.removeAll(peopleFriends);
                return notFriends.stream()
                        .filter(notFriend -> {
                            List<String> notFriendFriends = peopleWithFriends.get(notFriend);
                            if (notFriendFriends == null) {
                                return false;
                            }

                            return new HashSet<>(notFriendFriends).stream().anyMatch(peopleFriends::contains);
                        })
                        .map(element -> new HashSet<>(Set.of(people.getKey(), element)));
        }).collect(Collectors.toSet());
    }

    public static Map<String, Double> getAvgSalaryForDepartment(List<Employee> employees) {

        return employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary))
                );
    }

    public static List<String> filterStringByAlphabet(List<String> words, String alphabet) {
        return words.stream().filter(word -> {
            return Stream.of(word).allMatch(alphabet::contains);
        }).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> parseToBinary(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static int[] findNumbersPalindrom(int leftBorder, int rigthBorder) {
        return IntStream.iterate(leftBorder, n -> n + 1).limit(rigthBorder - leftBorder + 1)
                .filter(num -> num == Integer.parseInt(new StringBuilder(Integer.toString(num)).reverse().toString()))
                .toArray();
    }

    public static List<String> findStringPalindrom(String word) {
        return Stream.iterate(0, n -> n + 1).limit(word.length())
                .flatMap(idx -> {
                    return Stream.iterate(idx, n -> n + 1)
                            .limit(word.length() - idx)
                            .map(endIdx -> {
                                return word.substring(idx, endIdx + 1);
                            })
                            .filter(string -> {
                                return string.length() > 1 && string.contentEquals(new StringBuilder(string).reverse());
                            });
                })
                .distinct()
                .toList();
    }

    public static int[] findPerfectNumbers(int leftBorder, int rigthBorder) {
        return IntStream.iterate(leftBorder, n -> n + 1).limit(rigthBorder - leftBorder + 1)
                .filter(num -> {
                    int sumDividers = IntStream.iterate(1, n -> n + 1)
                            .limit(num - 1)
                            .filter(n -> num % n == 0)
                            .sum();

                    return num == sumDividers;
                })
                .toArray();
    }
}
