package school.faang.sprint2.task47055;

import school.faang.sprint2.task47055.model.Employee;
import school.faang.sprint2.task47055.service.StreamFunc;

import java.util.*;

public class StreamApp {
    public static void main(String[] args) {


        Map<String, List<String>> friends = getFriends();

        List<List<String>> friendsOfFriends1;
        List<List<String>> friendsOfFriends2;
        Set<List<String>> friendsOfFriends3;

        //System.out.println("CALC RES 1");
        friendsOfFriends1 = StreamFunc.getFriendsOfFriends(friends);
        //System.out.println("CALC RES 2");
        //friendsOfFriends2 = StreamFunc.getCrossFriends(friends); // для сравнения
        //System.out.println("CALC RES 3");
        //friendsOfFriends3 = StreamFunc.findNonFriendsWithCommonFriends(friends); // для сравнения

        System.out.println("Result 1");
        System.out.println(friendsOfFriends1);
//        System.out.println("Result 2");
//        System.out.println(friendsOfFriends2);
//        System.out.println("Result 3");
//        System.out.println(friendsOfFriends3);

        Employee employee1 = new Employee("John", "Sales", 10000.);
        Employee employee2 = new Employee("Sarah", "Sales", 12000.);
        Employee employee3 = new Employee("Teresa", "Cleaning", 5000.);
        Employee employee4 = new Employee("Bob", "Cleaning", 6000.);
        Employee employee5 = new Employee("Margaret", "Developer", 8000.);
        Employee employee6 = new Employee("Donald", "Developer", 9000.);
        Employee employee7 = new Employee("Mary", "Developer", 9100.);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);

        Map <String, Double> salaryByDepartments = StreamFunc.getAverageSale(employees);
        System.out.println("salaryByDepartments: ");
        System.out.println(salaryByDepartments);



        List<String> numPalindromes = StreamFunc.getAllPalindromes(1000, 2000);
        System.out.println("Numbers-palindromes");
        System.out.println(numPalindromes);

        List<String> strPalindromes = StreamFunc.getSubstringPalindromes("abac");
        System.out.println("Strings-palindromes");
        System.out.println(strPalindromes);


        List<Integer> perfectNumbers = StreamFunc.getPerfectNumbers(1, 1000);
        System.out.println("Perfect Numbers");
        System.out.println(perfectNumbers);



    }

    private static Map<String, List<String>> getFriends() {
        Map<String, List<String>> friends = new HashMap<>();

        List<String> aliceFriends = new ArrayList<>();
        aliceFriends.add("Bob");
        aliceFriends.add("Charlie");
        aliceFriends.add("test");
        friends.put("Alice", aliceFriends);

        List<String> bobFriends = new ArrayList<>();
        bobFriends.add("Alice");
        bobFriends.add("David");
        friends.put("Bob", bobFriends);

        List<String> charlieFriends = new ArrayList<>();
        charlieFriends.add("Alice");
        charlieFriends.add("David");
        friends.put("Charlie", charlieFriends);

        List<String> davidFriends = new ArrayList<>();
        davidFriends.add("Bob");
        davidFriends.add("Charlie");
        davidFriends.add("test");
        friends.put("David", davidFriends);

        List<String> testFriends = new ArrayList<>();
        davidFriends.add("Bob");
        davidFriends.add("Charlie");
        davidFriends.add("test");
        friends.put("test", davidFriends);
        return friends;
    }
}
