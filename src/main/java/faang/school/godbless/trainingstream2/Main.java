package faang.school.godbless.trainingstream2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 1, 3, 2, 6, 5, 3, 5, 1, 0);

        Map<String, String> countriesAndCapitals =
                Map.of("USA", "New-York",
                        "Russia", "Moscow",
                        "England", "London",
                        "Belarus", "Minsk");

        List<String> words = List.of("Apple", "Banana", "Phone", "Dog", "Object", "Arizona", "Antalya", "Bangladesh");

        List<Employee> employees =
                List.of(new Employee("Emp1", 420000, "IT"),
                        new Employee("Emp2", 210000, "Sales"),
                        new Employee("Emp3", 330000, "IT"),
                        new Employee("Emp4", 220000, "Sales"));
        String stringWithPalindromes = "level radar kayak program palindromes are cool";

        System.out.println(searchUniquePairsSum(numbers, 10));
        System.out.println(sortCapitalByCountry(countriesAndCapitals));
        System.out.println(filterByCharAndSort(words, 'A'));
        System.out.println(findMiddleSalary(employees));
        System.out.println(sortByAlphabet(words, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(convertToString(numbers));
        System.out.println(searchPalindromeInRange(100, 200));
        System.out.println(searchPalindromeInString(stringWithPalindromes));

    }

    /**
     * На вход дан список целых чисел и число. Найдите все уникальные пары чисел,
     * сумма которых равна заданному числу.
     *
     * @param numbers список целых чисел
     * @param target  число
     * @return sum
     */
    public static Set<List<Integer>> searchUniquePairsSum(List<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> j < i && j + i == target)
                        .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toSet());

    }

    /**
     * На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны
     * по алфавиту, а затем выведите названия их столиц в виде списка.
     *
     * @param countries список стран и столиц
     * @return sorted countries
     */
    public static List<String> sortCapitalByCountry(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    /**
     * Получаем список строк и букву в виде char. Отфильтруйте строки, которые
     * начинаются с заданной буквы, и отсортируйте их по длине в порядке
     * возрастания, и верните список этих строк.
     *
     * @param strings список строк
     * @param target  буква
     * @return filtered and sorted strings
     */
    public static List<String> filterByCharAndSort(List<String> strings, char target) {
        return strings.stream()
                .filter(str -> str.charAt(0) == target)
                .sorted()
                .toList();
    }

    /**
     * Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
     * Найдите среднюю зарплату для каждого отдела.
     * Должна получится map с именем отдела исредней зарплатой.
     *
     * @param employees список объектов Employee
     * @return middle salary of department
     */
    public static Map<String, Double> findMiddleSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)));
    }

    /**
     * Дан список строк и массив букв, представляющий алфавит. Отфильтруйте строки, которые
     * содержат только буквы заданного алфавита, и отсортируйте их
     * в порядке возрастания длины строк.
     *
     * @param strings  список строк
     * @param alphabet алфавит
     * @return sorted by containing in alphabet
     */
    public static List<String> sortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .toList();
    }

    /**
     * Метод, который преобразует список целых чисел в список строк, где каждое
     * число записано в двоичном виде
     *
     * @param numbers начало диапазона
     * @return list of strings
     */
    public static List<String> convertToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    /**
     * Написать метод, который найдет все числа-палиндромы в заданном диапазоне.
     * На вход получаем число для начала диапазона и число для второй границы
     *
     * @param start начало диапазона
     * @param end   конец диапазона
     * @return palindromes
     */
    public static List<Integer> searchPalindromeInRange(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .map(String::valueOf)
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .map(Integer::valueOf)
                .toList();
    }

    /**
     * Написать метод, который найдёт все подстроки в строке, которые являются палиндромами.
     * На вход получаем строку, а вернуть должны список строк.
     *
     * @param string строка
     * @return palindromes list
     */
    public static List<String> searchPalindromeInString(String string) {
        return Arrays.stream(string.split(" "))
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .toList();
    }
}
