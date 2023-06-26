package faang.school.godbless.streamApi1;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Отсортировать список строк по длине
 */
public class Task6 {
    public static void main(String[] args) {
        Stream<String> animalStream = Stream.of("Dog", "Cat", "Elephant", "Giraffe", "Caracal");

        System.out.println(animalStream.sorted(Comparator.comparingInt(String::length)).toList());
    }
}
