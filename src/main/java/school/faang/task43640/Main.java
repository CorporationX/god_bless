package school.faang.task43640;

import school.faang.task43640.services.ArrayRevertor;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] nums = new int[]{100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111};
        System.out.println("Nums before: " + Arrays.toString(nums));

        int[] resultNums = ArrayRevertor.reverse(nums);
        System.out.println("Nums after: " + Arrays.toString(resultNums));
    }
}
