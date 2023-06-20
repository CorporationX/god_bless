package faang.school.godbless.task6_calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    static Calculator sum = new Calculator() {
        @Override
        public int calculate(int res, int num) {
            return num + res;
        }

        @Override
        public int culcilateSpeshial(List<Integer> list) {
            int res = 0;
            for (int i : list) {
                res = calculate(i, res);
            }
            return res;
        }
    };
    static Calculator product = new Calculator() {
        @Override
        public int calculate(int res, int num) {
            return res * num;
        }

        @Override
        public int culcilateSpeshial(List<Integer> list) {
            int res = 1;
            for (int i : list) {
                res = calculate(i, res);
            }
            return res;
        }
    };

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(calculate(list, sum));
        System.out.println(calculate(list, product));
        sum(list);
        product(list);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        return calculator.culcilateSpeshial(nums);
    }

    public static int sum(List<Integer> nums) {
        int res = 0;
        for (int i : nums) {
            res = sum.calculate(res, i);
        }
        return res;
    }

    public static int product(List<Integer> nums) {
        int res = 1;
        for (int i : nums) {
            res = sum.calculate(res, i);
        }
        return res;
    }
}
