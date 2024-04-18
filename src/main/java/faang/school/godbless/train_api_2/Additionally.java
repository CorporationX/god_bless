package faang.school.godbless.train_api_2;

import java.util.ArrayList;
import java.util.List;

public class Additionally {
    public static void main(String[] args) {
        int start = 1;
        int end = 10000;
        System.out.println("Совершенные числа от " + start + " до " + end + ": " + findPerfectNumbersInRange(start,end));
    }

    private static List<Integer> findPerfectNumbersInRange(int start, int end) {
        List<Integer> perfectNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPerfectNumber(i)) {
                perfectNumbers.add(i);
            }
        }
        return perfectNumbers;
    }

    private static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}
