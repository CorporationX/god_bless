package faang.school.godbless.stream_api.task2stream2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Иван", 1000, "Отдел разработки"),
            new Employee("Мария", 1000, "Отдел разработки"),
            new Employee("Алексей", 2000, "Отдел продаж"),
            new Employee("Елена", 2000, "Отдел продаж")
        );
        Map<String, List<String>> mapFriends = new HashMap<>();
        mapFriends.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
        mapFriends.put("Bob", Arrays.asList("Alice", "Charlie"));
        mapFriends.put("Charlie", Arrays.asList("Alice", "Bob", "David"));
        mapFriends.put("David", Arrays.asList("Alice", "Charlie"));

        Map<String, String> countries = Map.of(
                "Brasilia", "Brasilia",
                "Australia", "Canberra",
                "Canada", "Ottawa"
        );

        List<Integer> list = List.of(1, 2, 3, 4);

        List<String> strings = List.of("apple", "banana", "orange", "avocado", "grape");

        List<String> strings2 = List.of("ежик", "banana", "orange", "avocado", "grape");

        System.out.println(StreamMethods.findPairsWithSum(list, 3));
        System.out.println(StreamMethods.sortCountries(countries));
        System.out.println(StreamMethods.sortStrStartChar(strings, 'a'));
        System.out.println(StreamMethods.findCommonFriends(mapFriends));
        System.out.println(StreamMethods.avrTypeEmployee(employees));
        System.out.println(StreamMethods.alfStr(strings2, "абвгежзиклмнопростысявсдпжякапжтэ"));
        System.out.println(StreamMethods.bin(list));
        System.out.println(StreamMethods.palindromes(100, 1000));
    }
}
