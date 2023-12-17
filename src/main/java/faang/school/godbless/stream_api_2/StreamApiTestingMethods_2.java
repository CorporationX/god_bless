package faang.school.godbless.stream_api_2;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StreamApiTestingMethods_2 {
    public static void main(String[] args) {
        Map<String, List<String>> mapFriendsAndTheirFriends = new HashMap<>();
        mapFriendsAndTheirFriends.put("Ignat", Arrays.asList("alisa", "bob", "makar", "anton", "petr", "bob", "makar"
                , "artem", "taras", "denis", "stas", "roma", "oksana"));
        mapFriendsAndTheirFriends.put("Kostya", Arrays.asList("robert", "vlad", "kirill", "anton", "igor", "lenya", "kris"));
        mapFriendsAndTheirFriends.put("Nikita", Arrays.asList("kolya", "boris", "regina", "anya", "tolay", "vitya", "gleb"));
        mapFriendsAndTheirFriends.put("Valera", Arrays.asList("mark", "andry", "mustafa", "chong"));
        mapFriendsAndTheirFriends.put("Ilya", Arrays.asList("robert", "vlad", "kirill", "anton", "igor", "lenya", "kris"));
        mapFriendsAndTheirFriends.put("Sergey", Arrays.asList("robert", "vlad", "kirill", "anton", "igor", "oleg", "kris"));

        Map<String, String> countryAndCapital = new HashMap<>();
        countryAndCapital.put("Turkey", "Ankara");
        countryAndCapital.put("Tailand", "Bangkok");
        countryAndCapital.put("China", "Pekin");
        countryAndCapital.put("Canada", "Vankuver");
        countryAndCapital.put("Egypt", "Kair");
        countryAndCapital.put("Cuba", "Gavana");
        countryAndCapital.put("Irland", "Dublin");
        countryAndCapital.put("Niderland", "Amsterdam");

        List<String> stringsByExample = Arrays.asList("kakskak", "velo", "filippine", "word", "wow", "Application"
                , "orbit", "yagoda", "winter", "pop");

        List<Employee> employees = List.of(
                new Employee(1000, "it"),
                new Employee(1200, "hr"),
                new Employee(800, "it"),
                new Employee(1600, "it"),
                new Employee(600, "hr"),
                new Employee(1400, "hr"),
                new Employee(1000, "it"),
                new Employee(9000, "drivers"),
                new Employee(1400, "drivers")
        );

        System.out.println(uniquePairOfNumbers(Arrays.asList(1, 2, 3, 4, 6, 5, 9, 10, 12, 8, 8, 5, 7, 3), 15));
        System.out.println(sortedCapitalCities(countryAndCapital));
        System.out.println(findPairHumanByFriends(mapFriendsAndTheirFriends));
        List<String> findFirstCharAndSortingByLength = findFirstCharAndSortingByLength(stringsByExample, 'v');
        findFirstCharAndSortingByLength.forEach(System.out::println);
        System.out.println(departmentAndAverageSalary(employees));
        List<String> filtredLines = stringsAscendingOrder(stringsByExample, "ak");
        filtredLines.forEach(System.out::println);
        System.out.println(binaryListOfNumbers(Arrays.asList(44, 65, 234, 65, 1, 2, 4, 6, 7)));
        System.out.println(findPalindromeSubstrings("Wow privet oko potop ruka rom"));
        System.out.println(findPalindromeSubInteger(10, 222));
    }

    public static Set<List<Integer>> uniquePairOfNumbers(List<Integer> nums, int sum) {
        return nums.stream()
                .filter(number -> nums.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    //Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> sortedCapitalCities(Map<String, String> countryAndCapitals) {
        return countryAndCapitals.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted()
                .toList();
    }

    // Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
    //  и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> findFirstCharAndSortingByLength(List<String> list, char firstSymbol) {
        return list.stream()
                .filter(string -> string.startsWith(String.valueOf(firstSymbol)))
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    // Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static List<List<String>> findPairHumanByFriends(Map<String, List<String>> names) {
        return names.entrySet().stream()
                .flatMap(key1 -> names.entrySet().stream()
                        .filter(key2 -> !key2.getKey().equalsIgnoreCase(key1.getKey()))
                        .filter(key2 -> !key2.getValue().contains(key1.getKey()))
                        .filter(key2 -> key1.getKey().compareTo(key2.getKey()) > 0)
                        .filter(key2 -> !Collections.disjoint(key1.getValue(), key2.getValue()))
                        .map(key2 -> List.of(key1.getKey(), key2.getKey())))
                .distinct()
                .toList();
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    // Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> departmentAndAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
    public static List<String> stringsAscendingOrder(List<String> strings, String naborBukv) {
        return strings.stream()
                .filter(string -> string.contains(naborBukv))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    public static List<String> binaryListOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне.
    // На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> findPalindromeSubInteger(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(String::valueOf)
                .filter(num1 -> num1.contentEquals(new StringBuilder(num1).reverse()))
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();
    }

    //Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами. На вход получаем строку, а вернуть должны список строк.
    public static List<String> findPalindromeSubstrings(String line) {
        String[] arrayString = line.split(" ");
        return Arrays.stream(arrayString)
                .filter(str -> str.equalsIgnoreCase(String.valueOf(new StringBuilder(str).reverse())))
                .toList();
    }
}


@Data
class Employee {
    private String name;
    private int salary;
    private String department;

    public Employee(int salary, String department) {
        this.salary = salary;
        this.department = department;
    }
}