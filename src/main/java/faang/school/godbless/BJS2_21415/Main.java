package faang.school.godbless.BJS2_21415;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        System.out.println(CalcProcessor.sum(list));
        System.out.println(CalcProcessor.product(list));
    }
}
