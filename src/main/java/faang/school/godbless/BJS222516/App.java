package faang.school.godbless.BJS222516;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
//        System.out.println(findPairsWithSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 10));
        List<int[]> pairs = findPairsWithSum(numbersForPair, targetSum);
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

        System.out.println(sortCountriesAndGetCapitals(Map.of(
                "Kazakhstan", "Astana",
                "Russia", "Moscow",
                "England", "London",
                "Germany", "Berlin")));

        System.out.println(filterAndSortStrings(
                Arrays.asList("apple", "banana", "avocado", "apricot", "blueberry"), 'a'));

        System.out.println(findNonFriendsWithCommonFriends(Map.of(
                "Alice", Arrays.asList("Bob", "Charlie", "David"),
                "Bob", Arrays.asList("Alice", "Charlie"),
                "Charlie", Arrays.asList("Alice", "Bob", "David"),
                "David", Arrays.asList("Alice", "Charlie")
        )));

        System.out.println(calculateAverageSalaryByDep(List.of(
                new Employee("Alice", 1000, "HR"),
                new Employee("Bob", 1500, "IT"),
                new Employee("Charlie", 1200, "HR"),
                new Employee("David", 2000, "IT"),
                new Employee("Eve", 1800, "HR")
        )));

        System.out.println(filterStringsByAlphabet(
                Arrays.asList("apple", "banana", "avocado", "apricot", "blueberry"), "abc"));

        System.out.println(convertNumbersToBinary(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));

        System.out.println(findPalindromesInRange(1, 1000));
    }

    static List<Integer> numbersForPair = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    static int targetSum = 10;
    List<Integer> numbers = new ArrayList<>();

    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел,
    // сумма которых равна заданному числу.
    private static List<int[]> findPairsWithSum(List<Integer> numbers, int targetSum) {
        // Создаем пустое множество для хранения чисел, которые мы уже видели
        Set<Integer> seen = new HashSet<>();
        // Создаем пустое множество для хранения уникальных пар чисел
        // (каждая пара представлена массивом из двух элементов)
        Set<int[]> result = new HashSet<>();
        // Проходим по каждому числу в списке 'numbers'
        numbers.forEach(num -> {
            // Для каждого числа вычисляем "дополнение" — число, которое нужно сложить с текущим числом,
            // чтобы получить 'targetSum'
            int complement = targetSum - num;
            // Если 'complement' уже есть в множестве 'seen', значит, у нас есть пара чисел,
            // сумма которых равна 'targetSum'
            if (seen.contains(complement)) {
                // Создаем массив, содержащий найденную пару чисел
                int[] pair = new int[]{complement, num};
                // Сортируем массив, чтобы пары с одинаковыми числами шли в одинаковом порядке
                // (например, [2, 3] и [3, 2] будут представлены как [2, 3])
                Arrays.sort(pair);
                // Добавляем пару в множество 'result'
                result.add(pair);
            }
            // Добавляем текущее число в множество 'seen', чтобы в дальнейшем можно было
            // его использовать для поиска пары
            seen.add(num);
        });
        // Преобразуем множество 'result' в список и возвращаем его
        return new ArrayList<>(result);
        // Сам не додумался бы, чат помог))
    }

    //На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту, а затем выведите
    // названия их столиц в виде списка.
    private static List<String> sortCountriesAndGetCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    //Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    private static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей. Найдите все пары людей,
    // которые не являются друзьями, но у них есть общие друзья.
    private static List<String> findNonFriendsWithCommonFriends(Map<String, List<String>> friendsMap) {
        List<String> pairs = new ArrayList<>();

        friendsMap.forEach((person, friends) -> {
            friendsMap.forEach((otherPerson, otherFriends) -> {
                if (!person.equals(otherPerson) && !friends.contains(otherPerson)) {
                    if (friends.stream().anyMatch(otherFriends::contains)) {
                        pairs.add(person + " - " + otherPerson);
                    }
                }
            });
        });
        return pairs;
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    //Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    private static Map<String, Double> calculateAverageSalaryByDep(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    // и отсортируйте их в порядке возрастания длины строк.
    private static List<String> filterStringsByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    private static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
    //в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    private static List<Integer> findPalindromesInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(App::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        return str.contentEquals(new StringBuilder(str).reverse());
    }


    //Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами. На вход получаем строку, а вернуть должны список строк.
    //Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.

}
