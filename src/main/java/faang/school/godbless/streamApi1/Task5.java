package faang.school.godbless.streamApi1;

import java.util.stream.Stream;

/**
 * Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
 */
public class Task5 {
    public static void main(String[] args) {
        Stream<String> animalStream = Stream.of("Dog", "Cat", "Elephant", "Giraffe", "Caracal");

        System.out.println(animalStream.filter(n -> n.toLowerCase().contains("ca")).toList());
    }
}
