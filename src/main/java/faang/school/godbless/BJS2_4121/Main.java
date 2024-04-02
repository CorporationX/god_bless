package faang.school.godbless.BJS2_4121;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 3, 4, 5);
        List<Integer> reversedArray = Example.reverse(array);

        System.out.println(array);
        System.out.println(reversedArray);
    }
}
