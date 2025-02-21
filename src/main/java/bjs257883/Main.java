package bjs257883;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Calculations calculations = new Calculations();
        Map<String, List<String>> initializedData = getInitializedPeopleData();
        logger.info("{}", calculations.getFriendlyPeople(initializedData));
        logger.info("{}", calculations.getAverageSalary(getInitializedAverageSalaryData()));
        logger.info("{}", calculations.getNumbersPalindromes(
                getInitializedNumbersPalindromesData().get(0), getInitializedNumbersPalindromesData().get(1)));
        logger.info("{}", calculations.getSubstringsPalindromes(getInitializedSubstringsPalindromesData()));
    }

    private static Map<String, List<String>> getInitializedPeopleData() {
        Map<String, List<String>> nameToFriends = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Bob");
        list1.add("Charlie");
        nameToFriends.put("Alice", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Alice");
        list2.add("David");
        nameToFriends.put("Bob", list2);

        List<String> list3 = new ArrayList<>();
        list3.add("Alice");
        list3.add("David");
        nameToFriends.put("Charlie", list3);

        List<String> list4 = new ArrayList<>();
        list4.add("Bob");
        list4.add("Charlie");
        nameToFriends.put("David", list4);

        return nameToFriends;
    }

    private static List<Employee> getInitializedAverageSalaryData() {
        return List.of(new Employee("Emloyee1", 200000L, "Test department"),
                new Employee("Emloyee2", 300000L, "Test department"),
                new Employee("Emloyee3", 500000L, "Test department"));
    }

    private static List<Integer> getInitializedNumbersPalindromesData() {
        return List.of(100, 200);
    }

    private static String getInitializedSubstringsPalindromesData() {
        return "abac";
    }
}
