package faang.school.godbless.javacore.reverse;

import java.util.Arrays;

public class ReverseApp {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.printf("Nums before: %s\n", Arrays.toString(nums));
        new Example().reverse(nums);
        System.out.printf("Nums after: %s\n", Arrays.toString(nums));
    }

}
