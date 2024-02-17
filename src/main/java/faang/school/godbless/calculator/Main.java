package faang.school.godbless.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = java.util.List.of( 1, 2, 3, 4, 5 );
        System.out.println( "sum of numbers " + sum( nums ) );
        System.out.println( "Muptiplication " + product( nums ) );
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException( "List is empty" );
        }
        int result = nums.get( 0 );
        for (int i = 1; i < nums.size(); i++) {
            result = (int) calculator.calculate( result, nums.get( i ) );
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate( nums, (x, y) -> x * y );
    }

    public static int sum(List<Integer> nums) {
        return calculate( nums, Integer::sum );
    }
}
