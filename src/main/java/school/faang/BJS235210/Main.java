package school.faang.BJS235210;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> strings = List.of("apple", "banana", "cherry", "date");

//    Вход: [1, 2, 3, 4, 5, 6], целевое число: 7
//    Выход: [(1, 6), (2, 5), (3, 4)]
        System.out.println(ListOperations.getUniquePair(numbers, 7));

    }

}
