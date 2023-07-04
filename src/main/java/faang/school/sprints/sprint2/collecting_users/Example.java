package main.java.faang.school.sprints.sprint2.collecting_users;

public class Example {
    public static void reverse(int[] nums){
        for (int i = 0; i < nums.length / 2; i++) {
            int j = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = j;
        }
    }
}
