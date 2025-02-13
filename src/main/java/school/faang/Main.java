package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 5, 8, 76, 22, 90);
        System.out.println(Operations.sum(list1));
        System.out.println(Operations.product(list1));
    }
}
