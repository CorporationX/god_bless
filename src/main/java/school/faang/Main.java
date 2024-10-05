package school.faang;

import school.faang.thirdTask.Example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List result = Example.reverse(numbers);
        System.out.println("ArrayList reversed : " + result);
    }
}
