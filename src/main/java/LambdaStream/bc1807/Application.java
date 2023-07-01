package LambdaStream.bc1807;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {

    }

//    На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.

    public static Map<Integer, Integer> uniqueNumbers(List<Integer> numbers, int number) {
        Map<Integer, Integer> map = numbers
                .stream()
                .collect(Collectors.toMap(Function.identity(), x -> 0));
        Map<Integer, Integer> result = new HashMap<>();
        numbers.forEach(num -> {
            if (map.containsKey(number - num)) {
                result.put(num, number - num);
            }
        });
        return result;
    }
//    На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту,
//    а затем выведите названия их столиц в виде списка.

    public static List<String> countryCapital(Map<String, String> countryCity) {
        List<String> sortedCountries = countryCity
                .keySet()
                .stream()
                .sorted()
                .toList();
        return sortedCountries
                .stream()
                .map(countryCity::get)
                .toList();
    }

//    Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
//    и отсортируйте их по длине в порядке возрастания, и верните список этих строк.

    public static List<String> filterStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

//    Дана мапа, где ключами являются имена людей, а значениями — списки их друзей. Найдите все пары людей,
//    которые не являются друзьями, но у них есть общие друзья.

    public static Map<String, String> pairFriends(Map<String, List<String>> peoples) {
        Map<String, String> result = new HashMap<>();
        peoples.forEach((user, friends) -> {
            peoples.forEach((anotherUser, anotherFriends) -> {
                if (!user.equals(anotherUser) && !friends.contains(anotherUser)) {
                    friends.stream()
                            .filter(anotherFriends::contains)
                            .findFirst()
                            .ifPresent(friend -> {
                                result.put(user, anotherUser);
                            });
                }
            });
        });
        return result;
    }

//    Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
//    Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.

    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors
                                .averagingDouble(Employee::getSalary)));
    }

    //    Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
//    и отсортируйте их в порядке возрастания длины строк.
    public static List<String> filterRegex(List<String> strings) {
        return strings.stream()
                .filter(str -> str.matches("[a-zA-Z]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

//    Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.

    public static List<String> integerToString(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

//    Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
//    в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.

    public static List<Integer> numberPalindrom(int start, int end) {
        return IntStream.rangeClosed(start, end).filter(num -> {
            String str = String.valueOf(num);
            return str.equals(new StringBuilder(str).reverse().toString());
        }).boxed().toList();
    }

//    Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами.
//    На вход получаем строку, а вернуть должны список строк.

//    Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу)
//    в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
}

