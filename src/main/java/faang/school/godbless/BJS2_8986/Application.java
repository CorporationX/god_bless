package faang.school.godbless.BJS2_8986;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        CalcOperations calcOperations = new CalcOperations();
        List<Integer> nums = Arrays.asList(1, 3, 5, 7, 9, 6, 2, 3, 1);
        calcOperations.product(nums);
        calcOperations.sum(nums);
    }
}