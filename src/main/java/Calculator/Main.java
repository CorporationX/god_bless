package Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        System.out.println(Operations.sum(nums));
        System.out.println(Operations.product(nums));
    }

}
