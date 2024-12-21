package school.faang.bjs46903;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Alice", List.of("Bob", "Charlie"));
        friends.put("Bob", List.of("Alice", "David"));
        friends.put("Charlie", List.of("Alice", "David"));
        friends.put("David", List.of("Bob", "Charlie"));
        System.out.println(Service.commonFriend(friends));

        System.out.println(Service.palindromeNumbers(100, 191));
        System.out.println(Service.subPalindrome("abac"));
        System.out.println(Service.perfectNumbers(1, 496));

        var employee1 = new Employee("Paul", 20, "Dep1");
        var employee2 = new Employee("Paul", 30, "Dep1");
        var employee3 = new Employee("Paul", 20, "Dep2");
        System.out.println(Service.averageSalaryByDep(List.of(employee1, employee2, employee3)));
    }
}
