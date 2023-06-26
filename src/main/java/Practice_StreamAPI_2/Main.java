package Practice_StreamAPI_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 0, 4, 1, 3, 5, 6, 2, 4);
        System.out.println(PracticeStreamAPI_2.findPairsWhoseSumEqualsNumber(numbers, 4));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("Germany", "Berlin");
        countries.put("Montenegro", "Podgorica");
        System.out.println(PracticeStreamAPI_2.sortCapitalsAlphabetically(countries));

        List<String> strings = Arrays.asList("mom", "mobile", "medical", "butter", "baby", "boom", "bean");
        System.out.println(PracticeStreamAPI_2.sortStringsAlphabeticallyAndByLength(strings, 'm'));
        System.out.println(PracticeStreamAPI_2.sortStringsAlphabeticallyAndByLength(strings, 'b'));

        Map<String, List<String>> people = new HashMap<>();
        List<String> BobFriends = Arrays.asList("Sam", "Ivan", "Dasha");
        people.put("Bob", BobFriends);
        List<String> SamFriends = Arrays.asList("Bob", "Ivan", "Dasha");
        people.put("Sam", SamFriends);
        List<String> AliceFriends = Arrays.asList("Mat", "Ivan", "Dasha");
        people.put("Alice", AliceFriends);
        System.out.println(PracticeStreamAPI_2.findCommonFriendPairs(people));

        List<Employee> employees = Arrays.asList(
                new Employee("Bob", 1300.0, Department.HR),
                new Employee("Mike", 1400.0, Department.MARKETING),
                new Employee("John", 500.0, Department.MARKETING),
                new Employee("Ivan", 100.0, Department.HR),
                new Employee("Lisa", 2000.0, Department.MARKETING),
                new Employee("Jane", 1000.0, Department.SALES),
                new Employee("Carl", 900.0, Department.CUSTOMER_SUPPORT),
                new Employee("Seda", 800.0, Department.CUSTOMER_SUPPORT)
        );
        System.out.println(PracticeStreamAPI_2.createMapOfAverageSalaryByDepartment(employees));

        List<String> stringList = Arrays.asList("mona", "namo", "omnomnom", "ona", "nam", "nasmo", "sdfg");
        List<Character> abc = Arrays.asList('m', 'o', 'n', 'a');
        System.out.println(PracticeStreamAPI_2.filterStringsContainsLettersAndSortByLength(stringList, abc));

        System.out.println(PracticeStreamAPI_2.convertToBinary(numbers));

        System.out.println(Arrays.toString(PracticeStreamAPI_2.findAllNumberPalindromesInRange(100, 150)));

        String word = "abracadabra";
        System.out.println(PracticeStreamAPI_2.findPalindromeSubstrings(word));

        System.out.println(PracticeStreamAPI_2.findPerfectNumbersInRange(0,10000));
    }
}
