package faang.school.godbless;

import static faang.school.godbless.Example.reverse;

public class Application {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        reverse(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}