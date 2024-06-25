package faang.school.godbless.streamapi2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.regex.Pattern;

public class StreamApiExercises {
    /**
     * На вход дан список целых чисел и число.
     * Найдите все уникальные пары чисел, сумма которых равна заданному числу. Порядок следования неважен.
     * Пример: Input List: [1, 9, 3, 6, 4, 5]
     * Target Sum: 10
     * Pairs: [[1, 9], [6, 4]]
     */
    public static List<List<Integer>> findTargetSumPairs(List<Integer> list, int targetSum) {
         List<Integer> preparedNumbers = list.stream()
                 .distinct()
                 .filter(num -> num <= targetSum)
                 .toList();

        return preparedNumbers.stream()
                .flatMap(num1 -> {
                    List<Integer> slicedNumbers = preparedNumbers.subList(preparedNumbers.indexOf(num1) + 1, preparedNumbers.size());

                    return slicedNumbers.stream()
                            .filter(num2 -> num1 + num2 == targetSum)
                            .map(num2 -> List.of(num1, num2));
                })
                .filter(pairs -> !pairs.isEmpty())
                .toList();
    }

    /**
     * На вход получаем мапу с названиями стран и их столицами.
     * Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
     */
    public static List<String> getCountriesCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    /**
     * Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
     * и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
     */
    public static List<String> getStringsStartingWithChar(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.toLowerCase().charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    /**
     * Дана мапа, где ключами являются имена людей, а значениями — списки имен их друзей.
     * Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
     * Считаем, что все имена уникальные.
     */
    public static List<List<String>> getMutualFriendsPairs(Map<String, List<String>> friends) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(friends.entrySet());

        return entries.stream()
                .flatMap(entry1 -> {
                    String entry1Name = entry1.getKey();

                    return entries.stream()
                            .filter(entry2 -> {
                                String entry2Name = entry2.getKey();
                                List<String> entry2Friends = entry2.getValue();

                                return !entry1Name.equals(entry2Name) && !entry2Friends.contains(entry1Name);
                            })
                            .filter(entry2 -> {
                                Set<String> mutualFriends = new HashSet<>(entry1.getValue());
                                mutualFriends.retainAll(entry2.getValue());

                                return !mutualFriends.isEmpty();
                            })
                            .map(entry2 -> Stream.of(entry1Name, entry2.getKey()).sorted().toList());
                })
                .distinct()
                .toList();
    }

    /**
     * Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
     * Найдите среднюю зарплату для каждого отдела. Должна получится Map с названием отдела и средней зарплатой.
     */
    public static Map<String, Integer> getAverageSalaryByDepartment(List<Employee> employees) {
        Map<String, Integer> salaryByDepartment = new HashMap<>();
        List<String> departments = employees.stream().map(Employee::department).distinct().toList();

        departments.forEach(department -> {
            OptionalDouble averageDepartmentSalary = employees.stream()
                    .filter(employee -> employee.department().equals(department))
                    .mapToInt(Employee::salary)
                    .average();

            averageDepartmentSalary.ifPresentOrElse(
                    (averageSalary) -> salaryByDepartment.put(department, (int) averageSalary),
                    () -> salaryByDepartment.put(department, 0)
            );
        });


        return salaryByDepartment;
    }

    /**
     * Дан список строк и массив букв, представляющий алфавит.
     * Отфильтруйте строки, которые содержат только буквы заданного алфавита,
     * и отсортируйте их в порядке возрастания длины строк.
     * Пример ввода:
     * Input Strings: [apple, banana, 123, dog, cat]
     * Alphabet: abcdefghijklmnopqrstuvwxyz
     * Output: [dog, cat, apple, banana]
     */
    public static List<String> filterStringsByAlphabet(List<String> strings, String alphabet) {
        Pattern pattern = Pattern.compile("[%s]".formatted(alphabet), Pattern.CASE_INSENSITIVE);

        return strings.stream()
                .filter(string -> pattern.matcher(string).find())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    /**
     * Написать метод, который преобразует список целых чисел в список строк,
     * где каждое число записано в двоичном виде.
     */
    public static List<String> convertIntegersToBinaryStrings(List<Integer> integers) {
        return integers.stream().map(Integer::toBinaryString).toList();
    }

    /**
     * Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
     * в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
     */
    public static List<Integer> findIntegerPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .filter(StreamApiExercises.isPalindrome()::test)
                .boxed()
                .toList();
    }

    private static Predicate<Integer> isPalindrome() {
        return num -> {
            String str = String.valueOf(num);

            if (str.length() < 2) {
                return false;
            }

            String reversed = new StringBuilder(str).reverse().toString();

            return str.equals(reversed);
        };
    }

    /**
     * Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами.
     * На вход получаем строку, а вернуть должны список строк.
     */
    public static List<String> findPalindromesWithinString(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, string.length() + 1)
                        .mapToObj(j -> string.substring(i, j)))
                .filter(str -> str.length() > 1 && str.contentEquals(new StringBuilder(str).reverse()))
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу)
     * в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
     */
    public static List<Integer> getPerfectNumbersWithinRange(int start, int end) {
        List<Integer> knownPerfectNumbers = List.of(6, 28, 496, 8128, 33550336);

        return knownPerfectNumbers.stream()
                .filter(num -> num >= start && num <= end)
                .toList();
    }
}
