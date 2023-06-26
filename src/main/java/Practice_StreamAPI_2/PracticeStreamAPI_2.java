package Practice_StreamAPI_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeStreamAPI_2 {
    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел,
    // сумма которых равна заданному числу.
    public static Map<Integer, Integer> findPairsWhoseSumEqualsNumber(List<Integer> numbers, int number) {
        Map<Integer, Integer> result = new HashMap<>();
        numbers.stream()
                .forEach(num -> {
                    numbers.stream()
                            .filter(n -> n == number - num)
                            .forEach(filteredNum -> {
                                if (!result.containsKey(num) && !result.containsKey(filteredNum)) {
                                    result.put(num, filteredNum);
                                }
                            });
                });
        return result;
    }

    //На вход получаем мапу с названиями стран и их столицами.
    // Отсортируйте страны по алфавиту,
    // а затем выведите названия их столиц в виде списка
    public static List<String> sortCapitalsAlphabetically(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted((country1, country2) -> country1.getKey().compareTo(country2.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    //Получаем список строк и букву в виде char.
    // Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания,
    // и верните список этих строк.
    public static List<String> sortStringsAlphabeticallyAndByLength(List<String> stringList, char letter) {
        return stringList.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    // Найдите все пары людей, которые не являются друзьями,
    // но у них есть общие друзья.
    public static List<String> findCommonFriendPairs(Map<String, List<String>> peopleAndTheirFriendsMap) {
        return peopleAndTheirFriendsMap.entrySet().stream()
                .flatMap(person -> peopleAndTheirFriendsMap.entrySet().stream()
                        .filter(thisPerson -> !person.getKey().equals(thisPerson.getKey()))
                        .filter(friend -> !person.getValue().contains(friend.getKey()))
                        .filter(commonFriendPerson -> person.getValue().stream()
                                .anyMatch(friend -> commonFriendPerson.getValue().contains(friend)))
                        .map(otherPerson -> person.getKey() + " - " + otherPerson.getKey()))
                .collect(Collectors.toList());
    }

    // Получаем список объектов класса Employee, у каждого из которых есть имя,
    // зарплата и отдел. Найдите среднюю зарплату для каждого отдела.
    // Должна получится map с именем отдела и средней зарплатой.
    public static Map<Department, Double> createMapOfAverageSalaryByDepartment(List<Employee> employeeList) {
        Map<Department, Double> result = new HashMap<>();
        Map<Department, List<Employee>> mapEmployeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        mapEmployeesByDepartment.entrySet().stream()
                .forEach(department -> {
                    List<Employee> employeesInDepartment = department.getValue();
                    int numberOfEmployees = employeesInDepartment.size();
                    Optional<Double> allSalariesOfEmployeesOptional = employeesInDepartment.stream()
                            .map(Employee::getSalary)
                            .reduce((allSalaries, employeeSalary) -> allSalaries + employeeSalary);
                    if (allSalariesOfEmployeesOptional.isPresent()) {
                        double allSalariesOfEmployees = allSalariesOfEmployeesOptional.get();
                        double averageSalary = allSalariesOfEmployees / numberOfEmployees;
                        result.put(department.getKey(), averageSalary);
                    }
                });
        return result;
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы
    // заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
    public static List<String> filterStringsContainsLettersAndSortByLength(List<String> stringList, List<Character> alphabet) {
        List<String> filteredList = new ArrayList<>();
        stringList.stream()
                .forEach(string -> {
                    List<Character> charsFromString = string.chars().mapToObj(character -> (char) character)
                            .toList();
                    boolean isAllLettersInAlphabet = charsFromString.stream()
                            .allMatch(alphabet::contains);
                    if (isAllLettersInAlphabet) {
                        filteredList.add(string);
                    }
                });
        return filteredList.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    //Написать метод, который преобразует список целых чисел в список строк,
    // где каждое число записано в двоичном виде.
    public static List<String> convertToBinary(List<Integer> numbersList) {
        return numbersList.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //Написать метод, который найдет все числа-палиндромы
    // (читающиеся одинаково слева направо и справа налево) в заданном диапазоне.
    // На вход получаем число для начала диапазона и число для второй
    // границы диапазона.
    public static int[] findAllNumberPalindromesInRange(int from, int to) {
        IntStream intStream = IntStream.rangeClosed(from, to);
        return intStream.filter(num -> {
            String numStr = String.valueOf(num);
            int length = numStr.length();
            for (int i = 0; i < (length / 2); i++) {
                if (numStr.charAt(i) != numStr.charAt(length - i - 1)) {
                    return false;
                }
            }
            return true;
        }).toArray();
    }

    //Доп задание: Написать метод, который найдёт все подстроки в строке,
    // которые являются палиндромами. На вход получаем строку,
    // а вернуть должны список строк.
    public static List<String> findPalindromeSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, input.length() + 1)
                        .mapToObj(j -> input.substring(i, j)))
                .distinct()
                .filter(PracticeStreamAPI_2::isPalindrome)
                .collect(Collectors.toList());
    }

    protected static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    //Доп задание: Написать метод, который найдёт все совершенные числа
    // (сумма делителей числа равна самому числу) в заданном диапазоне.
    // На вход получаем число для начала диапазона и число для второй
    // границы диапазона.
    public static List<Integer> findPerfectNumbersInRange(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(number -> {
                    int sum = IntStream.range(1, number)
                            .filter(i -> number % i == 0)
                            .sum();
                    return sum == number;
                })
                .boxed()
                .toList();
    }
}
