package faang.school.godbless.streamApi2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
 * и отсортируйте их в порядке возрастания длины строк.
 */
public class Task6 {
    public static void main(String[] args) {
        List<String> strings = List.of("some", "string", "another", "programming", "anaconda", "ant");

        String[] alphabet = {"a", "n", "t"};

        System.out.println(getStrings(strings, alphabet));
    }

    public static List<String> getStrings(List<String> list, String[] alphabet) {
        List<String> result = new ArrayList<>();
        list.forEach(s -> addString(alphabet, result, s));

        return result.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    private static void addString(String[] alphabet, List<String> result, String s) {
        int counter = 0;
        for (String value : alphabet) {
            if (s.contains(value)) {
                counter++;
            }
        }
        if (counter == alphabet.length) {
            result.add(s);
        }
    }
}
