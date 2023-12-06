package faang.school.godbless;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] nums = { 1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
