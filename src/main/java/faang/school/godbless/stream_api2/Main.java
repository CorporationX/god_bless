package faang.school.godbless.stream_api2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //1.Найдите все уникальные пары чисел, сумма которых равна заданному числу.
        List<Integer> list = Arrays.asList(1, 9, 3, 6, 4, 5);
        findPairsWithSum(list, 10);

        //2.На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту,
        // а затем выведите названия их столиц в виде списка.
        Map<String, String> countries = Map.of(
                "Spain", "Madrid",
                "France", "Paris",
                "Italy", "Rome",
                "Germany", "Berlin"

        );
        getSortCountries(countries);

        //3.Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
        // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
        List<String> words = Arrays.asList("ball", "ocean", "theatre", "iron", "beef", "movie", "brave");
        char letter = 'b';
        System.out.println(getSortWordsByLengthAndStartWithGivenLetter(words, letter));

        //#4
        Map<String, List<String>> names = Map.of(
                "Mike", List.of("Bob", "Lola", "Bill"),
                "Tony", List.of("Elena", "Lola", "Maria"),
                "Robin", List.of("Aaron", "Elena", "Bill"),
                "Chris", List.of("Maria", "Bob", "John"),
        );
        getCommonFriends(names);
    }

    // #1
    public static void findPairsWithSum(List<Integer> numbers, int targetSum) {
        numbers.stream()
                .flatMap(num1 -> numbers.stream()
                        .filter(num2 -> num1 != num2)
                        .filter(num2 -> num1 + num2 == targetSum)
                        .map(num2 -> List.of(num1, num2).stream().sorted().collect(Collectors.toList()))
                )
                .distinct()
                .forEach(System.out::println);
    }
    //#2
    private static void getSortCountries(Map<String, String> countries) {
        countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    //#3
    private static List<String> getSortWordsByLengthAndStartWithGivenLetter(List<String> words, char letter) {
        return words.stream()
                .filter(s -> s.charAt(0) == letter)
                .sorted((s1,s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }
    //#4
    private static void getCommonFriends(Map<String, List<String>> names) {
        HashMap<String, String> pairs = new HashMap<>();
//        names.entrySet().stream()
//                .flatMap(person1 -> names.entrySet().stream()
//                        .filter()
    }

}
