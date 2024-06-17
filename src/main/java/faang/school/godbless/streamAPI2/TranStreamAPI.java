package faang.school.godbless.streamAPI2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TranStreamAPI {

    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    public Set<List<Integer>> searchSumPairTarget(List<Integer> numbers, int target) {
        if (numbers.isEmpty() || numbers == null) {
            throw new IllegalArgumentException(
                    "TranStreamAPI class method searchSumPairTarget apply empty or non-existent List");
        }
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == target)
                        .map(j -> Arrays.asList(i, j)))
                .filter(pair -> pair.get(1) < pair.get(0))
                .collect(Collectors.toSet());
    }

    //На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту,
    // а затем выведите названия их столиц в виде списка.
    public List<String> sortCapitalByCountry(Map<String, String> CapitalByCountry) {
        if (CapitalByCountry.isEmpty() || CapitalByCountry == null) {
            throw new IllegalArgumentException(
                    "TranStreamAPI class method sortCapitalByCountry apply empty or non-existent Map");
        }
        return CapitalByCountry.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    //Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public List<String> findByCharAndSort(List<String> someStrings, char target) {
        if (someStrings.isEmpty() || someStrings == null) {
            throw new IllegalArgumentException(
                    "TranStreamAPI class method findByCharAndSort apply empty or non-existent List");
        }
        return someStrings.stream()
                .filter(s -> s.charAt(0) == target)
                .sorted((o, t) -> o.length() - t.length())
                .toList();
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    //Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public Set<List<String>> searchingFamiliarPeople(Map<String, List<String>> peopleWithFriends) {
        if (peopleWithFriends.isEmpty() || peopleWithFriends == null) {
            throw new IllegalArgumentException(
                    "TranStreamAPI class method sortCapitalByCountry apply empty or non-existent Map");
        }
        return peopleWithFriends.keySet().stream()
                .flatMap(pers1 -> peopleWithFriends.keySet().stream()
                        .filter(pers2 -> !pers1.equals(pers2)
                                && !peopleWithFriends.get(pers1).contains(pers2)
                                && !peopleWithFriends.get(pers2).contains(pers1))
                        .map(pers2 -> {
                            List<String> pair = Arrays.asList(pers1, pers2);
                            Collections.sort(pair);
                            return pair;
                        }))
                .filter(pair -> {
                    var friendOfPers1 = new HashSet<>(peopleWithFriends.get(pair.get(0)));
                    var friendOfPers2 = new HashSet<>(peopleWithFriends.get(pair.get(1)));
                    return friendOfPers1.retainAll(friendOfPers2);
                })
                .collect(Collectors.toSet());
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    //Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public Map<String, Double> middleSalaryForDepartment(List<Employee> employees) {
        if (employees.isEmpty() || employees == null) {
            throw new IllegalArgumentException(
                    "TranStreamAPI class method findByCharAndSort apply empty or non-existent List");
        }
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    //Написать метод, который преобразует список целых чисел в список строк,
    // где каждое число записано в двоичном виде
    public List<String> convertNumberToBinary(List<Integer> nums) {
        if (nums.isEmpty() || nums == null) {
            throw new IllegalArgumentException(
                    "TranStreamAPI class method findByCharAndSort apply empty or non-existent List");
        }
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //Написать метод, который найдет все числа-палиндромы в заданном диапазоне.
    // На вход получаем число для начала диапазона и число для второй границы диапазона.
    public List<Integer> searchNumberPalindromeInRange(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException(String.format(
                    "TranStreamAPI class method searchNumberPalindromeInRange apply end number: %d more start number: %d", end, start));
        }
        return IntStream.range(start, end)
                .boxed()
                .map(String::valueOf)
                .filter(str -> str.contentEquals(new StringBuilder(str).reverse()))
                .map(Integer::valueOf)
                .toList();
    }
}
