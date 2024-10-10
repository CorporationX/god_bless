package school.faang.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static school.faang.Calculator.Service.product;
import static school.faang.Calculator.Service.sum;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}
