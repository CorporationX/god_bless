package faang.school.godbless.Task22_API_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    static final List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
    static final int target = 10;
    static final List<String> strings = Arrays.asList("something", "some", "sad", "new", "now", "sold");
    static final Map<String, List<String>> FRIENDS = new HashMap<>();

    public static void main(String[] args) {
        //task1
        Set<Solver.Pair> task1 = Solver.findPairs(numbers, target);
        System.out.println(task1);
        //task2
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("England", "London");
        countriesAndCapitals.put("Spain", "Madrid");
        countriesAndCapitals.put("France", "Paris");
        System.out.println(StringService.sortCapitals(countriesAndCapitals));
        //task3
        System.out.println(StringService.stringFilter(strings, 's'));
        //task4
        List<String> johnFriends = Arrays.asList("Jordan", "Ben");
        List<String> mikeFriends = Arrays.asList("Kyle", "Andrew");
        List<String> kyleFriends = Arrays.asList("Ben", "Mark", "Mike");
        List<String> benFriends = Arrays.asList("Kyle", "John");
        FRIENDS.put("John", johnFriends);
        FRIENDS.put("Mike", mikeFriends);
        FRIENDS.put("Kyle", kyleFriends);
        FRIENDS.put("Ben", benFriends);
        System.out.println(StringService.findCommonFriend(FRIENDS));
        //task5
        Employee alex = new Employee("Alex", 50, "user support");
        Employee john = new Employee("John", 100, "user support");
        Employee paul = new Employee("Paul", 100, "IT");
        Employee mark = new Employee("Mark", 200, "IT");
        List<Employee> workers = new ArrayList<>();
        workers.add(alex);
        workers.add(john);
        workers.add(paul);
        workers.add(mark);
        System.out.println(Employee.findAvgSalary(workers));
        //task6
        List<String> words = Arrays.asList("abc", "2", "123", "", "@", "dream");
        System.out.println(StringService.alphabetFilter(words));
        //task7
        List<Integer> values = Arrays.asList(1, 2, 16, 31, 37, -2); //для 32-битных чисел, другие отфильтруются
        System.out.println(Solver.convertToBinary(values));
        //task8
        System.out.println(Solver.findPalindrome(0,200));
    }

}
