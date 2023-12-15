package faang.school.godbless.streams2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 7, 9, 7, 6, 5, 4, 3, 2, 4, 5, 6, 7);
        char[] alfavit = {'a', 's', 'd', 'f', 'b', 'e', 'y', 'r', 'o', 'u', 'p', 'n', 'l', ' ', 'g', 'h', 'i'};

        List<String> strings = Arrays.asList("How can you say this", "was all path of", "your plan", "start explaining",
                "crafted from hope", "and hospital beds", "she is gone", "and honestly");

        List<Employee> employees = Arrays.asList(
                new Employee("Вася", 50000, "HR"),
                new Employee("Петя", 30000, "IT"),
                new Employee("Катя", 85000, "HR"),
                new Employee("Вова", 90000, "IT"),
                new Employee("\n0416ра", 60000, "IT")
        );

        Map<String, String> countryAndCapital = new HashMap<>();
        countryAndCapital.put("Russia", "Moscow");
        countryAndCapital.put("USA", "Washngton");
        countryAndCapital.put("Germany", "Berlin");

        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Коля", Arrays.asList("Петр", "Value1", "Value2"));
        friends.put("Кирилл", Arrays.asList("Value1", "Value3"));
        friends.put("Олег", Arrays.asList("Кирилл", "Value2", "Value3-3", "Value3-4"));
        friends.put("Валерий", Arrays.asList("Петр","Георгий"));

        List<List<Integer>> d = ManyOfMethods.findPairs(numbers, 14);
        System.out.println(d);

        ManyOfMethods.capitals(countryAndCapital);

        List<String> a = ManyOfMethods.sortStrings(strings, 'a');
        System.out.println(a);

        List<List<String>> fr = ManyOfMethods.pairOfPeople(friends);
        System.out.println(fr);//некорректно

        Map<String, Double> df = ManyOfMethods.averageEarnings(employees);
        System.out.println(df);

        List<String> as = ManyOfMethods.sortFilteredStrings(strings, alfavit);
        System.out.println(as);

        List<String> onesMoreList = ManyOfMethods.binaryNumbersToStrings(numbers);
        System.out.println(onesMoreList);

        List<Integer> ddf = ManyOfMethods.palindromes(100, 1000);
        System.out.println(ddf);
    }
}
