package faang.school.godbless.streamApi1;

import java.util.stream.Stream;

/**
 * Найти количество строк, начинающихся с определённого символа в списке строк
 */
public class Task4 {
    public static void main(String[] args) {
        Stream<String> animalStream = Stream.of("Dog", "Cat", "Elephant", "Giraffe", "Gorilla");

        System.out.println(animalStream.filter(n -> n.startsWith("G")).count());
    }
}
