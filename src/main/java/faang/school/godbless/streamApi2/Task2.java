package faang.school.godbless.streamApi2;

import java.util.List;
import java.util.Map;

/**
 * На вход получаем мапу с названиями стран и их столицами.
 * Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка
 */
public class Task2 {
    public static void main(String[] args) {
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "Afghanistan", "Kabul",
                "Lithuania", "Vilnius",
                "Bhutan", "Thimphu",
                "Cuba", "Havana"
        );

        List<String> list = countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();

        System.out.println(list); //[Kabul, Thimphu, Havana, Vilnius, Moscow]
    }
}
