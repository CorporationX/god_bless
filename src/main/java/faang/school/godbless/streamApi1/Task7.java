package faang.school.godbless.streamApi1;

import java.util.stream.Stream;

/**
 * Проверить, все ли элементы списка удовлетворяют определённому условию
 */
public class Task7 {
    public static void main(String[] args) {
        Stream<String> animalStream = Stream.of("Dog", "Cat", "Elephant", "Giraffe", "Caracal");

        System.out.println(animalStream.filter(n -> n.length() > 3).toList());
    }
}
