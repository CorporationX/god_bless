package faang.school.godbless.streamApi2;

import java.util.Comparator;
import java.util.List;


/**
 * Получаем список строк и букву в виде char. Отфильтруйте строки,
 * которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания,
 * и верните список этих строк.
 *
 */
public class Task3 {
    public static void main(String[] args) {
        List<String> strings = List.of("some", "string", "another", "programming", "anaconda", "ant");

        System.out.println(getStrings(strings, 'a'));
    }

    public static List<String> getStrings(List<String> list, char ch) {
        return list.stream().filter(s -> s.startsWith(String.valueOf(ch))).sorted(Comparator.comparingInt(String::length)).toList();
    }
}
