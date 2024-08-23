package faang.school.godbless.BJS2_22461;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StreamPracticeIITest {
    private final ByteArrayOutputStream OUTPUT_CAPTOR = new ByteArrayOutputStream();
    private final static PrintStream ORIGINAL_OUTPUT = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(OUTPUT_CAPTOR));
    }

    @Test
    void findUniquePairs() {
        var given = List.of(1, 9, 3, 6, 4, 5, 9, 1);
        var result = StreamPracticeII.findUniquePairs(given, 10);
        assertThat(result).contains(List.of(1, 9)).contains(List.of(4, 6)).hasSize(2);
    }

    @Test
    void sortCapitals() {
        var given = Map.of(
                "Russia", "Moscow",
                "Netherlands", "Amsterdam",
                "Germany", "Berlin",
                "Spain", "Madrid",
                "Italy", "Rome",
                "France", "Paris",
                "Belarus", "Minsk",
                "Czechia", "Prague",
                "Poland", "Warsaw",
                "Bulgaria", "Sofia"
        );
        var expectedOutput = """
                Minsk
                Sofia
                Prague
                Paris
                Berlin
                Rome
                Amsterdam
                Warsaw
                Moscow
                Madrid
                """;
        var result = StreamPracticeII.sortCapitals(given);
        assertThat(result.get(0)).isEqualTo("Minsk");
        assertThat(result.get(result.size() - 1)).isEqualTo("Madrid");
        assertThat(expectedOutput).isEqualTo(normalize(OUTPUT_CAPTOR.toString()));
        System.setOut(ORIGINAL_OUTPUT);
        System.out.println(OUTPUT_CAPTOR);
    }

    private String normalize(String s) {
        return s.replaceAll("\\r+", "");
    }

    @Test
    void filterAndSortStrings() {
        var given = List.of("Moscow", "Amsterdam", "Berlin", "Madrid", "Rome", "Paris", "Minsk",
                "Prague", "Warsaw", "Sofia");
        var result = StreamPracticeII.filterAndSortStrings(given, 'M');

        assertThat(result.get(0)).isEqualTo("Minsk");
        assertThat(result.get(result.size() - 1)).isEqualTo("Madrid");
        assertThat(result).hasSize(3);
    }

    @Test
    void findUniqueFriendPairs() {
        var given = Map.of(
                "Alice", List.of("Bob", "Charlie", "David"),
                "Bob", List.of("Alice", "Charlie", "Eve"),
                "Charlie", List.of("Alice", "Bob", "Frank"),
                "David", List.of("Alice", "Eve"),
                "Eve", List.of("Bob", "David", "Frank"),
                "Frank", List.of("Charlie", "Eve"));
        var expectedList = new ArrayList<>(
                List.of(
                        List.of("Eve", "Charlie"),
                        List.of("Eve", "Alice"),
                        List.of("David", "Bob"),
                        List.of("Frank", "Alice"),
                        List.of("David", "Charlie"),
                        List.of("Frank", "Bob"),
                        List.of("David", "Frank")
                )
        );
        var result = StreamPracticeII.findUniqueFriendPairs(given);

        assertThat(result).hasSize(7).allMatch(pair -> expectedList.stream().anyMatch(pair::containsAll));
    }

    @Test
    void findAverageSalaryByDepartment() {
        var employees = List.of(
                new Employee("Alice", 75000, "Engineering"),
                new Employee("Bob", 85000, "Engineering"),
                new Employee("Charlie", 70000, "Design"),
                new Employee("David", 95000, "Engineering"),
                new Employee("Eve", 105000, "Management"),
                new Employee("Frank", 68000, "Support"),
                new Employee("Grace", 80000, "Design"),
                new Employee("Hank", 120000, "Management"),
                new Employee("Ivy", 66000, "Support"),
                new Employee("Jack", 94000, "Engineering")
        );
        var result = StreamPracticeII.findAverageSalaryByDepartment(employees);

        assertThat(result).containsKeys("Engineering", "Design", "Management", "Support");
        assertThat(result.get("Engineering")).isEqualTo(87_250);
        assertThat(result.get("Design")).isEqualTo(75_000);
    }

    @Test
    void filterAndSortByAlphabet() {
        var strings = List.of("apple", "banana", "123", "dog", "cat");
        var alphabetStr = "abcdefghijklmnopqrstuvwxyz";
        var letters = new char[alphabetStr.length()];
        for (int i = 0; i < alphabetStr.length(); i++) {
            letters[i] = alphabetStr.charAt(i);
        }

        var result = StreamPracticeII.filterAndSortByAlphabet(strings, letters);
        assertThat(result).contains("dog", "cat", "apple", "banana").doesNotContain("123").hasSize(4);
    }

    @Test
    void convertToBinary() {
        var givenIntegers = List.of(23, 87, 12, 34, 56, 45, 78, 90, 11, 67, 88, 43, 19,
                54, 72);
        var expectedList = List.of(
                "10111", "1010111", "1100", "100010", "111000", "101101", "1001110", "1011010", "1011",
                "1000011", "1011000", "101011", "10011", "110110", "1001000"
        );
        var result = StreamPracticeII.convertToBinary(givenIntegers);

        assertThat(result).isEqualTo(expectedList).hasSize(givenIntegers.size());
    }

    @Test
    void findPalindromes() {
        var result = StreamPracticeII.findPalindromes(100, 200);
        var expectedList = List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
        assertThat(result).isEqualTo(expectedList).hasSize(10);
    }

    @Test
    void findPalindromeSubstrings() {
        var given = "Madam Arora teaches malayalam in civic duties, and she loves racecar rides";
        var result = StreamPracticeII.findPalindromeSubstrings(given);
        var expectedList = List.of("madam", "arora", "malayalam", "civic", "racecar");

        assertThat(result).isEqualTo(expectedList);
    }

    @Test
    void findPerfectNumbers() {
        var expectedList = List.of(6, 28, 496, 8128);
        var result = StreamPracticeII.findPerfectNumbers(1, 10000);

        assertThat(expectedList).isEqualTo(result);
    }
}