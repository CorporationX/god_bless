package faang.school.godbless.streamApi1;

import java.util.stream.Stream;

/**
 * Преобразовать список строк в список их длин
 */
public class Task9 {
    public static void main(String[] args) {
        Stream<String> animalStream = Stream.of("Dog", "Cat", "Elephant", "Giraffe", "Caracal");

        System.out.println(animalStream.map(String::length).toList());
    }
}
