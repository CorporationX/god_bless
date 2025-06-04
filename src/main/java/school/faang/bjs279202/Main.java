package school.faang.bjs279202;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Example e = new Example();
        System.out.println(e.reverse(list));
    }
}
