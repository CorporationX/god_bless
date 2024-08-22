package faang.school.godbless;

import java.util.*;

import static faang.school.godbless.ConvertToBinaryStrings.doBinariStrings;
import static faang.school.godbless.ListOfStringsStartingWithGivenLetter.stringList;
import static faang.school.godbless.Palindrome.findPolindromes;
import static faang.school.godbless.PalindromeSubstrings.findPalindromesSubstrings;
import static faang.school.godbless.SortingByAlphabet.sortByAlphabet;
import static faang.school.godbless.UniquePairOfNumbers.findUniquePairs;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,5,3,7,5,9);
        int target = 10;
        List<List<Integer>> pairs = findUniquePairs(numbers, target);
        pairs.forEach(System.out::println);

        Map<String, String> countriesAndCapitals = new HashMap<String, String>();
        countriesAndCapitals.put("Belgium", "Brussels");
        countriesAndCapitals.put("Belorus", "Minsk");
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("Germany", "Berlin");
        countriesAndCapitals.put("Poland", "Warsaw");
        countriesAndCapitals.put("USA", "Washington");
        List<String> sortedCapitals = CountriesAndCapitals.sortingCountriesAndCapitals(countriesAndCapitals);
        System.out.println("Capitals: ");
        sortedCapitals.forEach(System.out::println);

        List<String> strings = Arrays.asList(
                "apple",
                "banana",
                "avocado",
                "kiwi",
                "apricot"
        );
        char startLetters = 'a';
        List<String> result = stringList(strings, startLetters);
        System.out.println(result);

        List<Employee> employees = Arrays.asList(
                new Employee("Anton", 100000, "HR"),
                new Employee("Ivan", 57000, "Finance"),
                new Employee("Anna", 150600, "IT"),
                new Employee("Erik", 90000, "HR"),
                new Employee("Maria", 100000, "Finance"),
                new Employee("Oleg", 270000, "IT"),
                new Employee("Mihail", 130000, "HR"),
                new Employee("Yulia", 220000, "IT"),
                new Employee("Natasha", 105000, "Finance")
        );
        Map<String, Double> resultEverageSalary = Employee.averageSalariesByDept(employees);
        System.out.println(resultEverageSalary);

        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        List<String> inputStrings = Arrays.asList(
                "bright",
                "cat",
                "tree",
                "4327",
                "elephant",
                "House",
                "dog12",
                "at"
        );
        List<String> resultList = sortByAlphabet(inputStrings, alphabetString);
        System.out.println(resultList);

        List<Integer> inputIntegersList = Arrays.asList(1, 2, 33, 4, 5, 6, 57, 8, 9, 10);
        List<String> binaryString = doBinariStrings(inputIntegersList);
        System.out.println(binaryString);

        int start = 100;
        int end = 202;
        List<Integer> palindromes = findPolindromes(start, end);
        System.out.println(palindromes);

        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Max", Arrays.asList("Paul", "Anna", "Mary"));
        friendsMap.put("Paul", Arrays.asList("Max", "John", "Elena"));
        friendsMap.put("Anna", Arrays.asList("Mary", "Olga", "Irene"));
        friendsMap.put("Mary", Arrays.asList("Anna", "Max", "Dmitry"));
        friendsMap.put("John", Arrays.asList("Paul", "Oleg", "Kyle"));
        List<String> friendsOfFriends = FriendsOfFriends.lookingForFriendsOfFriends(friendsMap);
        friendsOfFriends.forEach(System.out::println);

        String stringPolindrom = "radar";
        List<String> resultPolindrom = findPalindromesSubstrings(stringPolindrom);
        System.out.println(resultPolindrom);
    }
}