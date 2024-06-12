package faang.school.godbless.task_5;


public class Example {

    static void reverse(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            var j = nums.length - i - 1;
            if (i != j) {
                var temporaryNumber = nums[i];
                nums[i] = nums[j];
                nums[j] = temporaryNumber;
            } else {
                return;
            }
        }
    }
}
